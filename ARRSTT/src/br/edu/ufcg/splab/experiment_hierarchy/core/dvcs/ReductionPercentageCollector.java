package br.edu.ufcg.splab.experiment_hierarchy.core.dvcs;

import java.text.DecimalFormat;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class ReductionPercentageCollector implements InterfaceDvc {
	private TestSuite originalTestSuite;
	private DecimalFormat df;
	
	public ReductionPercentageCollector(TestSuite originalTestSuite) {
		this.originalTestSuite = originalTestSuite;
		this.df = new DecimalFormat("0.00");
	}
	
	@Override
	public StringBuffer collect(TestSuite testSuite) {
		int reduction = originalTestSuite.size() - testSuite.size();
		double reductionPercentage = ((double) reduction) / originalTestSuite.size();
		
		return new StringBuffer(df.format(reductionPercentage));
	}
	
}
