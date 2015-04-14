package br.edu.ufcg.splab.searchs;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.core.InterfaceEdge;
import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.core.InterfaceVertex;
import br.edu.ufcg.splab.parser.ReadTGF;
import br.edu.ufcg.splab.util.TestCase;

public class DepthFirstSearch {
	List<InterfaceEdge> visited = new ArrayList<InterfaceEdge>();
	TestCase tCase = new TestCase();
	List<TestCase> paths = new ArrayList<TestCase>();
	
	public List<TestCase> search(InterfaceVertex vertex) {
		if(vertex.isLeaf() && !paths.contains(tCase) && tCase.get(tCase.size() - 1).getTo().isLeaf()) {  
			paths.add(tCase);
		}
		
		for (InterfaceEdge edge : vertex.getOutTransitions()) {
			if(!visited.contains(edge)) {
				visited.add(edge);
				tCase.add(edge);
				search(edge.getTo());
				tCase.remove(tCase.size() - 1);
			}
		}
		System.out.println(paths.toString());
		return paths;
	}
	
	public static void main(String[] args) { // Just for testing.
		ReadTGF tgfReader = new ReadTGF();
		try {
			InterfaceGraph graph = tgfReader.getGraph("input_examples/littlelittletoy.tgf");
			DepthFirstSearch searchObject = new DepthFirstSearch();
			List<TestCase> paths = searchObject.search(graph.getRoot());
			for (List<InterfaceEdge> path: paths) {
				for(InterfaceEdge e : path) {
					System.out.print(e + "  ");
				}
				System.out.println();
				System.out.println("=====================");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
