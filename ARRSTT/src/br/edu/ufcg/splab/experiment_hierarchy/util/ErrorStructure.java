package br.edu.ufcg.splab.experiment_hierarchy.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;

public class ErrorStructure {
    private static String[] failures = {"ERROR"};
    private Map<TestCase, Set<String>> testCaseErrorData;
    
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
	
	public int countDefects() {
	    Set<TestCase> keys = testCaseErrorData.keySet();
	    Iterator<TestCase> keysIt = keys.iterator();
	    Set<String> defects = new HashSet<String>();
	    
	    while (keysIt.hasNext()) {
	        defects.addAll(testCaseErrorData.get(keysIt.next()));
	    }
	    
	    return defects.size();
	}
	
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
	
	public int countFails() {
	    return testCaseErrorData.size();
	}
}
