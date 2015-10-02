package br.edu.ufcg.splab.experiment_hierarchy.maskarators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.ufcg.splab.experiment_hierarchy.util.factories.GraphFactory;
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
public class RandomMasker implements InterfaceGraphMaskarator {
	private GraphFactory factory;
	
	public RandomMasker() {
		this.factory = new GraphFactory();
	}
	
	@Override
	/**
	 * Objective: To receive a graph and modify it to have "errors" in it's 
	 * transitions. This method randomly inserts "errors" on edges.
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
	 * transitions. This method randomly inserts "errors" on edges.
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
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		List<Integer> positionOfMarks = getMarkPositions(maskedGraph.getEdges()
				.size(), errorQuantity);
		for (Integer i : positionOfMarks) {
			maskedGraph.getEdges().get(i).setLabel("ERROR");
		}
		
		return maskedGraph;
	}

	private List<Integer> getMarkPositions(int limit, int markQnt) {
		List<Integer> markPosition = new ArrayList<>();
		Random positionGenerator = new Random();
		int position;
		while (markQnt != 0) {
			position = positionGenerator.nextInt(limit);
			if (!(markPosition.contains(position))) {
				markPosition.add(position);
				markQnt--;
			}
		}
		return markPosition;
	}

}
