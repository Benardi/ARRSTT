package br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class ARRSTTSizeCollector implements DependentVariableCollector {

	@Override
	public void collect(Tuple<ExecutableTreatment> treatment,
			StringBuffer content) {
		TestSuite testSuite = treatment.get(0).execute();	
		content.append(testSuite.size() + "\t");
	}

}
