package br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.ErrorStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class ARRSTTDefectsCollector implements DependentVariableCollector {

	@Override
	public void collect(Tuple<ExecutableTreatment> treatment,
			StringBuffer content) {
		TestSuite testSuite = treatment.get(0).execute();
		
		ErrorStructure errorStructure = new ErrorStructure(testSuite);
		content.append(errorStructure.countFails() + "\t");
	}

}
