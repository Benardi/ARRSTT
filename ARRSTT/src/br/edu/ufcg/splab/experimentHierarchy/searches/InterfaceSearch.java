package br.edu.ufcg.splab.experimentHierarchy.searches;

import br.edu.ufcg.splab.experimentHierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph.core.InterfaceVertex;

public interface InterfaceSearch {
	public TestSuite getTestSuite(InterfaceVertex root, int loopCoverage);
	public String getName();
}