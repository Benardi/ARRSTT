package br.edu.ufcg.splab.experimentsExamples.techniques.minimization.techniques;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestCase;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.factories.MinimizationStructureFactory;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.requirements.TestRequirement;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.structures.MinimizationStructure;
import br.edu.ufcg.splab.experimentsExamples.util.Randomizer;


public class GTechnique implements InterfaceMinimizationTechnique {
	private MinimizationStructure structure;
	
	public GTechnique(TestSuite originalTestSuite, List<TestRequirement> requirements){
		TestSuite testSuite = new TestSuite(originalTestSuite);
		MinimizationStructureFactory factory = new MinimizationStructureFactory();
		this.structure = factory.createStructure(testSuite, requirements);
	}
	
	public TestSuite minimize() {
		TestSuite minimizedTestSuite = new TestSuite();
		while (!structure.isEmpty()) {
			minimizedTestSuite.add(doGreedy());
		}
		
		return minimizedTestSuite;
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
