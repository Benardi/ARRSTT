package br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations.interfaces.RequirementTracer;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-10-26
 * 
 */
public class ReqTracerAllTransitionsCoverage implements RequirementTracer{
	private TestSuite ts;
	
	public ReqTracerAllTransitionsCoverage(TestSuite ts) {
		this.ts =  ts;
	}
	
	public Map<TestRequirement, Set<TestCase>> getMap() {
		Map<TestRequirement, Set<TestCase>> map = new HashMap<TestRequirement, Set<TestCase>>();
		fillKeys(map);
		fillValues(map);
		
		return map;
	}
	
	private void fillKeys(Map<TestRequirement, Set<TestCase>> map) {
		Set<InterfaceEdge> keys = new HashSet<InterfaceEdge>();
		
		for (TestCase tc : ts) {
			for (InterfaceEdge edge : tc) { 
				keys.add(edge);
			}
		}
		
		for (InterfaceEdge edge : keys) {
			TestRequirement edges = new TestRequirement();
			edges.add(edge);
			map.put(edges, new HashSet<TestCase>());
		}
	}
	
	private void fillValues(Map<TestRequirement, Set<TestCase>> map) {
		for (TestCase tc : ts) {
			for (InterfaceEdge edge : tc) {
				TestRequirement edges = new TestRequirement();
				edges.add(edge);
				map.get(edges).add(tc);
			}
		}
	}
	
	
}
