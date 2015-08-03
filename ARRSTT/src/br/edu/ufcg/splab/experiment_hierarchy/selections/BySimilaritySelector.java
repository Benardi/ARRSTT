package br.edu.ufcg.splab.experiment_hierarchy.selections;

import java.util.Random;

import br.edu.ufcg.splab.experiment_hierarchy.util.matrix.Matrix;
import br.edu.ufcg.splab.experiment_hierarchy.util.matrix.SimilarityStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class BySimilaritySelector {
    private int selectingAmount;
    private TestSuite originalTS;
    private TestSuite selectedTS;
    private Matrix matrix;
    
    public BySimilaritySelector(TestSuite ts, Double percentage) {
        matrix = new SimilarityStructure(ts);
        selectingAmount = (int) Math.ceil(originalTS.size() * percentage);
        originalTS = ts;
    }
    
    public TestSuite select() {
        selectedTS = new TestSuite(originalTS);
        
        int limitIterations = originalTS.size() - selectingAmount;
        
        for(int i = 0; i < limitIterations; i++) {
            int removingPosition = chooseRemoval();
            removeFromMatrix(removingPosition);
            selectedTS.nulify(removingPosition);
        }
      
        cleanTestSuite();
        return selectedTS;
    }
    
    private int chooseRemoval() {
        int[] maxPos = matrix.findMaxPos();
        
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