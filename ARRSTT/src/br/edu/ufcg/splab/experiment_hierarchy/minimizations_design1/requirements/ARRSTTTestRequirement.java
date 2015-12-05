package br.edu.ufcg.splab.experiment_hierarchy.minimizations_design1.requirements;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Iaron Araujo		2015-10-28
 * 
 */
public class ARRSTTTestRequirement implements TestRequirement {
	
	private List<InterfaceEdge> transitions;
	
	public ARRSTTTestRequirement(List<InterfaceEdge> transitions) {
		this.transitions = transitions;
	}
	
	public ARRSTTTestRequirement(InterfaceEdge transition) {
		this.transitions = new ArrayList<InterfaceEdge>();
		this.transitions.add(transition);
	}
	
	public List<InterfaceEdge> getTransitions(){
		return transitions;
	}

	@Override
	public boolean isCoveredBy(TestCase tc) {
		return 	tc.containsAll(transitions);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((transitions == null) ? 0 : transitions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ARRSTTTestRequirement other = (ARRSTTTestRequirement) obj;
		if (transitions == null) {
			if (other.transitions != null)
				return false;
		} else if (!transitions.equals(other.transitions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String output = "";
		
		for (InterfaceEdge edge : transitions) {
			output += edge + " ";
		}
		
		return output;
	}
	
	
}
