package br.edu.ufcg.splab.experiment_hierarchy.core.runners;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.artifacts.TestArtifact;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;

public class TestRunner implements InterfaceRunner {
	private List<TestArtifact> artifacts;
	
	public TestRunner(List<TestArtifact> artifacts) {
		this.artifacts  = artifacts;
	}
	
	
	@Override
	public void runExperiment(List<Tuple<ExecutableTreatment>> combinations) {
		for (int i = 0; i < combinations.size(); i++) {
			
			
		}
	}

}
