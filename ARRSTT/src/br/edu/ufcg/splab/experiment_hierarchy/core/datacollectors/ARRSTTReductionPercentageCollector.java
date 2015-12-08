package br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class ARRSTTReductionPercentageCollector implements DependentVariableCollector {
	private TestSuite originalTestSuite;
	
	public ARRSTTReductionPercentageCollector(TestSuite originalTestSuite) {
		this.originalTestSuite = originalTestSuite;
	}
	
	@Override
	public StringBuffer collect(Tuple<ExecutableTreatment> treatment) {
		int reduction = originalTestSuite.size() - treatment.get(0).execute().size();
		double reductionPercentage = ((double) reduction) / originalTestSuite.size();
		
		return new StringBuffer(reductionPercentage + "");
	}
	
}
