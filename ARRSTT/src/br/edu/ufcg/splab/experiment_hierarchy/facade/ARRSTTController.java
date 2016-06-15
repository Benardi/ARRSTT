package br.edu.ufcg.splab.experiment_hierarchy.facade;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.exceptions.ARRSTTException;
import br.edu.ufcg.splab.experiment_hierarchy.ExperimentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.core.artifacts.TestArtifact;
import br.edu.ufcg.splab.experiment_hierarchy.core.experiments.Experiment;
import br.edu.ufcg.splab.experiment_hierarchy.io.IOClass;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.factories.MinimizationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.ArtifactBuilder;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.GenerationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.ReqBuilderType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;
import br.edu.ufcg.splab.experiment_hierarchy.util.factories.DVCFactory;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-30
 * 
 */

/**
 * <b>Objective:</b> This class is used by the facade to create and run ARRSTT's experiments,
 * such as selection experiment and generation experiment.
 * <br>
 * <b>Description of use:<b> It's only public method is execute() that is responsible for the
 * creation and execution of ARRSTT's experiments.
 *
 */
public class ARRSTTController {	
	private IOClass io;
	private String outputFolder;
	private Experiment experiment;
	private ExperimentFactory experimentFactory;
	private DVCFactory dvcFactory;
	private List<TestSuite> input;
	private ArtifactBuilder artifactBuilder;
	
	/**
	 * The controller's constructor. Initializes the needed lists and factories.
	 */
	public ARRSTTController() {
		this.experimentFactory = new ExperimentFactory();
		this.dvcFactory = new DVCFactory();
		this.io = new IOClass();
		this.input = new ArrayList<TestSuite>();
		this.artifactBuilder = new ArtifactBuilder();
	}
	
	public void setInput(String[] paths) {
		try {
			input = io.getTestSuites(paths);
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to define artifacts. " + e.getMessage());
		}
	}
	
	public void setInput(File[] files) {
		try {
			input = io.getTestSuites(files);
		} catch(Exception e) {
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to define artifacts. " + e.getMessage());
		}
	}
	
	/*public void setupGenerationExperiment(String[] techniques, String[] dvcs, Integer[] loopCoverages) {
		try {
			List<GenerationType> parsedTechniques = getGenerationTechniques(techniques);
			List<DVCType> parsedDvcs = getDvcs(dvcs);
			List<Integer> parsedLoopCoverages = Arrays.asList(loopCoverages);
			experiment = experimentFactory.buildGeneration(parsedLoopCoverages, parsedTechniques, parsedDvcs);
		} catch(Exception e) {
			throw new ARRSTTException("Error while trying to setup a generation experiment. " + e.getMessage());
		}
	}*/
	
	public void setupSelectionExperiment(String[] techniques, String[] dvcs, double selPercentage) {
		try {
			List<SelectionType> parsedTechniques = getSelectionTechniques(techniques);
			List<TestArtifact> artifacts = artifactBuilder.buildArtifacts(input, dvcs);
			experiment = experimentFactory.buildSelection(artifacts, parsedTechniques, selPercentage);
		} catch(Exception e) {
			throw new ARRSTTException("Error while trying to setup a selection experiment. " + e.getMessage());
		}
	}
	
	public void setupMinimizationExperiment(String[] techniques, String[] dvcs, String coverage) {
		try {
			List<MinimizationType> parsedTechniques = getMinimizationTechniques(techniques);
			List<TestArtifact> artifacts = artifactBuilder.buildArtifacts(input, dvcs);
			ReqBuilderType parsedCoverage = getCoverage(coverage);
			experiment = experimentFactory.buildMinimization(artifacts, parsedTechniques, parsedCoverage);			
		} catch(Exception e) {
			throw new ARRSTTException("Error while trying to setup a minimization experiment. " + e.getMessage());
		}
	}
	
	public void setupNoneExperiment(String[] dvcs) {
		try {
			List<TestArtifact> artifacts = artifactBuilder.buildArtifacts(input, dvcs);
			experiment = experimentFactory.buildNone(artifacts);
		} catch(Exception e) {
			throw new ARRSTTException("Error while trying to setup a none experiment. " + e.getMessage());
		}
	}
	
	public void execute(String[] dvcs) {
		try {
			experiment.execute();
			io.saveData(experiment.getBenchmarkData(), experiment.getDvcData(), dvcs, outputFolder);
			System.out.println("Results generated with success");
		} catch(Exception e) {
			throw new ARRSTTException("Error while trying to execute a experiment. " + e.getMessage());
		}
	}
	
	public void setOutputFolder(String path) {
		this.outputFolder = path;
	}
	
	private ReqBuilderType getCoverage(String coverage) {
		try {
			return ReqBuilderType.valueOf(coverage);
		} catch(IllegalArgumentException ie) {
			throw new ARRSTTException("Coverage criteria " + coverage + " not found.");
		} catch(NullPointerException ne) {
			throw new ARRSTTException("Coverage criteria name cannot be null.");
		}
	}
	
	private List<GenerationType> getGenerationTechniques(String[] techniques) {
		List<GenerationType> parsedTechniques = new ArrayList<GenerationType>();
		
		for (String technique : techniques) {
			parsedTechniques.add(getGenerationTechnique(technique));
		}
		
		return parsedTechniques;
	}
	
	private List<SelectionType> getSelectionTechniques(String[] techniques) {
		List<SelectionType> parsedTechniques = new ArrayList<SelectionType>();
		
		for (String technique : techniques) {
			parsedTechniques.add(getSelectionTechnique(technique));
		}
		
		return parsedTechniques;
	}
	
	private List<MinimizationType> getMinimizationTechniques(String[] techniques) {
		List<MinimizationType> parsedTechniques = new ArrayList<MinimizationType>();
		
		for (String technique : techniques) {
			parsedTechniques.add(getMinimizationTechnique(technique));
		}
		
		return parsedTechniques;
	}
	
	private GenerationType getGenerationTechnique(String technique) {
		try {
			return GenerationType.valueOf(technique);
		} catch(IllegalArgumentException ie) {
			throw new ARRSTTException("Technique " + technique + " not found.");
		} catch(NullPointerException ne) {
			throw new ARRSTTException("Technique name cannot be null.");
		}
	}
	
	private SelectionType getSelectionTechnique(String technique) {
		try {
			return SelectionType.valueOf(technique);
		} catch(IllegalArgumentException ie) {
			throw new ARRSTTException("Technique " + technique + " not found.");
		} catch(NullPointerException ne) {
			throw new ARRSTTException("Technique name cannot be null.");
		}
	}
	
	private MinimizationType getMinimizationTechnique(String technique) {
		try {
			return MinimizationType.valueOf(technique);
		} catch(IllegalArgumentException ie) {
			throw new ARRSTTException("Technique " + technique + " not found.");
		} catch(NullPointerException ne) {
			throw new ARRSTTException("Technique name cannot be null.");
		}
	}
}
