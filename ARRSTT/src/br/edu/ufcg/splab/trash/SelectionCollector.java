package br.edu.ufcg.splab.trash;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.ErrorStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.ExperimentFile;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class SelectionCollector implements DependentVariableCollector {
	private ExperimentFile failureFile;
	private ExperimentFile timeFile;
	private ExperimentFile defectFile;

	public SelectionCollector() {
		this.timeFile = new ExperimentFile("Times");
		this.failureFile = new ExperimentFile("Failures");
		this.defectFile = new ExperimentFile("Defects");
	}
	
	@Override
	public void collect(ExecutableTreatment treatment) {
		Long initTime = System.nanoTime();
		TestSuite testSuite = treatment.execute();
		Long endTime = System.nanoTime();

		Long timeDif = (endTime - initTime);
		
		ErrorStructure errorStructure = new ErrorStructure(testSuite);
		
		timeFile.appendContent(timeDif + "\t");
		failureFile.appendContent(errorStructure.countFails() + "\t");
		defectFile.appendContent(errorStructure.countDefects() + "\t");
	}
}
