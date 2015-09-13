package br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class ARRSTTTimeCollector implements DependentVariableCollector {

	@Override
	public void collect(Tuple<ExecutableTreatment> treatment,
			StringBuffer content) {
		Long initTime = System.nanoTime();
		TestSuite testSuite = treatment.get(0).execute();
		Long endTime = System.nanoTime();
		
		content.append(endTime - initTime + "\t");
	}

}
