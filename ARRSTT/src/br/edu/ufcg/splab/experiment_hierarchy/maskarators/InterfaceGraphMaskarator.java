package br.edu.ufcg.splab.experiment_hierarchy.maskarators;

import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceGraph;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Iaron Araujo		2015-07-30
 * 
 */
/**
 * Objective: This interface represents a graph masker that is responsible for
 * modifying a percentage of graph according to a certain criteria.
 * 
 * Description of use: It is used when a graph's edges or vertexes needs to be 
 * modified.
 *
 */
public interface InterfaceGraphMaskarator {
	/**
	 * Objective: to receive a graph and modify it according to
	 * a certain criteria.
	 * 
	 * Exemple of use: In the ARRSTT selection experiment, it is necessary
	 * to have graph's with "errors". This method is used to mask them, so
	 * they have these "errors".
	 * 
	 * @param toBeMasked
	 *            The graph to be masked
	 * @param percentage
	 *            The percentage of changes desired
	 * @return A masked version of the graph
	 */
	public InterfaceGraph mask(InterfaceGraph toBeMasked, double percentage);

	/**
	 * Objective: to receive a graph and modify it according to
	 * a certain criteria.
	 * 
	 * Exemple of use: In the ARRSTT selection experiment, it is necessary
	 * to have graph's with "errors". This method is used to mask them, so
	 * they have these "errors".
	 * 
	 * @param toBeMasked
	 *            The graph to be masked
	 * @param errorQuantity
	 *            The number of changes desired
	 * @return A masked version of the graph
	 */
	public InterfaceGraph mask(InterfaceGraph toBeMasked, int errorQuantity);
}
