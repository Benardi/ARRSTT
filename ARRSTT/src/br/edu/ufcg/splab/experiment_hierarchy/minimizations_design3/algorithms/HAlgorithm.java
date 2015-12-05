package br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.Randomizer;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;

public class HAlgorithm implements InterfaceMinimizationAlgorithm {
	@Override
	public TestCase execute(MinimizationStructure structure) {
		Map<Integer, List<TestRequirement>> cardinalityMap = createCardinalityMap(structure);
		List<Integer> orderedCardinality = new ArrayList<Integer>(cardinalityMap.keySet());
		Collections.sort(orderedCardinality);
		
		
		Set<TestCase> potencialTestCases = new HashSet<TestCase>();
		TestCase selectedTestCase = null;
		
		for (Integer cardinality : orderedCardinality) {
			List<TestRequirement> reqs = cardinalityMap.get(cardinality);
			
			for (TestRequirement req : reqs) {
				potencialTestCases.addAll(structure.getTestCases(req));
			}
			
			selectedTestCase = mostEssencialTestCase(potencialTestCases, structure);
			
			if (selectedTestCase != null) {
				structure.removeAllTuples(structure.getTestRequirements(selectedTestCase));
				return selectedTestCase;
			}
		}
		
		selectedTestCase = Randomizer.getRandomTestCase(potencialTestCases);
		structure.removeAllTuples(structure.getTestRequirements(selectedTestCase));
		return selectedTestCase;
	}
	
	private Map<Integer, List<TestRequirement>> createCardinalityMap(MinimizationStructure structure) {
		Map<Integer, List<TestRequirement>> cardinalityMap = new HashMap<Integer, List<TestRequirement>>();
		
		for (TestRequirement req : structure.getTestRequirements()) {
			int size = structure.getTestCases(req).size();
			
			if (!cardinalityMap.containsKey(size)) {
				cardinalityMap.put(size, new ArrayList<TestRequirement>());
			}
			
			cardinalityMap.get(size).add(req);
		}
		
		return cardinalityMap;
	}
	
	private TestCase mostEssencialTestCase(Set<TestCase> testCases, MinimizationStructure structure) {
		TestCase mostEssentialTestCase = null;
		int maxSize = 0;
		
		for (TestCase testCase : testCases) {
			int size = structure.getTestRequirements(testCase).size();
			
			if (size > maxSize) {
				maxSize = size;
				mostEssentialTestCase = testCase;
			} else if (size == maxSize) {
				return null;
			}
		}
		
		return mostEssentialTestCase;
	}
}
