package br.edu.ufcg.splab.experiment_hierarchy.util;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;

/**
 * The selection by similarity case needs a calculator of similarities,
 * this class takes care of these calculations. 
 *
 */
public class SimilarityCalculator {
	/**
	 * Calculates the similarity between two given test cases.
	 * 
	 * @param tc1 The first test case.
	 * @param tc2 The second test case.
	 * @return The similarity between tc1 and tc2.
	 */
    public double getSimilarity(TestCase tc1, TestCase tc2) {
        return calculateNit(tc1, tc2) / ((tc1.size() + tc2.size()) / 2.0);
    }
    
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