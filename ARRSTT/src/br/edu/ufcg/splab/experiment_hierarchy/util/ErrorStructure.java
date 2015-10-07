package br.edu.ufcg.splab.experiment_hierarchy.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-08-02
 * 
 */
/**
 *<b>Objective:</b> This class is responsible for counting the amount of defects, defective
 *edges and failures in a TestSuite.
 *<br>
 *<b>Description of use:</b> This is used in some ARRSTT Selection experiment's dependent 
 *variable collectors. After this structure is created with a TestSuite, it can return the
 *amount of defects, defective edges and failures.
 */
public class ErrorStructure {
    private static String[] failures = {"ERROR"};
    private Map<TestCase, Set<String>> testCaseErrorData;
    
    /**
     * Class constructor. It receives the TestSuite that is going to be evaluated.
     * @param ts
     * 		the TestSuite that is going to be evaluated.
     */
    public ErrorStructure(TestSuite ts) {
        this.testCaseErrorData = buildStructure(ts);
    }
    
    private Map<TestCase, Set<String>> buildStructure(TestSuite ts) {
        Map<TestCase, Set<String>> caseMap = new HashMap<TestCase, Set<String>>();
        
		for (TestCase tc : ts) {
			for (InterfaceEdge edge : tc) {
				for (String fail : failures) {
				    if (edge.getLabel().equals(fail)) {
				        if(!caseMap.containsKey(tc))
				            caseMap.put(tc, new HashSet<String>());
				        caseMap.get(tc).add(fail);
				    }
				}
			}
		}
		
		return caseMap;
	}
	
    /**
     * <b>Objective:</b> It calculates and returns the amount of defects in the TestSuite.
     * <br>
     * <b>Exemple of use:</b> Used in ARRSTTDefectsCollector.
     * @return The amount of defects.
     */
	public int countDefects() {
	    Set<TestCase> keys = testCaseErrorData.keySet();
	    Iterator<TestCase> keysIt = keys.iterator();
	    Set<String> defects = new HashSet<String>();
	    
	    while (keysIt.hasNext()) {
	        defects.addAll(testCaseErrorData.get(keysIt.next()));
	    }
	    
	    return defects.size();
	}
	
	/**
     * <b>Objective:</b> It calculates and returns the amount of defective edges in the TestSuite.
     * <br>
     * <b>Exemple of use:</b> Used in ARRSTTDefectiveEdgesCollector.
     * @return The amount of defective edges.
     */
	public int countDefectiveEdges() {
		Set<TestCase> keys = testCaseErrorData.keySet();
	    Iterator<TestCase> keysIt = keys.iterator();
	    Set<InterfaceEdge> defectiveEdges = new HashSet<InterfaceEdge>();
	    
	    while (keysIt.hasNext()) {
	    	TestCase iteratingTestCase = keysIt.next();
	    	
	    	for (String fail : failures) {
	    		for (InterfaceEdge edge : iteratingTestCase) {
	    			if (edge.getLabel().equals(fail)) {
	    				defectiveEdges.add(edge);
	    			}
	    		}
	    	}
	    }
	    
	    return defectiveEdges.size();
	}
	
	/**
     * <b>Objective:</b> It calculates and returns the amount of failures in the TestSuite.
     * <br>
     * <b>Exemple of use:</b> Used in ARRSTTFailuresCollector.
     * @return The amount of failures.
     */
	public int countFails() {
	    return testCaseErrorData.size();
	}
}
