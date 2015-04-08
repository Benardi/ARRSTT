package br.edu.ufcg.splab.searchs;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.core.InterfaceEdge;
import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.core.InterfaceVertex;
import br.edu.ufcg.splab.parser.ReadTGF;

public class DepthFirstSearch {
	List<InterfaceEdge> visited = new ArrayList<InterfaceEdge>();
	List<InterfaceEdge> testCase = new ArrayList<InterfaceEdge>();
	List<List<InterfaceEdge>> paths = new ArrayList<List<InterfaceEdge>>();
	
	public List<List<InterfaceEdge>> search(InterfaceVertex vertex) {
		if(vertex.isLeaf()) {  
			paths.add(testCase);
		}
		
		for (InterfaceEdge edge : vertex.getOutTransitions()) {
			if(!visited.contains(edge)) {
				visited.add(edge);
				testCase.add(edge);
				search(edge.getTo());
				testCase.remove(testCase.size() - 1);
			}
		}

		return paths;
	}
	
	public static void main(String[] args) { // Just for testing.
		ReadTGF tgfReader = new ReadTGF();
		try {
			InterfaceGraph graph = tgfReader.getGraph("input_examples/simple_example.tgf");
			DepthFirstSearch searchObject = new DepthFirstSearch();
			List<List<InterfaceEdge>> paths = searchObject.search(graph.getRoot());
			/*
			for (List<InterfaceEdge> path: paths) {
				for(InterfaceEdge e : path) {
					System.out.print(e + "  ");
				}
				System.out.println();
				System.out.println("=====================");
			}*/
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
