package br.edu.ufcg.splab.framework.core.dvcs;

import br.edu.ufcg.splab.framework.core.api.InterfaceDvc;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

public class ReductionCollector implements InterfaceDvc {
	private TestSuite originalTestSuite;
	
	public ReductionCollector(TestSuite originalTestSuite) {
		this.originalTestSuite = originalTestSuite;
	}
	
	@Override
	public StringBuffer collect(TestSuite testSuite) {
		int reduction = originalTestSuite.size() - testSuite.size();
		double reductionPercentage = ((double) reduction) / originalTestSuite.size();
		return new StringBuffer(String.format("%.2f", reductionPercentage).replaceFirst(",", "."));
	}
	
}
