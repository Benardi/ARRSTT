package br.edu.ufcg.splab.trash;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class GreedyEssencialRedundant implements InterfaceMinimization {
private GreedyEssencial greedyEssencial;
	
	public GreedyEssencialRedundant(TestSuite ts, List<TestRequirement> reqs) {
		this.greedyEssencial = new GreedyEssencial(ts, reqs);
	}

	@Override
	public TestSuite execute() {
		TestSuite essencialTS = greedyEssencial.executeEssencial();
		
		TestSuite nonRedundantTS = new TestSuite();
		
		boolean keepRunning = true;
		while(keepRunning) {
			TestCase tCase = greedyEssencial.getStructure().markNonRedundantTestCase();
			
			if (tCase == null) {
				keepRunning = false;
			} else {
				nonRedundantTS.add(tCase);
			}
		}
		
		TestSuite minTS = greedyEssencial.executeGreedy();
		minTS.addAll(nonRedundantTS);
		minTS.addAll(essencialTS);
		
		return minTS;
	}
	
	

}
