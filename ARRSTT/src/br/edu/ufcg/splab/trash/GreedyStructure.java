package br.edu.ufcg.splab.trash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements.ARRSTTTestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-10-26
 * Refactoring and fixes										Iaron Araujo		2015-10-28
 */
public class GreedyStructure {
	private Map<TestCase, List<ARRSTTTestRequirement>> map;
	private Map<ARRSTTTestRequirement, Set<TestCase>> reqTracer;
	
	public GreedyStructure(Map<ARRSTTTestRequirement, Set<TestCase>> inputMap) {
		this.map = buildMap(inputMap);
		this.reqTracer = inputMap;
	}
	
	
	private Map<TestCase, List<ARRSTTTestRequirement>> buildMap(Map<ARRSTTTestRequirement, Set<TestCase>> inputMap) {
		Map<TestCase, List<ARRSTTTestRequirement>> map = new HashMap<TestCase, List<ARRSTTTestRequirement>>();
		fill(map, inputMap);
		return map;
	}
	
	private void fill(Map<TestCase, List<ARRSTTTestRequirement>> map, Map<ARRSTTTestRequirement, Set<TestCase>> inputMap){
		for(ARRSTTTestRequirement req: inputMap.keySet()){
			for(TestCase tc : inputMap.get(req)){
				//This if is necessary so that each TestCase has a list of requirements
				if(!map.containsKey(tc)){
					map.put(tc, new ArrayList<ARRSTTTestRequirement>());
				}
				//This add a requirement that the current TestCase covers.
				map.get(tc).add(req);
			}
		}
	}
	
	public TestCase selectGreedyTestCase() {
		TestCase biggestTestCase = getBiggestTestCase();
		removeReqs(biggestTestCase);
		return biggestTestCase;
	}
	
	public boolean isEmptyOnReqs() {
		System.out.println(map);
		
		for (TestCase tc : map.keySet()) {
			if (!map.get(tc).isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	public TestCase selectEssencialTestCase() {
		TestCase essencialTC = getEssencialTestCase();
		
		if (essencialTC == null) {
			return null;
		}
		
		removeReqs(essencialTC);
		return essencialTC;
	}
	
	public TestCase selectRedundantTestCase() {
		TestCase redundantTestCase = getRedundantTestCase();
		if (redundantTestCase == null) {
			return null;
		}
		
		removeReqs(redundantTestCase);
		return redundantTestCase;
	}
	
	private TestCase getRedundantTestCase() {
		for (TestCase tc : map.keySet()) {
			for (TestCase tc2 : map.keySet()) {
				if (!tc.equals(tc2)) {
					if (tc.containsAll(tc2)) {
						return tc;
					}
				}
			}
		}
		
		return null;
	}
	
	private TestCase getEssencialTestCase() {
		for (ARRSTTTestRequirement req: reqTracer.keySet()) {
			if (reqTracer.get(req).size() == 1) {
				Iterator<TestCase> it = reqTracer.get(req).iterator();
				TestCase tc = it.next();
				reqTracer.remove(req);
				return tc;
			}
		}
		
		return null;
	}
	
	private void removeReqs(TestCase biggestTestCase) {
		List<ARRSTTTestRequirement> reqsToBeRemoved = map.get(biggestTestCase);
		
		for (ARRSTTTestRequirement req : reqTracer.keySet()) {
			reqTracer.get(req).remove(biggestTestCase);
		}
		
		for(TestCase tc: map.keySet()){
			//The deletion of the biggestTestCase will happen in the end of the method.
			if(tc.equals(biggestTestCase)) continue;
			for(ARRSTTTestRequirement req : reqsToBeRemoved){
				map.get(tc).remove(req);
			}
		}
		
		map.remove(biggestTestCase);		
	}

	private TestCase getBiggestTestCase() {
		Map<Integer, List<TestCase>> sizeMap = new HashMap<Integer, List<TestCase>>();
		
		int highestSize = 0;
		int currentTCsize;
		
		/*This for calculates the amount of requirements each TestCase covers and puts
		 *this information into the sizeMap.
		 */
		for (TestCase tc : map.keySet()) {
			currentTCsize = map.get(tc).size();
			
			// Adds new size to the sizeMap.
			if (!sizeMap.containsKey(currentTCsize)) {
				sizeMap.put(currentTCsize, new ArrayList<TestCase>());
			}
			
			sizeMap.get(currentTCsize).add(tc);
			
			if (currentTCsize > highestSize){
				highestSize = currentTCsize;
			}
		}
		
		List<TestCase> biggestTestCases = sizeMap.get(highestSize);
		return biggestTestCases.get(randIndex(biggestTestCases.size()));
	}
	
	private int randIndex(int size) {
		Random random = new Random();
		return random.nextInt(size);
	}
}
