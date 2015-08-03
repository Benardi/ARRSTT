package br.edu.ufcg.splab.experiment_hierarchy.util;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph.core.InterfaceEdge;

public class FailureCounter {
	private static String[] failures = {"ERROR"};
	private List<String> failuresDetected;
	
	public int countFails(TestSuite ts) {
		failuresDetected = new ArrayList<String>();
		
		for (TestCase tc : ts) {
			for (InterfaceEdge edge : tc) {
				for (String fail : failures) {
					if (edge.getLabel().equals(fail) && !failuresDetected.contains(fail)) {
						failuresDetected.add(fail);
					}
				}
			}
		}
		
		return failuresDetected.size();
	}
}
