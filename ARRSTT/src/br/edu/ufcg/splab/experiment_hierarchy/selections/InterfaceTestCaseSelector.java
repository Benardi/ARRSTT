package br.edu.ufcg.splab.experiment_hierarchy.selections;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public interface InterfaceTestCaseSelector {
	public TestSuite select(TestSuite testSuite, Double percentage);
}
