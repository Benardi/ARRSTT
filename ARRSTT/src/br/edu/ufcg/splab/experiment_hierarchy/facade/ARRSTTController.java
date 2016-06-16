package br.edu.ufcg.splab.experiment_hierarchy.facade;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.ufcg.splab.exceptions.ARRSTTException;
import br.edu.ufcg.splab.experiment_hierarchy.ExperimentFactory;
import br.edu.ufcg.splab.experiment_hierarchy.core.experiments.Experiment;
import br.edu.ufcg.splab.experiment_hierarchy.io.IOClass;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.factories.MinimizationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.ArtifactBuilder;
import br.edu.ufcg.splab.experiment_hierarchy.util.ExperimentData;
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
	
	public void runNeoSelectionExperiment(String[] paths){
		try{
			Experiment experiment = experimentFactory.buildNeoSelection(input, io.getFiles(paths));
			List<ExperimentData> datas = experiment.execute();
			io.saveData(datas, outputFolder);
		} catch (Exception e){
			e.printStackTrace();
			throw new ARRSTTException("Error while trying to setup Neo Selection Experiment. " + e.getMessage());
		}
		
		
		
		
	}
	
	public void setOutputFolder(String path) {
		this.outputFolder = path;
	}
}
