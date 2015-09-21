package br.edu.ufcg.splab.experiment_hierarchy.util.factories;

import br.edu.ufcg.splab.experiment_hierarchy.searches.BreadthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.GenerationType;

public class GenerationFactory {
	
	public InterfaceSearch createTreatment(GenerationType type) {
		if (type == GenerationType.BFS) {
			return createBfsGenerator();
		} else {
			return createDfsGenerator();
		}
	}
	
	public InterfaceSearch createBfsGenerator() {
		return new BreadthFirstSearch();
	}
	
	public InterfaceSearch createDfsGenerator() {
		return new DepthFirstSearch();
	}
}
