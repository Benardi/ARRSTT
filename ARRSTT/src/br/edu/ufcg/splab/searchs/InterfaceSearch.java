package br.edu.ufcg.splab.searchs;

import br.edu.ufcg.splab.core.InterfaceVertex;
import br.edu.ufcg.splab.util.TestSuite;

public interface InterfaceSearch {
	public TestSuite getTestSuite(InterfaceVertex root, int loopCoverage);
}