package br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;

public class GreedyStructure {
	private Map<TestCase, List<InterfaceEdge>> map;

	public GreedyStructure(Map<List<InterfaceEdge>, Set<TestCase>> inputMap) {
		this.map = buildMap(inputMap);
		System.out.println(map);
	}
	
	
	
	public TestCase selectGreedyTestCase() {
		TestCase biggestTestCase = getBiggestTestCase();
		
		
		
		return biggestTestCase;
	}
	
	private void removeReqs(List<InterfaceEdge> reqs) {
		
	}

	private TestCase getBiggestTestCase() {
		Map<Integer, List<TestCase>> sizeMap = new HashMap<Integer, List<TestCase>>();
		
		int highestSize = 0;
		for (TestCase tc : map.keySet()) {
			if (!sizeMap.containsKey(map.get(tc).size())) {
				sizeMap.put(map.get(tc).size(), new ArrayList<TestCase>());
			}
			
			sizeMap.get(map.get(tc).size()).add(tc);
			
			if (map.get(tc).size() > highestSize) highestSize = map.get(tc).size();
		}
		
		List<TestCase> biggestTestCases = sizeMap.get(highestSize);
		
		return biggestTestCases.get(randIndex(biggestTestCases.size()));
	}
	
	private int randIndex(int size) {
		Random random = new Random();
		return random.nextInt(size);
	}
	
	private Map<TestCase, List<InterfaceEdge>> buildMap(Map<List<InterfaceEdge>, Set<TestCase>> inputMap) {
		Map<TestCase, List<InterfaceEdge>> map = new HashMap<TestCase, List<InterfaceEdge>>();
		
		fillKeys(map, inputMap);
		fillValues(map, inputMap);
		
		
		return map;
	}
	
	private void fillKeys(Map<TestCase, List<InterfaceEdge>> map, Map<List<InterfaceEdge>, Set<TestCase>> inputMap) {
		for (Set<TestCase> testSuite : inputMap.values()) {
			for (TestCase tc : testSuite) {
				map.put(tc, new ArrayList<InterfaceEdge>());
			}
		}
	}
	
	private void fillValues(Map<TestCase, List<InterfaceEdge>> map, Map<List<InterfaceEdge>, Set<TestCase>> inputMap) {
		for (List<InterfaceEdge> edges : inputMap.keySet()) {
			for (TestCase tc : map.keySet()) {
				if (tc.containsAll(edges)) {
					map.get(tc).addAll(edges);
				}
			}
		}
	}
	
	
}
