package br.edu.ufcg.splab.experiment_hierarchy.searches;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Iaron Araujo		2015-04-20
 * 
 */
/**
 * <b>Objective:</b> This interface represents a TestSuite generation algorithm that
 * is based on the graph search DFS.
 * <br>
 * <b>Description of use:</b> This interface is used to generate a TestSuite from a graph.
 *
 */
public class DepthFirstSearch implements InterfaceSearch {
	/**
	 * The Hashmap that will count how many times one edge is in the auxiliar stack
	 */
	private HashMap<InterfaceEdge, Integer> vertexCoverage;
	/**
	 * The auxiliar Stack that is used on the DFS algorithm
	 */
	private Deque<InterfaceEdge> tCase;
	/**
	 * The testSuite generated by the algorithm
	 */
	private TestSuite testSuite;
	
	/**
	 * 
	 * @return the Hashmap that counts the amount of times an edge is in the stack
	 */
	public HashMap<InterfaceEdge, Integer> getVertexCoverage() {
		return vertexCoverage;
	}
	
	/**
	 * Initializes the attributes.
	 */
	public DepthFirstSearch() {
		tCase = new LinkedList<InterfaceEdge>();
		vertexCoverage = new HashMap<InterfaceEdge, Integer>();
		testSuite = new TestSuite(); // verificar redundancia com linha 31
	}
	
	/**
	 * <b>Objective:</b> Generates a graph's TestSuite.
	 * <br>
	 * <b>Exemple of use:</b> In the ARRSTT Generation experiment to compare TestSuite's
	 * generation algorithms.
	 * @param root
	 * 			The graph's root.
	 * @param loopCoverage
	 * 			The loop coverage considered to generate the TestSuite.
	 * @return The graph's TestSuite.
	 */
	public TestSuite getTestSuite(InterfaceVertex root, int loopCoverage) {
		testSuite = new TestSuite(); // verificar redundancia com linha 27
		search(root, loopCoverage);
		return testSuite;
	}
	
	private void search(InterfaceVertex vertex, Integer loopCoverage) {
		// stop condition
		if (vertex.isLeaf() && !testSuite.contains(tCase)) {  
			testSuite.add(new TestCase(new ArrayList<InterfaceEdge>(tCase)));
		}
				
		for (InterfaceEdge edge : vertex.getOutTransitions()) {
			
			// Fill harshmap with -1
			if(!(vertexCoverage.containsKey(edge))){
				vertexCoverage.put(edge, -1);
			}
			
			Integer value = vertexCoverage.get(edge);
			
			// pushes the edge to the stack and update the map
			tCase.push(edge);
			value = value.intValue() +1;
			vertexCoverage.put(edge, value);
			
			// recursive step
			if (vertexCoverage.get(edge) <= loopCoverage){
				search(edge.getTo(), loopCoverage);
			}
			
			// pops the edge of the stack and update the map
			tCase.pop();
			value = value.intValue() - 1;
			vertexCoverage.put(edge, value);
		}		
	}
	
	public String getName(){
		return "DFS";
	}
}
