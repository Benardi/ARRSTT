package br.edu.ufcg.splab.experiment_hierarchy.minimizations.algorithms;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.structures.DoubleStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class Greedy implements InterfaceMinimization {
	private DoubleStructure structure;
	
	public Greedy(TestSuite ts, List<TestRequirement> reqs) {
		this.structure = new DoubleStructure(ts, reqs);
	}
	
	public DoubleStructure getStructure() {
		return structure;
	}

	@Override
	public TestSuite execute() {
		TestSuite minTS = new TestSuite();
		
		boolean keepRunning = true;
		
		while(keepRunning) {
			TestCase tCase = structure.markTestCase();
			
			if (tCase == null) {
				keepRunning = false;
			} else {
				minTS.add(tCase);
			}
		}
		
		return minTS;
	}
	
	
}
