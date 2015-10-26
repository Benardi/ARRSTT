package br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;

public class ReqTracerAllTransitionsCoverage {
	private TestSuite ts;
	
	public ReqTracerAllTransitionsCoverage(TestSuite ts) {
		this.ts =  ts;
	}
	
	public Map<List<InterfaceEdge>, Set<TestCase>> getMap() {
		Map<List<InterfaceEdge>, Set<TestCase>> map = new HashMap<List<InterfaceEdge>, Set<TestCase>>();
		fillKeys(map);
		fillValues(map);
		
		return map;
	}
	
	private void fillKeys(Map<List<InterfaceEdge>, Set<TestCase>> map) {
		Set<InterfaceEdge> keys = new HashSet<InterfaceEdge>();
		
		for (TestCase tc : ts) {
			for (InterfaceEdge edge : tc) { 
				keys.add(edge);
			}
		}
		
		for (InterfaceEdge edge : keys) {
			List<InterfaceEdge> edges = new ArrayList<InterfaceEdge>();
			edges.add(edge);
			map.put(edges, new HashSet<TestCase>());
		}
	}
	
	private void fillValues(Map<List<InterfaceEdge>, Set<TestCase>> map) {
		for (TestCase tc : ts) {
			for (InterfaceEdge edge : tc) {
				List<InterfaceEdge> edges = new ArrayList<InterfaceEdge>();
				edges.add(edge);
				map.get(edges).add(tc);
			}
		}
	}
	
	
}
