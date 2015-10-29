package br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations.interfaces.RequirementTracer;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestRequirementARRSTT;
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
	
	public Map<TestRequirementARRSTT, Set<TestCase>> getMap() {
		Map<TestRequirementARRSTT, Set<TestCase>> map = new HashMap<TestRequirementARRSTT, Set<TestCase>>();
		fillKeys(map);
		fillValues(map);
		
		return map;
	}
	
	private void fillKeys(Map<TestRequirementARRSTT, Set<TestCase>> map) {
		Set<InterfaceEdge> keys = new HashSet<InterfaceEdge>();
		
		for (TestCase tc : ts) {
			for (InterfaceEdge edge : tc) { 
				keys.add(edge);
			}
		}
		
		for (InterfaceEdge edge : keys) {
			List<InterfaceEdge> edges = new ArrayList<InterfaceEdge>();
			edges.add(edge);
			TestRequirementARRSTT requirement = new TestRequirementARRSTT(edges);
			map.put(requirement, new HashSet<TestCase>())	;
		}
	}
	
	private void fillValues(Map<TestRequirementARRSTT, Set<TestCase>> map) {
		for (TestCase tc : ts) {
			for (InterfaceEdge edge : tc) {
				List<InterfaceEdge> edges = new ArrayList<InterfaceEdge>();
				edges.add(edge);
				TestRequirementARRSTT requirement = new TestRequirementARRSTT(edges);
				map.get(requirement).add(tc);
			}
		}
	}
	
	
}
