package br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.techniques;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.Randomizer;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;

public class Harrold implements InterfaceMinimizationTechnique {
	private MinimizationStructure structure;
	
	public Harrold(MinimizationStructure structure) {
		this.structure = structure;
	}

	@Override
	public TestCase minimize() {
		Map<Integer, List<TestRequirement>> cardinalityMap = createCardinalityMap();
		List<Integer> orderedCardinality = new ArrayList<Integer>(cardinalityMap.keySet());
		Collections.sort(orderedCardinality);
		
		
		Set<TestCase> potencialTestCases = new HashSet<TestCase>();
		TestCase selectedTestCase = null;
		
		for (Integer cardinality : orderedCardinality) {
			List<TestRequirement> reqs = cardinalityMap.get(cardinality);
			
			for (TestRequirement req : reqs) {
				potencialTestCases.addAll(structure.getTestCases(req));
			}
			
			selectedTestCase = mostEssencialTestCase(potencialTestCases);
			
			if (selectedTestCase != null) {
				structure.removeTuples(selectedTestCase);
				return selectedTestCase;
			}
		}
		
		selectedTestCase = Randomizer.getRandomTestCase(potencialTestCases);
		structure.removeTuples(selectedTestCase);
		return selectedTestCase;
	}
	
	private Map<Integer, List<TestRequirement>> createCardinalityMap() {
		Map<Integer, List<TestRequirement>> cardinalityMap = new HashMap<Integer, List<TestRequirement>>();
		
		for (TestRequirement req : structure.getTestRequirements()) {
			int size = structure.getTestCases(req).size();
			
			if (cardinalityMap.containsKey(size)) {
				cardinalityMap.put(size, new ArrayList<TestRequirement>());
			}
			
			cardinalityMap.get(size).add(req);
		}
		
		return cardinalityMap;
	}
	
	private TestCase mostEssencialTestCase(Set<TestCase> testCases) {
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
