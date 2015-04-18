package br.edu.ufcg.splab.searchs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import br.edu.ufcg.splab.core.InterfaceEdge;
import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.core.InterfaceVertex;
import br.edu.ufcg.splab.parser.ReadTGF;
import br.edu.ufcg.splab.util.TestCase;

public class DepthFirstSearch {
	
	public List<TestCase> getTestSuite(InterfaceVertex root) {
		return search(root, new Stack<InterfaceEdge>(), new ArrayList<TestCase>());
	}
	
	private List<TestCase> search(InterfaceVertex vertex, Stack<InterfaceEdge> tCase, List<TestCase> testSuite) {
		if (vertex.isLeaf() && !testSuite.contains(tCase)) {  
			testSuite.add(new TestCase(new ArrayList<InterfaceEdge>(tCase)));
		}
		
		for (InterfaceEdge edge : vertex.getOutTransitions()) {
				tCase.push(edge);
				search(edge.getTo(), tCase, testSuite);
				tCase.pop();
		}
		
		return testSuite;
	}
	
	public static void main(String[] args) { // Just for testing.
		ReadTGF tgfReader = new ReadTGF();
		try {
			InterfaceGraph graph = tgfReader.getGraph("put_path_here.tgf");
			DepthFirstSearch searchObject = new DepthFirstSearch();
			long time = System.currentTimeMillis();
			List<TestCase> paths = searchObject.getTestSuite(graph.getRoot());
			System.out.println(System.currentTimeMillis() - time);
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
