package br.edu.ufcg.splab.experiment_hierarchy.minimizations_design1.techniques;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design1.MinimizationStructureFactory;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design1.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design1.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.Randomizer;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class HTechnique implements InterfaceMinimizationTechnique {
private MinimizationStructure structure;
	
	public HTechnique(TestSuite testSuite, List<TestRequirement> requirements){
		MinimizationStructureFactory factory = new MinimizationStructureFactory();
		this.structure = factory.createStructure(testSuite, requirements);
	}
	
	@Override
	public TestSuite minimize() {
		TestSuite minimizedTestSuite = new TestSuite();
		
		while (!structure.isEmpty()) {
			minimizedTestSuite.add(doHarrold());
		}
		
		return minimizedTestSuite;
	}
	
	protected TestCase doHarrold() {
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
