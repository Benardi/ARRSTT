package br.edu.ufcg.splab.parsers.frontend;

import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;

public interface Parser {
	public TestSuite parseFile(String path);
}
