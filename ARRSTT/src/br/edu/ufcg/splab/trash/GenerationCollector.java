package br.edu.ufcg.splab.trash;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.ExperimentFile;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class GenerationCollector implements DependentVariableCollector {
	/**
	 * This object is used to produce a list of graphs with the same amount of
	 * low on branch graphs and high on branch graphs.
	 */
	private ExperimentFile tsSizeFile;
	/**
	 * Represents a file containing times in which search calls took to return a
	 * testSuite.
	 */
	private ExperimentFile timeFile;
	

	public GenerationCollector() {
		this.tsSizeFile = new ExperimentFile("Sizes");
		this.timeFile = new ExperimentFile("Times");
	}
	
	@Override
	public void collect(ExecutableTreatment treatment) {
		Long initTime = System.nanoTime();
		TestSuite testSuite = treatment.execute();
		Long endTime = System.nanoTime();

		Long timeDif = (endTime - initTime);

		timeFile.appendContent(timeDif + "\t");
		tsSizeFile.appendContent(testSuite.size() + "\t");
	}
}
