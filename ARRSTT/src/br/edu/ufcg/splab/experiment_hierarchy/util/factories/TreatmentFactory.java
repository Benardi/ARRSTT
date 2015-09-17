package br.edu.ufcg.splab.experiment_hierarchy.util.factories;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.GenerationType;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;

public class TreatmentFactory {
	public ExecutableTreatment createSelection(SelectionType type, TestSuite testSuite, double percentage) {
		return new SelectionFactory().createTreatment(type, testSuite, percentage);
	}
	
	public ExecutableTreatment createGeneration(GenerationType type, InterfaceVertex root, int loopCoverage) {
		return new GenerationFactory().createTreatment(type, root, loopCoverage);
	}
}
