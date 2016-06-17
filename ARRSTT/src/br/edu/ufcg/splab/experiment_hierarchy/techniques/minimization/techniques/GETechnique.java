package br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.techniques;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.factories.MinimizationStructureFactory;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.minimization.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.Randomizer;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class GETechnique implements InterfaceMinimizationTechnique {
	private MinimizationStructure structure;
	
	public GETechnique(TestSuite originalTestSuite, List<TestRequirement> testRequirements){
		TestSuite testSuite = new TestSuite(originalTestSuite);
		MinimizationStructureFactory factory = new MinimizationStructureFactory();
		this.structure = factory.createStructure(testSuite, testRequirements);
	}
	
	@Override
	public TestSuite minimize() {
		TestSuite minimizedTestSuite = new TestSuite();
		
		
		while (!structure.isEmpty()) {
			TestCase tCase = doEssential();
			
			if (tCase == null) {
				tCase = doGreedy();
			}
			
			minimizedTestSuite.add(tCase);
		}
		
		return minimizedTestSuite;
	}
	
	private TestCase doEssential() {
		Set<TestRequirement> reqs = structure.getTestRequirements();
		List<TestCase> essentialTestCases = new ArrayList<>();
		for(TestRequirement req : reqs){
			if(structure.getTestCases(req).size() == 1){
				essentialTestCases.addAll(structure.getTestCases(req));
			}
		}
		
		TestCase selected = null;
		
		if (!essentialTestCases.isEmpty()) {
			selected = Randomizer.getRandomTestCase(essentialTestCases);
			structure.removeAllTuples(structure.getTestRequirements(selected));
		}
		
		return selected;
	}
	
	private TestCase doGreedy() {
		int biggestSize = -1;
		Set<TestCase> tCases = structure.getTestCases();
		List<TestCase> biggestTestCases = new ArrayList<>();
		int currentSize;
		
		for(TestCase tc : tCases){
			currentSize = structure.getTestRequirements(tc).size();
			
			if(currentSize >= biggestSize){
				if(currentSize > biggestSize){
					biggestTestCases = new ArrayList<>();
					biggestSize = currentSize;
				}
				
				biggestTestCases.add(tc);
			}
		}
		
		TestCase selected = null;
		if (!biggestTestCases.isEmpty()) {
			selected = Randomizer.getRandomTestCase(biggestTestCases);
			
			structure.removeAllTuples(structure.getTestRequirements(selected));
		}
		
		return selected;
	}
}
