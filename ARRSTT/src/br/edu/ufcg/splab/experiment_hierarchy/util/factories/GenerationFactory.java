package br.edu.ufcg.splab.experiment_hierarchy.util.factories;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.GenerationTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.searches.BreadthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.GenerationType;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;

public class GenerationFactory {
	public ExecutableTreatment createTreatment(GenerationType type, InterfaceVertex root, int loopCoverage) {
		if (type == GenerationType.BFS) {
			return createBfsGenerator(root, loopCoverage);
		} else {
			return createDfsGenerator(root, loopCoverage);
		}
	}
	
	public ExecutableTreatment createBfsGenerator(InterfaceVertex root, int loopCoverage) {
		return new GenerationTreatment(new DepthFirstSearch(), root, loopCoverage);
	}
	
	public ExecutableTreatment createDfsGenerator(InterfaceVertex root, int loopCoverage) {
		return new GenerationTreatment(new BreadthFirstSearch(), root, loopCoverage);
	}
}
