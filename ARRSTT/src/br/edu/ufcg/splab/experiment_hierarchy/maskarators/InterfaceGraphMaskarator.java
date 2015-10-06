package br.edu.ufcg.splab.experiment_hierarchy.maskarators;

import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceGraph;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Iaron Araujo		2015-07-30
 * 
 */
/**
 * <b>Objective:</b> This interface represents a graph masker that is responsible for
 * modifying a percentage of graph according to a certain criteria.
 * <br>
 * <b>Description of use:</b> It is used when a graph's edges or vertexes needs to be 
 * modified.
 *
 */
public interface InterfaceGraphMaskarator {
	/**
	 * <b>Objective:</b> to receive a graph and modify it according to
	 * a certain criteria.
	 * <br>
	 * <b>Exemple of use:</b> In the ARRSTT selection experiment, it is necessary
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
	 * <b>Objective:</b> to receive a graph and modify it according to
	 * a certain criteria.
	 * <br>
	 * <b>Exemple of use:</b> In the ARRSTT selection experiment, it is necessary
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
