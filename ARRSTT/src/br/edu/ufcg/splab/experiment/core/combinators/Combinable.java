package br.edu.ufcg.splab.experiment.core.combinators;

import java.util.List;

/**
 * Represents a generic combinator.
 * 
 * The combinator's  responsibility is to inform the experiment 
 * the treatments and the order they will be executed.
 *  
 */
public interface Combinable {
	/**
	 * Combine the treatments.
	 * 
	 * @return
	 * 		A list of list of objects, representing each a group of treatments.
	 * 
	 */
	public List<List<?>> combine();
}
