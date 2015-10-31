package br.edu.ufcg.splab.trash;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations.algorithms.InterfaceMinimization;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class Greedy implements InterfaceMinimization {
	private GreedyStructure gs;
	
	public Greedy(TestSuite ts) {
		ReqTracerAllTransitionsCoverage reqTracer = new ReqTracerAllTransitionsCoverage(ts);
		GreedyStructure gs = new GreedyStructure(reqTracer.getMap());
		this.gs = gs;
	}
	
	public GreedyStructure getGreedyStructure() {
		return gs;
	}
	
	public TestSuite execute() {
		TestSuite ts = new TestSuite();
		
		while (!gs.isEmptyOnReqs()) {
			TestCase tc = gs.selectGreedyTestCase();
			ts.add(tc);
		}
		
		return ts;
	}
}
