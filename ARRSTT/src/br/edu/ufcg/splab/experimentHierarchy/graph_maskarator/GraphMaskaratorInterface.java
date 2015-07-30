package br.edu.ufcg.splab.experimentHierarchy.graph_maskarator;

import br.edu.ufcg.splab.graph.core.InterfaceGraph;

public interface GraphMaskaratorInterface {
	//I think I should pick another name for the methods, but I can't think of a good one.
	//Is error the right name? Should I change it by something else?
	//Should the toBeMasked be a class attribute?
	/**
	 * This method receives a graph and return it's masked form, putting some "errors" in it.
	 * Receives the graph to be masked and the percentage of "errors" desired.
	 * @param toBeMasked
	 * 			The graph to be masked
	 * @param percentage
	 * 			The percentage of "errors" desired
	 * @return A masked version of the graph
	 */
	
	public InterfaceGraph maskarate(InterfaceGraph toBeMasked, double percentage);
	/**
	 * This method receives a graph and return it's masked form, putting some "errors" in it.
	 * Receives the graph to be masked and the amount of "errors" desired.
	 * @param toBeMasked
	 * 			The graph to be masked
	 * @param ErrorQuantity
	 * 			The amount of "errors" desired
	 * @return
	 */
	public InterfaceGraph maskarate(InterfaceGraph toBeMasked, int errorQuantity);
}
