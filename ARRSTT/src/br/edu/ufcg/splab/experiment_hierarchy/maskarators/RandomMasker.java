package br.edu.ufcg.splab.experiment_hierarchy.maskarators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.ufcg.splab.experiment_hierarchy.util.factories.GraphFactory;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceGraph;

/**
 * THis class represents a "Maskarator" that insert errors in a graph using a
 * random pattern.
 * 
 * @author JoséBenardi
 *
 */
public class RandomMasker implements InterfaceGraphMaskarator {
	private GraphFactory factory;
	
	public RandomMasker() {
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
