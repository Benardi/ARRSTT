package br.edu.ufcg.splab.framework.techniques.minimization.requirements;

import br.edu.ufcg.splab.util.testcollections.TestCase;

public interface TestRequirement {
	public boolean isCoveredBy(TestCase tc);
}
