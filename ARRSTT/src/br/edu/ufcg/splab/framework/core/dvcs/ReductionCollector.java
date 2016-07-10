package br.edu.ufcg.splab.framework.core.dvcs;

import br.edu.ufcg.splab.framework.core.api.InterfaceDvc;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

/**
 * This class receives a TestSuite by constructor and then, on the collect
 * method, it receives the result of a selection technique on this suite.
 * The collect method returns in percentage how much of the original suite
 * remained.
 */
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
