package br.edu.ufcg.splab.experiment_hierarchy.minimizations_design1.techniques;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design1.MinimizationStructureFactory;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design1.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design1.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.Randomizer;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class GTechnique implements InterfaceMinimizationTechnique {
	private MinimizationStructure structure;
	
	public GTechnique(TestSuite testSuite, List<TestRequirement> requirements) {
		MinimizationStructureFactory factory = new MinimizationStructureFactory();
		this.structure = factory.createStructure(testSuite, requirements);
	}
	
	public GTechnique(MinimizationStructure structure){
		this.structure = structure;
	}
	
	@Override
	public TestSuite minimize() {
		TestSuite minimizedTestSuite = new TestSuite();
		
		while (!structure.isEmpty()) {
			minimizedTestSuite.add(doGreedy());
		}
		
		return minimizedTestSuite;
	}
	
	protected TestCase doGreedy() {
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
			structure.removeTuples(selected);
		}
		
		return selected;
	}
}
