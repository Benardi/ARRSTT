package br.edu.ufcg.splab.searchs;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.core.InterfaceEdge;
import br.edu.ufcg.splab.core.InterfaceVertex;
import br.edu.ufcg.splab.core.graph.Graph;

public class DepthFirstSearch {
	private final Graph graph;
	
	public DepthFirstSearch(Graph graph) {
		this.graph = graph;
	}
	
	public List<List<InterfaceEdge>> search(InterfaceVertex vertex) {
		List<InterfaceEdge> visited = new ArrayList<InterfaceEdge>();
		List<List<InterfaceEdge>> paths = new ArrayList<List<InterfaceEdge>>();
		
		if(vertex.isLeaf()) { 
			paths.add(visited);
			visited.remove(visited.size() - 1); // I hope it's not a gambiarra
		}
		
		for (InterfaceEdge edge : vertex.getOutTransitions()) {
			if(!visited.contains(edge)) {
				visited.add(edge);
				search(edge.getTo());
			}
		}
		
		return paths;
	}
	
	
}
