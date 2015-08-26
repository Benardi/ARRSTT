package br.edu.ufcg.splab.trash;

import java.util.Iterator;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph.core.InterfaceEdge;

public class DefectCounter {
	public int countFails(TestSuite ts) {
		int errorsCounter = 0;
		
		for (TestCase tc : ts) {
			Iterator<InterfaceEdge> tcIt = tc.iterator();
			
			while(tcIt.hasNext()) {
				if (tcIt.next().getLabel().equals("ERROR")) {
					errorsCounter++;
					break;
				}
			}
		}
		
		return errorsCounter;
	}
}
