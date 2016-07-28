package br.edu.ufcg.splab.experimentsExamples.core.setups;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.IDvc;
import br.edu.ufcg.splab.arrsttFramework.IExecutableTreatment;
import br.edu.ufcg.splab.arrsttFramework.ISetup;
import br.edu.ufcg.splab.arrsttFramework.util.Artifact;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.FailuresByFileCollector;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.FinalSizeCollector;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.FinalSuiteCollector;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.ReductionCollector;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.benchmarks.TimeBenchmark;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.noexecution.MediaMaxMinCollector;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.builders.RequirementBuilder;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.factories.MinimizationTechniques;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.factories.MinimizationTechniquesFactory;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.techniques.InterfaceMinimizationTechnique;
import br.edu.ufcg.splab.experimentsExamples.util.enums.RequirementBuilders;
import br.edu.ufcg.splab.experimentsExamples.util.factories.RequirementBuilderFactory;
import br.edu.ufcg.splab.experimentsExamples.util.factories.TreatmentFactory;

//WORK IN PROGRESS
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Documentation												José Benardi		2016-07-12
 * 
 */
/**
 * <b>Objective:</b> This class represents the process of setting up an
 * experiment to properly run the techniques referent to minimization.
 * previously set. <br>
 * <b>Description of use:</b> This class is used to set up an Experiment that
 * will run Minimization techniques.
 *
 */
public class MyMinimizationSetup implements ISetup {
	private List<MinimizationTechniques> enumMinimizationTechniques;
	private RequirementBuilders enumBuilder;
	private List<TestSuite> testSuites;
	private File[] failureFiles;
	private int replications;

	/**
	 * MyMinimizationSetup's constructor.
	 * 
	 * @param testSuites
	 *            The list of Test Suite used in the Minimization.
	 * @param enumMinimizationTechniques
	 *            The list of minimization techniques used in this set up.
	 * @param enumBuilder
	 *            What type of coverage will be followed.
	 * @param failureFiles
	 *            The files where failures will be stored.
	 * @param replications
	 *            How many times the experiment will be replicated.
	 */
	public MyMinimizationSetup(List<TestSuite> testSuites, List<MinimizationTechniques> enumMinimizationTechniques,
			RequirementBuilders enumBuilder, File[] failureFiles, int replications) {
		this.enumMinimizationTechniques = enumMinimizationTechniques;
		this.testSuites = testSuites;
		this.failureFiles = failureFiles;
		this.enumBuilder = enumBuilder;
		this.replications = replications;
	}

	/**
	 * <b>Objective:</b> Retrieve the experiment's artifacts. <br>
	 * <b>Example of use:</b> In this class this method is used to generate the
	 * artifacts that match the states of this class.
	 * 
	 * @return artifacts
	 */
	@Override
	public List<Artifact> getArtifacts() {

		TreatmentFactory treatmentFactory = new TreatmentFactory();
		MinimizationTechniquesFactory minimizationFactory = new MinimizationTechniquesFactory();
		RequirementBuilderFactory reqBuilderFactory = new RequirementBuilderFactory();

		List<Artifact> artifacts = new ArrayList<Artifact>();

		for (int j = 0; j < testSuites.size(); j++) {
			for (int i = 0; i < enumMinimizationTechniques.size(); i++) {
				for (int k = 0; k <= replications; k++) {
					RequirementBuilder builder = reqBuilderFactory.createRequirementBuilder(testSuites.get(j),
							enumBuilder);
					InterfaceMinimizationTechnique minimizationTechnique = minimizationFactory
							.createMinimizationTechnique(enumMinimizationTechniques.get(i), testSuites.get(j),
									builder.getRequirements());

					IExecutableTreatment treatment = treatmentFactory.createMinimization(minimizationTechnique);
					List<IDvc> dvcs = new ArrayList<IDvc>();
					dvcs.add(new FailuresByFileCollector(findRightFile(testSuites.get(j))));
					dvcs.add(new ReductionCollector(new TestSuite(testSuites.get(j))));
					dvcs.add(new FinalSizeCollector());
					dvcs.add(new FinalSuiteCollector());
					dvcs.add(new TimeBenchmark());
					dvcs.add(new MediaMaxMinCollector(testSuites.get(j)));

					artifacts.add(new Artifact(treatment, dvcs));
				}
			}
		}
		return artifacts;
	}

	/**
	 * <b>Objective:</b> Retrieve the file that match a test suite. <br>
	 * 
	 * @param testSuite
	 *        		The Test Suite that has a failure file.
	 * @return rightFile 
	 * 				The File that correspond to the Test Suite searched.
	 */
	private File findRightFile(TestSuite testSuite) {
		File rightFile = null;

		if (testSuite.getID().equals("noid")) {
			return null;
		}

		for (int i = 0; i < failureFiles.length; i++) {
			if ((testSuite.getID() + "_failures.txt").equalsIgnoreCase(failureFiles[i].getName())) {
				rightFile = failureFiles[i];
			}
		}

		return rightFile;
	}
}
