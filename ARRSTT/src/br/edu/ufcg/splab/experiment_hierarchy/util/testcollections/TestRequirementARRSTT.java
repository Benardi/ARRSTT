package br.edu.ufcg.splab.experiment_hierarchy.util.testcollections;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements.TestRequirement;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Iaron Araujo		2015-10-28
 * 
 */
public class TestRequirementARRSTT implements TestRequirement {
	
	private List<InterfaceEdge> transitions;
	
	public TestRequirementARRSTT(List<InterfaceEdge> transitions) {
		this.transitions = transitions;
	}
	
	public List<InterfaceEdge> getTransitions(){
		return transitions;
	}

	@Override
	public boolean cover(TestCase tc) {
		boolean covers = true;
		
		for (InterfaceEdge transition : transitions) {
			if (!tc.contains(transition)) return false;
		}
		
		return covers;
	}

}
