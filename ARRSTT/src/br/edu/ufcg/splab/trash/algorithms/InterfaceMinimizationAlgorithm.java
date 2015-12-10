package br.edu.ufcg.splab.trash.algorithms;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;

public interface InterfaceMinimizationAlgorithm {
	public TestCase execute(MinimizationStructure structure);
}
