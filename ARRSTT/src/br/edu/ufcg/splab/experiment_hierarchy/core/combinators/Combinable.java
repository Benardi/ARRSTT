package br.edu.ufcg.splab.experiment_hierarchy.core.combinators;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;

/**
 * Represents a generic combinator.
 * 
 * The combinator's  responsibility is to inform the experiment 
 * the treatments and the order they will be executed.
 *  
 */
public interface Combinable {
	// REFACTOR: The name is not good since just combinators of some sort implements it.
	/**
	 * Combine the treatments.
	 * 
	 * @return
	 * 		A list of list of objects, representing each a group of treatments.
	 * 
	 */
	public List<Tuple<ExecutableTreatment>> combine();
}