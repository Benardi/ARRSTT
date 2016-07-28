package br.edu.ufcg.splab.experimentsExamples.core.dvcs.noexecution;

import java.util.HashSet;
import java.util.Set;

import br.edu.ufcg.splab.arrsttFramework.IDvc;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestCase;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.graph.core.InterfaceEdge;
//WORK IN PROGRESS
public class RedundanceCollector implements IDvc {
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
	
	@Override
	public String getName(){
		return "Redundance";
	}

}
