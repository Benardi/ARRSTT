package br.edu.ufcg.splab.parsers.frontend;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public interface Parser {
	public TestSuite parseFile(String path);
}
