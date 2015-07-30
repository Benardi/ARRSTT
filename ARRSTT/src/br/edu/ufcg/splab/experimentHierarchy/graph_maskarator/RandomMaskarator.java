package br.edu.ufcg.splab.experimentHierarchy.graph_maskarator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.ufcg.splab.graph.core.InterfaceGraph;

public class RandomMaskarator implements GraphMaskaratorInterface{

	@Override
	public InterfaceGraph maskarate(InterfaceGraph toBeMasked, double percentage) {
		int errorQuantity = (int) Math.ceil(toBeMasked.getEdges().size() * percentage);
		return maskarate(toBeMasked, errorQuantity);
	}

	@Override
	public InterfaceGraph maskarate(InterfaceGraph toBeMasked, int errorQuantity) {
		List<Integer> positionOfMarks = new ArrayList<>();
		Random positionGenerator = new Random();
		int limit = toBeMasked.getEdges().size();
		int position;
		while(errorQuantity != 0){
			position = positionGenerator.nextInt(limit);
			if(!(positionOfMarks.contains(position))){
				positionOfMarks.add(position);
				errorQuantity--;
			}
		}
		
		for(Integer i : positionOfMarks){
			toBeMasked.getEdges().get(i).setLabel("ERROR");
		}
		
		return toBeMasked;
	}

}
