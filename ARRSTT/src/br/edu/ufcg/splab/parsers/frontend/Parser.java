package br.edu.ufcg.splab.parsers.frontend;

import br.edu.ufcg.splab.util.testcollections.TestSuite;

public interface Parser {
	public TestSuite parseFile(String path);
}
