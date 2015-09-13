package br.edu.ufcg.splab.experiment_hierarchy.graph_maskers;

import br.edu.ufcg.splab.experiment_hierarchy.util.GraphFactory;
import br.edu.ufcg.splab.graph.core.InterfaceEdge;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;

/**
 * This class represents a "Maskarator" that inserts errors in a graph using as
 * pattern of behavior a specified distance
 * 
 * @author JoséBenardi
 *
 */
public class IaronMasker implements InterfaceGraphMaskarator {
	private GraphFactory factory;
	
	public IaronMasker() {
		this.factory = new GraphFactory();
	}
	
	@Override
	public InterfaceGraph mask(InterfaceGraph toBeMasked, double percentage) {
		int errorQuantity = (int) Math.ceil(toBeMasked.getEdges().size()
				* percentage);
		return mask(toBeMasked, errorQuantity);
	}

	@Override
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
