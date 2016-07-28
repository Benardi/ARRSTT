package br.edu.ufcg.splab.experimentsExamples.core.setups;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.IDvc;
import br.edu.ufcg.splab.arrsttFramework.IExecutableTreatment;
import br.edu.ufcg.splab.arrsttFramework.ISetup;
import br.edu.ufcg.splab.arrsttFramework.util.Artifact;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.CoverageCollector;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.FailuresByFileCollector;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.FinalSizeCollector;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.FinalSuiteCollector;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.ReductionCollector;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.benchmarks.TimeBenchmark;
import br.edu.ufcg.splab.experimentsExamples.core.dvcs.noexecution.MediaMaxMinCollector;
import br.edu.ufcg.splab.experimentsExamples.techniques.selection.InterfaceSelectionTechnique;
import br.edu.ufcg.splab.experimentsExamples.util.factories.TreatmentFactory;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Documentation												José Benardi		2016-07-12
 * 
 */
/**
 * <b>Objective:</b> This class represents the process of setting up an
 * experiment to properly run the techniques referent to selection. previously
 * set. <br>
 * <b>Description of use:</b> This class is used to set up an Experiment that
 * will run Selection techniques.
 *
 */
public class MySelectionSetup implements ISetup {
	private List<InterfaceSelectionTechnique> selectionTechniques;
	private List<TestSuite> testSuites;
	private File[] failureFiles;
	private double selectionPercentage;
	private int replications;
	
	/**
	 * MySelectionSetup's constructor.
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
	public MySelectionSetup(List<TestSuite> testSuites, List<InterfaceSelectionTechnique> selectionTechniques,
			double selectionPercentage, File[] failureFiles, int replications) {
		this.selectionTechniques = selectionTechniques;
		this.selectionPercentage = selectionPercentage;
		this.testSuites = testSuites;
		this.failureFiles = failureFiles;
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
		List<Artifact> artifacts = new ArrayList<Artifact>();

		for (int j = 0; j < testSuites.size(); j++) {
			for (int k = 0; k <= replications; k++) {
				for (int i = 0; i < selectionTechniques.size(); i++) {

					IExecutableTreatment treatment = treatmentFactory.createSelection(selectionTechniques.get(i),
							testSuites.get(j), selectionPercentage);

					List<IDvc> dvcs = new ArrayList<IDvc>();

					dvcs.add(new FailuresByFileCollector(failureFiles[j]));
					dvcs.add(new ReductionCollector(new TestSuite(testSuites.get(j))));
					dvcs.add(new FinalSizeCollector());
					dvcs.add(new FinalSuiteCollector());
					dvcs.add(new TimeBenchmark());
					dvcs.add(new MediaMaxMinCollector(testSuites.get(j)));
					dvcs.add(new CoverageCollector(new TestSuite(testSuites.get(j))));

					artifacts.add(new Artifact(treatment, dvcs));
				}
			}
		}

		return artifacts;
	}
}
