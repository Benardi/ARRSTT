package br.edu.ufcg.splab.experiment_hierarchy.graph_maskers;

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

	@Override
	public void mask(InterfaceGraph toBeMasked, double percentage) {
		int errorQuantity = (int) Math.ceil(toBeMasked.getEdges().size()
				* percentage);
		mask(toBeMasked, errorQuantity);
	}

	@Override
	public void mask(InterfaceGraph toBeMasked, int errorQuantity) {
		int errorPosition = toBeMasked.getEdges().size() / errorQuantity;
		int count = 1;
		for (InterfaceEdge edge : toBeMasked.getEdges()) {
			if (count == errorPosition) {
				edge.setLabel("ERROR");
				errorQuantity--;
				count = 1;
				if (errorQuantity == 0) {
					return;
				}
			} else {
				count++;
			}
		}
	}

}
