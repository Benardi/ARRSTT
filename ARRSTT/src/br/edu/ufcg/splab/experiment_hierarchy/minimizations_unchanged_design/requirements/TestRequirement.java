package br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.requirements;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;

public interface TestRequirement {
	public boolean cover(TestCase tc);
}
