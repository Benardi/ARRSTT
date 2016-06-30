package br.edu.ufcg.splab.experiment_hierarchy.core.dvcs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;

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
