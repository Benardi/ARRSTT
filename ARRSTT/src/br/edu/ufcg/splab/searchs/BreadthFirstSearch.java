package br.edu.ufcg.splab.searchs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
			InterfaceGraph graph = tgfReader.getGraph("input_examples/outroLoop.tgf");
			BreadthFirstSearch searchObject = new BreadthFirstSearch();
			
			long time = System.currentTimeMillis();
			searchObject.getTestSuite(graph.getRoot(), 1);
			System.out.println(System.currentTimeMillis() - time);
			List<TestCase> testSuite = searchObject.getTestSuite(graph.getRoot(), 1);
			for (List<InterfaceEdge> testCase: testSuite) {
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
	
	private int nLoopCoverage;
	private List<InterfaceEdge> notToVisitEdges;
	
	public List<TestCase> getTestSuite(InterfaceVertex root, Integer nLoopCoverage) {
	   return search(root, nLoopCoverage);
	}
	    
	private List<TestCase> search(InterfaceVertex root, Integer nLoopCoverage) {
		this.notToVisitEdges = new ArrayList<InterfaceEdge>();
		this.nLoopCoverage = nLoopCoverage;
		
		List<TestCase> testSuite = initializeTestSuite(root);
		Queue<InterfaceEdge> queue = new LinkedList<InterfaceEdge>();
		queue.addAll(root.getOutTransitions());
	        
		while (!queue.isEmpty()) { 
			divideTestSuite(dequeue(queue), testSuite);
		}
	    
		cleanTestSuite(testSuite);
	    return testSuite;
	}
	    
	private InterfaceEdge dequeue(Queue<InterfaceEdge> queue) {
		InterfaceEdge actualEdge = queue.poll();
	            
		if (!actualEdge.getTo().isLeaf() && !notToVisitEdges.contains(actualEdge)) {
			queue.addAll(actualEdge.getTo().getOutTransitions());
		}
	        
		return actualEdge;
	}
	    
	private void divideTestSuite(InterfaceEdge actualEdge, List<TestCase> testSuite) {
		int loopEnd = testSuite.size();
		List<TestCase> uselessTestCases = new ArrayList<TestCase>(); 
		
		for (InterfaceEdge e : actualEdge.getTo().getOutTransitions()) {
			for (int i = 0; i < loopEnd; i++) {
				if (testSuite.get(i).get(testSuite.get(i).size() - 1).equals(actualEdge) && !notToVisitEdges.contains(e)) {
					TestCase newTestCase = new TestCase(testSuite.get(i));
					newTestCase.add(e);
					testSuite.add(newTestCase);
					takeOut(newTestCase, testSuite);
					uselessTestCases.add(testSuite.get(i));
				}
			}
		}
			
		testSuite.removeAll(uselessTestCases);
	}
	
	private void takeOut(TestCase testCase, List<TestCase> testSuite) {
		HashMap<InterfaceEdge, Integer> coverageMap = new HashMap<InterfaceEdge, Integer>();
		
		Iterator<InterfaceEdge> iterator = testCase.iterator();
		
		while(iterator.hasNext()){
		//for (InterfaceEdge edge : testCase) {
			InterfaceEdge edge = iterator.next();
			if (!coverageMap.containsKey(edge)) {
				coverageMap.put(edge, 0);
			} else {
				coverageMap.put(edge, coverageMap.get(edge) + 1);
			}
			
			if (coverageMap.get(edge) >= nLoopCoverage && elementFrequency(testCase, testCase.get(testCase.size() - 2)) == 1 && testCase.size() > 1) {
				notToVisitEdges.add(testCase.get(testCase.size() - 2));
				break;
			}
 		}
	}
	
	private int elementFrequency(TestCase testCase, InterfaceEdge edge) {
		int frequency = 0;
		
		for (InterfaceEdge e : testCase) {
			if (edge.equals(e)) {
				frequency++;
			}
		}
		
		return frequency;
	}
	
	private void cleanTestSuite(List<TestCase> testSuite) {
		List<TestCase> testSuiteCopy = new ArrayList<TestCase>(testSuite);
		
		for (TestCase e : testSuiteCopy) {
			if (!e.get(e.size() - 1).getTo().isLeaf()) {
				testSuite.remove(e);
			}
		}
	}
	
	private List<TestCase> initializeTestSuite(InterfaceVertex root) {
		List<TestCase> testSuite = new ArrayList<TestCase>();
	    	
		for (InterfaceEdge i : root.getOutTransitions()) {
			TestCase tempTestCase = new TestCase();
			tempTestCase.add(i);
			testSuite.add(tempTestCase);
		}
			
		return testSuite;
	}
}