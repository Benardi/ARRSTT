package br.edu.ufcg.splab.searchs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import br.edu.ufcg.splab.core.InterfaceEdge;
import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.core.InterfaceVertex;
import br.edu.ufcg.splab.parser.ReadTGF;
import br.edu.ufcg.splab.util.TestCase;

public class DepthFirstSearch {
	private HashMap<InterfaceEdge, Integer> vertexCoverage;  // TIRAR STATIC AGORA!!!!!!!!!!
	
	public HashMap<InterfaceEdge, Integer> getVertexCoverage() {
		return vertexCoverage;
	}

	public DepthFirstSearch() {
		vertexCoverage = new HashMap<InterfaceEdge, Integer>();
	}
	
	public List<TestCase> getTestSuite(InterfaceVertex root, Integer loopCoverage) {
		
		return search(root, new Stack<InterfaceEdge>(), new ArrayList<TestCase>(), loopCoverage);
		// Lembrar de limpar o Mapa
	}
	
	private List<TestCase> search(InterfaceVertex vertex, Stack<InterfaceEdge> tCase, List<TestCase> testSuite, Integer loopCoverage) {
		if (vertex.isLeaf() && !testSuite.contains(tCase)) {  
			testSuite.add(new TestCase(new ArrayList<InterfaceEdge>(tCase)));
		}
				
		for (InterfaceEdge edge : vertex.getOutTransitions()) {
			
			// Fill harshmap with zeros
			if(!(vertexCoverage.containsKey(edge))){
				vertexCoverage.put(edge, 0);
			}
			
			Integer value = vertexCoverage.get(edge);
			
			tCase.push(edge);
				
			if (vertexCoverage.get(edge) != loopCoverage){
				value = value.intValue() +1;
				
				vertexCoverage.put(edge, value);
				search(edge.getTo(), tCase, testSuite, loopCoverage);
			}
			
			tCase.pop();
			value = value.intValue() - 1;
			vertexCoverage.put(edge, value);
		}		
		return testSuite;
	}
	
	public static void main(String[] args) { // Just for testing.
		ReadTGF tgfReader = new ReadTGF();
		try {
			InterfaceGraph graph = tgfReader.getGraph("input_examples/outroLoop.tgf");
			DepthFirstSearch searchObject = new DepthFirstSearch();
			long time = System.currentTimeMillis();
			List<TestCase> paths = searchObject.getTestSuite(graph.getRoot(), 2);
			System.out.println(System.currentTimeMillis() - time);
			for (List<InterfaceEdge> path: paths) {
				for(InterfaceEdge e : path) {
					System.out.print(e + "  ");
				}
				System.out.println();
				System.out.println("=====================");
			}
			
			System.out.println(searchObject.getVertexCoverage());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
