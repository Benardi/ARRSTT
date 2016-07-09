package br.edu.ufcg.splab.framework.core.dvcs.noexecution;

import java.util.HashSet;
import java.util.Set;

import br.edu.ufcg.splab.framework.core.api.InterfaceDvc;
import br.edu.ufcg.splab.graph.core.InterfaceEdge;
import br.edu.ufcg.splab.util.testcollections.TestCase;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

public class RedundanceCollector implements InterfaceDvc {
	private TestSuite originalSuite;
	
	public RedundanceCollector(TestSuite originalSuite) {
		this.originalSuite = originalSuite;
	}
	
	@Override
	public StringBuffer collect(TestSuite finalSuite) {
		double result = getRedundance(originalSuite);
		return new StringBuffer(result + "");
	}
	
	private double getRedundance(TestSuite ts) {
		int transitionsQnt = 0;
		Set<InterfaceEdge> uniqueLabels = new HashSet<>();
		for(TestCase tc: ts.getTestSuite()){
			transitionsQnt += tc.size();
			uniqueLabels.addAll(tc.getTestCase());
		}
		
		// tem que fazer - 1 no final?
		double redundance = (1.0 * transitionsQnt)/ uniqueLabels.size();
		return redundance;
		
	}

}
