package br.edu.ufcg.splab.experiment_hierarchy.util;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;

/**
 * Objective: Used in the Selection by Similarity class, this class is
 * responsible for the calculation of similarities.
 * 
 * Description of use: Two test cases are passed to this class so it can
 * calculate how many similarities are between both and return it as a number.
 *
 */
public class SimilarityCalculator {
	/**
	 * Objective: Measures the similarity between two given test cases.
	 * 
	 * Description of use: Receives two test cases and generates a value that
	 * represent how similar they are.
	 * 
	 * @param tc1
	 *            The first test case.
	 * @param tc2
	 *            The second test case.
	 * @return The similarity between tc1 and tc2.
	 */
	public double getSimilarity(TestCase tc1, TestCase tc2) {
		return calculateNit(tc1, tc2) / ((tc1.size() + tc2.size()) / 2.0);
	}

	/**
	 * Objective: Measure how many elements are shared between two test cases.
	 * 
	 * Description of use: Used by the method getSimilarity as part of its
	 * calculus.
	 * 
	 * @param tc1
	 *            The first test case.
	 * @param tc2
	 *            The second test case.
	 * @return The number of elements shared between tc1 and tc2.
	 */
	private int calculateNit(TestCase tc1, TestCase tc2) {
		int nitCount = 0;

		for (InterfaceEdge edge : tc1) {
			if (tc2.contains(edge)) {
				nitCount++;
			}
		}

		return nitCount;
	}
}