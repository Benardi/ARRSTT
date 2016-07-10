package br.edu.ufcg.splab.framework.core.dvcs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.edu.ufcg.splab.framework.core.api.InterfaceDvc;
import br.edu.ufcg.splab.graph.core.InterfaceEdge;
import br.edu.ufcg.splab.util.testcollections.TestCase;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

/**
 * This class receives a TestSuite by constructor and then, on the collect
 * method, it receives the result of a selection technique on this suite.
 * Then, it returns how many unique transitions the changed TestSuite still
 * covers, comparing with the original one. This data is saved as a percentage.
 */
public class CoverageCollector implements InterfaceDvc{
	Set<InterfaceEdge> originalTransitionSet;
	
	public CoverageCollector(TestSuite ts){
		originalTransitionSet = transformToSet(ts);
	}
	
	
	private Set<InterfaceEdge> transformToSet(TestSuite ts) {
		List<TestCase> testCases = ts.getTestSuite();
		Set<InterfaceEdge> transitionSet = new HashSet<>();
		for(TestCase tc: testCases){
			transitionSet.addAll(tc.getTestCase());
		}
		return transitionSet;
	}


	@Override
	public StringBuffer collect(TestSuite t) {
		Set<InterfaceEdge> changedTestSuite = transformToSet(t);
		double result = 1.0* changedTestSuite.size() / originalTransitionSet.size();
		return new StringBuffer(String.format("%.2f", result));
	}



}
