package br.edu.ufcg.splab.experiment_hierarchy.minimizations.algorithms;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.structures.DoubleStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class GreedyEssencial implements InterfaceMinimization {
	private Greedy greedy;
	
	public GreedyEssencial(TestSuite ts, List<TestRequirement> reqs) {
		this.greedy = new Greedy(ts, reqs);
	}
	
	public DoubleStructure getStructure() {
		return this.greedy.getStructure();
	}
	
	public TestSuite executeGreedy() {
		return greedy.execute();
	}

	public TestSuite executeEssencial() {
		TestSuite essencialTS = new TestSuite();
		
		boolean keepRunning = true;
		
		while(keepRunning) {
			TestCase tCase = greedy.getStructure().markEssencialTestCase();
			
			if (tCase == null) {
				keepRunning = false;
			} else {
				essencialTS.add(tCase);
			}
		}
		
		return essencialTS;
	}
	
	@Override
	public TestSuite execute() {
		TestSuite essencialTS = executeEssencial();
		TestSuite minTS = greedy.execute();
		minTS.addAll(essencialTS);
		
		return minTS;
	}
	
	
}
