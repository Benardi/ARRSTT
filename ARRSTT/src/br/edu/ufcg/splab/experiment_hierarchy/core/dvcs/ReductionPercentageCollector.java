package br.edu.ufcg.splab.experiment_hierarchy.core.dvcs;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class ReductionPercentageCollector implements InterfaceDvc {
	private TestSuite originalTestSuite;
	
	public ReductionPercentageCollector(TestSuite originalTestSuite) {
		this.originalTestSuite = originalTestSuite;
	}
	
	@Override
	public StringBuffer collect(TestSuite testSuite) {
		int reduction = originalTestSuite.size() - testSuite.size();
		double reductionPercentage = ((double) reduction) / originalTestSuite.size();
		return new StringBuffer(String.format("%.2f", reductionPercentage).replaceFirst(",", "."));
	}
	
}
