package br.edu.ufcg.splab.searchs;

import java.util.List;

import br.edu.ufcg.splab.core.InterfaceVertex;
import br.edu.ufcg.splab.util.TestCase;

public interface InterfaceSearch {
	public List<TestCase> getTestSuite(InterfaceVertex root, int loopCoverage);
}
