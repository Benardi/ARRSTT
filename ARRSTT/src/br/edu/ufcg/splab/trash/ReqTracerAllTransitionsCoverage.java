package br.edu.ufcg.splab.trash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.requirements.ARRSTTTestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
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
	
	public Map<ARRSTTTestRequirement, Set<TestCase>> getMap() {
		Map<ARRSTTTestRequirement, Set<TestCase>> map = new HashMap<ARRSTTTestRequirement, Set<TestCase>>();
		fillKeys(map);
		fillValues(map);
		
		return map;
	}
	
	private void fillKeys(Map<ARRSTTTestRequirement, Set<TestCase>> map) {
		Set<InterfaceEdge> keys = new HashSet<InterfaceEdge>();
		
		for (TestCase tc : ts) {
			for (InterfaceEdge edge : tc) { 
				keys.add(edge);
			}
		}
		
		for (InterfaceEdge edge : keys) {
			List<InterfaceEdge> edges = new ArrayList<InterfaceEdge>();
			edges.add(edge);
			ARRSTTTestRequirement requirement = new ARRSTTTestRequirement(edges);
			map.put(requirement, new HashSet<TestCase>());
		}
	}
	
	private void fillValues(Map<ARRSTTTestRequirement, Set<TestCase>> map) {
		for (TestCase tc : ts) {
			for (InterfaceEdge edge : tc) {
				List<InterfaceEdge> edges = new ArrayList<InterfaceEdge>();
				edges.add(edge);
				ARRSTTTestRequirement requirement = new ARRSTTTestRequirement(edges);
				
				if (!map.keySet().contains(requirement)) {
					map.put(requirement, new HashSet<TestCase>());
				}
				
				map.get(requirement).add(tc);
			}
		}
	}
	
	
}
