package br.edu.ufcg.splab.experimentsExamples.techniques.minimization.requirements;

import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestCase;

public interface TestRequirement {
	public boolean isCoveredBy(TestCase tc);
}
