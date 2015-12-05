package br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.requirements;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;

public interface TestRequirement {
	public boolean isCoveredBy(TestCase tc);
}
