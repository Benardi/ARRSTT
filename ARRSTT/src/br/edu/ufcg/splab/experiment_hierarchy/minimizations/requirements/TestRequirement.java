package br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;

public interface TestRequirement {
	public boolean isCoveredBy(TestCase tc);
}
