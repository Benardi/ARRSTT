package br.edu.ufcg.splab.experiment_hierarchy.util.factories;

import br.edu.ufcg.splab.experiment_hierarchy.searches.BreadthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.GenerationType;

/**
 * Objective: This class covers all necessary procedure involved in the process
 * of generating a search.
 * 
 * Description of use: Receives a type and returns a search of the respective
 * type.
 */
public class GenerationFactory {
	/**
	 * 
	 * @param type
	 *            the type of search
	 * @return A search
	 */
	public InterfaceSearch createTreatment(GenerationType type) {
		if (type == GenerationType.BFS) {
			return createBfsGenerator();
		} else {
			return createDfsGenerator();
		}
	}
	/**
	 * 
	 * @return A Breadth First Search.
	 */
	public InterfaceSearch createBfsGenerator() {
		return new BreadthFirstSearch();
	}
	/**
	 * 
	 * @return A Depth First Search.
	 */
	public InterfaceSearch createDfsGenerator() {
		return new DepthFirstSearch();
	}
}
