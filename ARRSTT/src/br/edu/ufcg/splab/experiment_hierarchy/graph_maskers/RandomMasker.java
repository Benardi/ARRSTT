package br.edu.ufcg.splab.experiment_hierarchy.graph_maskers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.ufcg.splab.graph.core.InterfaceGraph;

/**
 * THis class represents a "Maskarator" that insert errors in a graph using a
 * random pattern.
 * 
 * @author JoséBenardi
 *
 */
public class RandomMasker implements InterfaceGraphMaskarator {

	@Override
	public void mask(InterfaceGraph toBeMasked, double percentage) {
		int errorQuantity = (int) Math.ceil(toBeMasked.getEdges().size()
				* percentage);
		mask(toBeMasked, errorQuantity);
	}

	@Override
	public void mask(InterfaceGraph toBeMasked, int errorQuantity) {
		List<Integer> positionOfMarks = getMarkPositions(toBeMasked.getEdges()
				.size(), errorQuantity);
		for (Integer i : positionOfMarks) {
			toBeMasked.getEdges().get(i).setLabel("ERROR");
		}
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
