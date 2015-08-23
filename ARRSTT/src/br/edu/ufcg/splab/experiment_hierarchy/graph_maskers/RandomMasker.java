package br.edu.ufcg.splab.experiment_hierarchy.graph_maskers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.ufcg.splab.graph.core.InterfaceGraph;

public class RandomMasker implements InterfaceGraphMaskarator{

	@Override
	public InterfaceGraph mask(InterfaceGraph toBeMasked, double percentage) {
		int errorQuantity = (int) Math.ceil(toBeMasked.getEdges().size() * percentage);
		return mask(toBeMasked, errorQuantity);
	}

	@Override
	public InterfaceGraph mask(InterfaceGraph toBeMasked, int errorQuantity) {
		List<Integer> positionOfMarks = getMarkPositions(toBeMasked.getEdges().size(), errorQuantity);
		for(Integer i : positionOfMarks){
			toBeMasked.getEdges().get(i).setLabel("ERROR");
		}
		
		return toBeMasked;
	}
	
	private List<Integer> getMarkPositions(int limit, int markQnt){
		List<Integer> markPosition = new ArrayList<>();
		Random positionGenerator = new Random();
		int position;
		while(markQnt != 0){
			position = positionGenerator.nextInt(limit);
			if(!(markPosition.contains(position))){
				markPosition.add(position);
				markQnt--;
			}
		}
		return markPosition;
	}

}
