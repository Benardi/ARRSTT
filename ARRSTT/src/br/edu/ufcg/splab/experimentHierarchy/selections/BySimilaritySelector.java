package br.edu.ufcg.splab.experimentHierarchy.selections;

import java.util.Random;

import br.edu.ufcg.splab.experimentHierarchy.util.matrix.SelectionMatrix;
import br.edu.ufcg.splab.experimentHierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experimentHierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph.core.InterfaceEdge;

public class BySimilaritySelector {
    private int selectingAmount;
    private TestSuite originalTS;
    private TestSuite selectedTS;
    private SelectionMatrix matrix;
    
    public BySimilaritySelector(TestSuite ts, Double percentage) {
        selectingAmount = getAmountOfTestCases(ts, percentage);
        originalTS = ts;
    }
    
    private int getAmountOfTestCases(TestSuite ts, Double percentage){
        return (int) Math.ceil(originalTS.size() * percentage);
    }
    
    public TestSuite select() {
        matrix = buildMatrix();
        selectedTS = new TestSuite(originalTS);
        
        int limitIterations = originalTS.size() - selectingAmount;
        
        for(int i = 0; i < limitIterations; i++) {
            int removingPosition = chooseRemoval(matrixMaxPos());
            removeFromMatrix(removingPosition);
            selectedTS.nulify(removingPosition);
        }
      
        cleanTestSuite();
        return selectedTS;
    }
    
    private SelectionMatrix buildMatrix() {
        SelectionMatrix matrix = new SelectionMatrix(originalTS.size(), originalTS.size());
        
        for(int i = 0; i < originalTS.size(); i++ ) {
            for(int j = 0; j < originalTS.size(); j++ ) {
                if(i >= j) {
                    matrix.setPos(i, j, -1.0);
                } else {
                    matrix.setPos(i, j, getSimilarity(originalTS.get(i), originalTS.get(j)));
                }
            }
        }
        
        return matrix;
    }
    
    private double getSimilarity(TestCase tc1, TestCase tc2) {
        return calculateNit(tc1, tc2) / ((tc1.size() + tc2.size()) / 2);
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
    
    private int[] matrixMaxPos(){
        double max = 0;
        int[] position = new int[2];
        
        for(int i = 0; i < originalTS.size(); i++) {
            for(int j = i + 1; j < originalTS.size(); j++) {
                if(matrix.get(i, j) >= max) {
                    max = matrix.get(i, j);
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        
        return position;
    }
    
    private int chooseRemoval(int[] maxPos) {
        if(originalTS.get(maxPos[0]).size() < originalTS.get(maxPos[1]).size()) {
            return maxPos[0];
        } else if(originalTS.get(maxPos[1]).size() < originalTS.get(maxPos[0]).size()) {
            return maxPos[1];
        } else {
            Random randomGenerator = new Random();
            return maxPos[randomGenerator.nextInt(2)];
        }
    }
    
    private void removeFromMatrix(int pos) {
    	matrix.removeCol(pos);
    	matrix.removeRow(pos);
    }
    
    private void cleanTestSuite() {
    	 for (int i = selectedTS.size() - 1; i >= 0; i--)
         	if (selectedTS.get(i) == null) selectedTS.remove(i);
    }
}