package br.edu.ufcg.splab.experiment_hierarchy.util.matrix;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.util.SimilarityCalculator;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

/**
 * This class represents the structure needed for the
 * testcase selection based on similarity technique.
 *
 */
public class SimilarityStructure implements Matrix {
	/**
	 * The list of lists that represents this structure.
	 */
    private List<List<Double>> stair;
    /**
     * An object that calculates the similarity between two test cases.
     */
    private SimilarityCalculator similarityCalculator;
    
    /**
     * The class constructor. It also fills the structure with -1
     * in every position.
     * @param testSuite 
     * 			The test suite to have it's test cases' similarity analyzed.
     */
    public SimilarityStructure(TestSuite testSuite) {
    	this.similarityCalculator = new SimilarityCalculator();
        initializeList(testSuite);
        fillStair(testSuite);
    }
    
    private void initializeList(TestSuite testSuite) {
        stair = new ArrayList<List<Double>>();
        for(int i = 0; i < testSuite.size(); i++){
            stair.add(new ArrayList<Double>());
        }
    }
    
    private void fillStair(TestSuite ts) {
       for(int i = 0; i < ts.size(); i++){
           for(int j = 0; j <= i; j++){
               if(i == j){
                   stair.get(i).add(-1.0);
               } else {
                   Double similarity = new Double(similarityCalculator.getSimilarity(ts.get(i), ts.get(j)));
                   stair.get(i).add(similarity);
               }
           }
       }
    }
    
    public void setPos(int i, int j, double element){
        stair.get(i).set(j, element);
    }
    
    public double get(int row, int col) {
        return stair.get(row).get(col);
    }
    
	public boolean isEmpty() {
	    for (List<Double> list : stair) {
	        if (!list.isEmpty()) return false;
	    }
	    
	    return true;
	}
	
	public int getRowAmount() {
	    return stair.size();
	}
	
	public int getColAmount() {
	    return stair.size();
	}
	
	public void removeRow(int row) {
	    for(int i = 0; i < stair.get(row).size(); i++){
	        stair.get(row).set(i, -1.0);
	    }
	}
	
	public void removeCol(int col) {
	    for(int i = col + 1; i < getColAmount(); i++){
	        stair.get(i).set(col, -1.0);
	    }
	}
	
	public int[] findMaxPos() {
		Double max = -1.0;
		int[] maxPos = new int[2];
		
	    for (int i = 0; i < stair.size(); i++) {
	    	for (int j = 0; j <= i; j++) {
	    		if (max <= stair.get(i).get(j)) {
	    			maxPos[0] = i;
	    			maxPos[1] = j;
	    			max = stair.get(i).get(j);
	    		}
	    	}
	    }
	    
	    return maxPos;
	}
    
}
