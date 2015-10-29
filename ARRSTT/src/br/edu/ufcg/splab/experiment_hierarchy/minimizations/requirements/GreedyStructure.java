package br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestRequirementARRSTT;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-10-26
 * Refactoring and fixes										Iaron Araujo		2015-10-28
 */
public class GreedyStructure {
	private Map<TestCase, List<TestRequirementARRSTT>> map;

	public GreedyStructure(Map<TestRequirementARRSTT, Set<TestCase>> inputMap) {
		this.map = buildMap(inputMap);
		System.out.println(map);
	}
	
	
	private Map<TestCase, List<TestRequirementARRSTT>> buildMap(Map<TestRequirementARRSTT, Set<TestCase>> inputMap) {
		Map<TestCase, List<TestRequirementARRSTT>> map = new HashMap<TestCase, List<TestRequirementARRSTT>>();
		fill(map, inputMap);
		return map;
	}
	
	private void fill(Map<TestCase, List<TestRequirementARRSTT>> map, Map<TestRequirementARRSTT, Set<TestCase>> inputMap){
		for(TestRequirementARRSTT req: inputMap.keySet()){
			for(TestCase tc : inputMap.get(req)){
				//This if is necessary so that each TestCase has a list of requirements
				if(!map.containsKey(tc)){
					map.put(tc, new ArrayList<TestRequirementARRSTT>());
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
	
	private void removeReqs(TestCase biggestTestCase) {
		List<TestRequirementARRSTT> reqsToBeRemoved = map.get(biggestTestCase);
		for(TestCase tc: map.keySet()){
			//The deletion of the biggestTestCase will happen in the end of the method.
			if(tc.equals(biggestTestCase)) continue;
			for(TestRequirementARRSTT req : reqsToBeRemoved){
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
