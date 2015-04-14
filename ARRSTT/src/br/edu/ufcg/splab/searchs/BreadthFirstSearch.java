package br.edu.ufcg.splab.searchs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import br.edu.ufcg.splab.core.InterfaceEdge;
import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.core.InterfaceVertex;
import br.edu.ufcg.splab.parser.ReadTGF;
import br.edu.ufcg.splab.util.TestCase;

public class BreadthFirstSearch {
	public static void main(String[] args) {
		try {
			ReadTGF tgfReader = new ReadTGF();
			InterfaceGraph graph = tgfReader.getGraph("C:\\Users\\Wesley\\workspace\\Application-of-Reproducibility-Research-with-Software-Testing-Techniques-master\\ARRSTT\\input_examples\\iaron_difficulttoy3.tgf");
			NewBreadthFirstSearch searchObject = new NewBreadthFirstSearch();
			
			for (List<InterfaceEdge> testCase: searchObject.getTestSuite(graph.getRoot())) {
				for(InterfaceEdge e : testCase) {
					System.out.print(e + "  ");
				}
				System.out.println();
				System.out.println("=====================");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
			
	}	

	private Queue<InterfaceEdge> queue;
	
	public List<TestCase> getTestSuite(InterfaceVertex root) {
		queue = new LinkedList<InterfaceEdge>();
		return search(root, initializeTestSuite(root));
	}
	
	private List<TestCase> search(InterfaceVertex vertex, List<TestCase> testSuite) {
		dequeue(vertex);
		divideTestSuite(vertex, testSuite);
		if (!queue.isEmpty()) return search(queue.peek().getTo(), testSuite); // BASE CASE
		return testSuite;
	}
	
	private void dequeue(InterfaceVertex vertex) {
		queue.poll();
		if (!vertex.isLeaf()) {
			queue.addAll(vertex.getOutTransitions());	
		}
	}
	
	private List<TestCase> divideTestSuite(InterfaceVertex vertex, List<TestCase> testSuite) {
		int loopEnd = testSuite.size();
		List<TestCase> uselessTestCases = new LinkedList<TestCase>();
		
		for (InterfaceEdge e : vertex.getOutTransitions()) {
			for (InterfaceEdge eg: vertex.getInTransitions()) {
				for (int i = 0; i < loopEnd; i++) {
					if (testSuite.get(i).get(testSuite.get(i).size() - 1).equals(eg)) {
						TestCase newTestCase = new TestCase(testSuite.get(i));
						newTestCase.add(e);
						testSuite.add(newTestCase);
						uselessTestCases.add(testSuite.get(i));
					}
				}
			}
		}
		
		testSuite.removeAll(uselessTestCases);
		return testSuite;
	}
	
	private List<TestCase> initializeTestSuite(InterfaceVertex root) {
		List<TestCase> testSuite = new LinkedList<TestCase>();
		for(InterfaceEdge edge : root.getOutTransitions()) {
			TestCase tc = new TestCase();
			tc.add(edge);
			testSuite.add(tc);
		}
		
		return testSuite; 
	}
}