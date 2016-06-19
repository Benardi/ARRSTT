package br.edu.ufcg.splab.experiment_hierarchy.core.dvcs;

import java.util.HashSet;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;

public class RedundanceCollector implements InterfaceDvc {

	@Override
	public StringBuffer collect(TestSuite testSuite) {
		double result = getRedundance(testSuite);
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
