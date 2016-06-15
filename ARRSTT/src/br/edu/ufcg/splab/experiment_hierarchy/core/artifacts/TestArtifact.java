package br.edu.ufcg.splab.experiment_hierarchy.core.artifacts;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class TestArtifact extends Artifact<TestSuite> {

	public TestArtifact(TestSuite target, List<DependentVariableCollector> dvcs) {
		super(target, dvcs);
	}

}
