package br.edu.ufcg.splab.experimentsExamples.core.dvcs;

import br.edu.ufcg.splab.arrsttFramework.IDvc;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;

/**
 * This class receives a TestSuite by constructor and then, on the collect
 * method, it receives the result of a selection technique on this suite.
 * The collect method returns in percentage how much of the original suite
 * remained.
 */
public class ReductionCollector implements IDvc {
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
