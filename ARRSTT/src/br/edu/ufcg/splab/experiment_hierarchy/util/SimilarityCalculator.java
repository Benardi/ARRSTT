package br.edu.ufcg.splab.experiment_hierarchy.util;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.graph.core.InterfaceEdge;

public class SimilarityCalculator {
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