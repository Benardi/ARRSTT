package br.edu.ufcg.splab.trash;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations.algorithms.InterfaceMinimization;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class GreedyEssencial implements InterfaceMinimization {
	private Greedy greedy;
	
	public GreedyEssencial(TestSuite ts) {
		this.greedy = new Greedy(ts);
	}
	
	public TestSuite execute() {
		GreedyStructure gs = greedy.getGreedyStructure();
		TestSuite ts = new TestSuite();
		
		while (true) {
			TestCase tc = gs.selectEssencialTestCase(); 
			
			if (tc == null) {
				break;
			}
			
			ts.add(tc);
		}
		
		TestSuite gts = greedy.execute();
		gts.addAll(ts);
		
		return gts;
	}
	
	
}
