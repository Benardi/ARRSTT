package br.edu.ufcg.splab.searchs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import br.edu.ufcg.splab.core.InterfaceEdge;
import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.core.InterfaceVertex;
import br.edu.ufcg.splab.parser.ReadTGF;
import br.edu.ufcg.splab.util.TestCase;

public class DepthFirstSearch {
	private HashMap<InterfaceEdge, Integer> vertexCoverage;
	private Stack<InterfaceEdge> tCase;
	private List<TestCase> testSuite;
	
	public HashMap<InterfaceEdge, Integer> getVertexCoverage() {
		return vertexCoverage;
	}

	public DepthFirstSearch() {
		tCase = new Stack<InterfaceEdge>();
		vertexCoverage = new HashMap<InterfaceEdge, Integer>();
		testSuite = new ArrayList<TestCase>(); // verificar redundancia com linha 31
	}
	
	public List<TestCase> getTestSuite(InterfaceVertex root, Integer loopCoverage) {
		testSuite = new ArrayList<TestCase>(); // verificar redundancia com linha 27
		search(root, loopCoverage);
		return testSuite;
	}
	
	private void search(InterfaceVertex vertex, Integer loopCoverage) {
		if (vertex.isLeaf() && !testSuite.contains(tCase)) {  
			testSuite.add(new TestCase(new ArrayList<InterfaceEdge>(tCase)));
		}
				
		for (InterfaceEdge edge : vertex.getOutTransitions()) {
			
			// Fill harshmap with zeros
			if(!(vertexCoverage.containsKey(edge))){
				vertexCoverage.put(edge, -1);
			}
			
			Integer value = vertexCoverage.get(edge);
			
			tCase.push(edge);
			value = value.intValue() +1;
			vertexCoverage.put(edge, value);
				
			if (vertexCoverage.get(edge) <= loopCoverage){
				search(edge.getTo(), loopCoverage);
			}
			
			tCase.pop();
			value = value.intValue() - 1;
			vertexCoverage.put(edge, value);
		}		
	}
	
	public static void main(String[] args) { // Just for testing.
		ReadTGF tgfReader = new ReadTGF();
		try {
			InterfaceGraph graph = tgfReader.getGraph("input_examples/loopytoy8.tgf");
			DepthFirstSearch searchObject = new DepthFirstSearch();
			long time = System.currentTimeMillis();
			List<TestCase> paths = searchObject.getTestSuite(graph.getRoot(), 0);
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
