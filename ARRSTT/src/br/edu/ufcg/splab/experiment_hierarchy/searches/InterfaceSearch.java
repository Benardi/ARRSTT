package br.edu.ufcg.splab.experiment_hierarchy.searches;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;

public interface InterfaceSearch {
	public TestSuite getTestSuite(InterfaceVertex root, int loopCoverage);
	public String getName();
}