package br.edu.ufcg.splab.experiment_hierarchy.maskarators;

import br.edu.ufcg.splab.experiment_hierarchy.util.factories.GraphFactory;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceGraph;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Iaron Araujo		2015-07-30
 * 
 */
/**
 * Objective: This interface represents a graph masker that is responsible for
 * modifying a percentage of a graph's transitions, inserting "errors" in it.
 * 
 * Description of use: It is used when a graph needs to have "errors" in it.
 *
 */
public class IaronMasker implements InterfaceGraphMaskarator {
	private GraphFactory factory;
	
	public IaronMasker() {
		this.factory = new GraphFactory();
	}
	
	@Override
	/**
	 * Objective: To receive a graph and modify it to have "errors" in it's 
	 * transitions. This method consider the graph's list of edges and inserts
	 * the "errors" in positions as spaced as possible from each other.
	 * 
	 * Exemple of use: In the ARRSTT selection experiment, it is necessary
	 * to have graph's with "errors". This method is used to mask them, so
	 * they have these "errors" in it's transitions.
	 * 
	 * @param toBeMasked
	 *            The graph to be masked.
	 * @param percentage
	 *            The percentage of "errors" desired.
	 * @return A masked version of the graph.
	 */
	public InterfaceGraph mask(InterfaceGraph toBeMasked, double percentage) {
		int errorQuantity = (int) Math.ceil(toBeMasked.getEdges().size()
				* percentage);
		return mask(toBeMasked, errorQuantity);
	}

	@Override
	/**
	 * Objective: To receive a graph and modify it to have "errors" in it's 
	 * transitions. This method consider the graph's list of edges and inserts
	 * the "errors" in positions as spaced as possible from each other.
	 * 
	 * Exemple of use: In the ARRSTT selection experiment, it is necessary
	 * to have graph's with "errors". This method is used to mask them, so
	 * they have these "errors" in it's transitions.
	 * 
	 * @param toBeMasked
	 *            The graph to be masked.
	 * @param errorQuantity
	 *            The number of "errors" desired.
	 * @return A masked version of the graph.
	 */
	public InterfaceGraph mask(InterfaceGraph toBeMasked, int errorQuantity) {
		InterfaceGraph maskedGraph = null;
		
		try {
			maskedGraph = factory.cloneGraph(toBeMasked);
		} catch(Exception e ) {
			e.printStackTrace();
		}
		
		int errorPosition = maskedGraph.getEdges().size() / errorQuantity;
		int count = 1;
		for (InterfaceEdge edge : maskedGraph.getEdges()) {
			if (count == errorPosition) {
				edge.setLabel("ERROR");
				errorQuantity--;
				count = 1;
				if (errorQuantity == 0) {
					return maskedGraph;
				}
			} else {
				count++;
			}
		}
		
		return maskedGraph;
	}

}
