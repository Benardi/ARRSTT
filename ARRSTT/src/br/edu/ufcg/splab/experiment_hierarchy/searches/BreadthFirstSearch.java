package br.edu.ufcg.splab.experiment_hierarchy.searches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Bernardi Nunes		2015-04-04
 * 
 */
/**
 * <b>Objective:</b> This interface represents a TestSuite generation algorithm that
 * is based on the graph search BFS.
 * <br>
 * <b>Description of use:</b> This interface is used to generate a TestSuite from a graph.
 *
 */
public class BreadthFirstSearch implements InterfaceSearch {
	/**
	 * The list of edges that the search cannot visit anymore.
	 */
	private List<InterfaceEdge> notToVisitEdges;
	/**
	 * A queue that tells the algorithm the order and edges to search.
	 */
	private Queue<InterfaceEdge> queue;
	/**
	 * The test suite that will be generated.
	 */
	private TestSuite testSuite;
	/**
	 * An integer representing the loop coverage of the algorithm.
	 */
	private int nLoopCoverage;

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
	public TestSuite getTestSuite(InterfaceVertex root, int nLoopCoverage) {
		return search(root, nLoopCoverage);
	}

	/**
	 * Initialize attributes and call for manageTestSuite() that
	 * will put the testCases inside the testSuite.
	 * 
	 * @param root
	 * 			The root of the searching graph.
	 * @param nLoopCoverage
	 * 			A number representing the loop coverage of the search.
	 * @return
	 * 			The test suite.
	 */
	private TestSuite search(InterfaceVertex root, Integer nLoopCoverage) {
		this.notToVisitEdges = new ArrayList<InterfaceEdge>();
		this.testSuite = initializeTestSuite(root);
		this.queue = initializeQueue(root);
		this.nLoopCoverage = nLoopCoverage;
		
		manageTestSuite();
		return testSuite;
	}
	
	/**
	 * Initialize a new test suite variable with test cases
	 * containing all the root's out transition edges. Each
	 * edge goes a different test case.
	 * 
	 * @param root
	 * 			The root of the searching graph.
	 * @return
	 * 			The created test suite.
	 */
	private TestSuite initializeTestSuite(InterfaceVertex root) {
		TestSuite testSuite = new TestSuite();

		for (InterfaceEdge i : root.getOutTransitions()) {
			TestCase tempTestCase = new TestCase();
			tempTestCase.add(i);
			testSuite.add(tempTestCase);
		}

		return testSuite;
	}

	/**
	 * Initialize a new queue with all the root's out
	 * transitions in it.
	 * 
	 * @param root
	 * 			The root of the searching graph.
	 * @return
	 * 			The created queue.
	 */
	private Queue<InterfaceEdge> initializeQueue(InterfaceVertex root) {
		Queue<InterfaceEdge> queue = new LinkedList<InterfaceEdge>();
		queue.addAll(root.getOutTransitions());
		return queue;
	}

	/**
	 * Remove from the queue the head and add to tail the
	 * neighbors of actualEdge. This last step will only be
	 * done if the actualEdge's getTo() is not a leaf and it
	 * is not on the notToVisitEdges list.
	 * 
	 * @return
	 * 			The edge that was removed from the queue.
	 */
	private InterfaceEdge dequeue() {
		InterfaceEdge actualEdge = queue.poll();

		if (!actualEdge.getTo().isLeaf() && !notToVisitEdges.contains(actualEdge)) {
			queue.addAll(actualEdge.getTo().getOutTransitions());
		}

		return actualEdge;
	}

	/**
	 * This method call dequeue() and then splitTestSuite()
	 * until the queue is empty. At last, it calls for
	 * cleanTetSuite().
	 */
	private void manageTestSuite() {
		while (!queue.isEmpty()) {
			splitTestSuite(dequeue());
		}
		
		cleanTestSuite();
	}

	/**
	 * Split a test case into many test cases, as needed,
	 * while doing this it call for takeOut() and then
	 * remove from the test suite the useless test cases.
	 * 
	 * @param actualEdge
	 * 			The edge the BFS is now working with.
	 */
	private void splitTestSuite(InterfaceEdge actualEdge) {
		int loopEnd = testSuite.size();
		List<TestCase> uselessTestCases = new ArrayList<TestCase>();

		for (InterfaceEdge e : actualEdge.getTo().getOutTransitions()) {
			for (int i = 0; i < loopEnd; i++) {
				if (testSuite.get(i).get(testSuite.get(i).size() - 1).equals(actualEdge) 
						&& !notToVisitEdges.contains(e)) {
					TestCase newTestCase = new TestCase(testSuite.get(i));
					newTestCase.add(e);
					testSuite.add(newTestCase);
					takeOut(newTestCase);
					uselessTestCases.add(testSuite.get(i));
				}
			}
		}

		testSuite.removeAll(uselessTestCases);
	}

	/**
	 * Check on each list the number of each edge
	 * that is and then decide if it is needed
	 * to add this edge to the notToVisitEdge list.
	 * 
	 * @param testCase
	 * 			The testCase it will check.
	 */
	private void takeOut(TestCase testCase) {
		HashMap<InterfaceEdge, Integer> coverageMap = new HashMap<InterfaceEdge, Integer>();

		Iterator<InterfaceEdge> iterator = testCase.iterator();

		while (iterator.hasNext()) {
			InterfaceEdge edge = iterator.next();
			if (!coverageMap.containsKey(edge)) {
				coverageMap.put(edge, 1);
			} else {
				coverageMap.put(edge, coverageMap.get(edge) + 1);
			}

			if (coverageMap.get(edge) > nLoopCoverage + 1) {
				notToVisitEdges.add(testCase.get(testCase.size() - 2));
				testSuite.remove(testCase);
				break;
			}
		}
	}
	
	/**
	 * Removes from the test suite all test cases that does not 
	 * end with a leaf.
	 */
	private void cleanTestSuite() {
		List<TestCase> testSuiteCopy = new ArrayList<TestCase>(testSuite);

		for (TestCase e : testSuiteCopy) {
			if (!e.get(e.size() - 1).getTo().isLeaf()) {
				testSuite.remove(e);
			}
		}
	}
	
	public String getName(){
		return "BFS";
	}
}