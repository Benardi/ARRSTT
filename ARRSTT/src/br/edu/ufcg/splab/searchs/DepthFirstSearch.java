package br.edu.ufcg.splab.searchs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import br.edu.ufcg.splab.core.InterfaceEdge;
import br.edu.ufcg.splab.core.InterfaceVertex;
import br.edu.ufcg.splab.util.TestCase;
import br.edu.ufcg.splab.util.TestSuite;

public class DepthFirstSearch implements InterfaceSearch {
	private HashMap<InterfaceEdge, Integer> vertexCoverage;
	private Stack<InterfaceEdge> tCase;
	private TestSuite testSuite;
	
	public HashMap<InterfaceEdge, Integer> getVertexCoverage() {
		return vertexCoverage;
	}

	public DepthFirstSearch() {
		tCase = new Stack<InterfaceEdge>();
		vertexCoverage = new HashMap<InterfaceEdge, Integer>();
		testSuite = new TestSuite(); // verificar redundancia com linha 31
	}
	
	public TestSuite getTestSuite(InterfaceVertex root, int loopCoverage) {
		testSuite = new TestSuite(); // verificar redundancia com linha 27
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
}
