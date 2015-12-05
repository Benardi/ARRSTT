package br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.techniques;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.Randomizer;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;

public class GreedyTechnique implements InterfaceMinimizationTechnique{
	
	private MinimizationStructure structure;
	
	public GreedyTechnique(MinimizationStructure structure){
		this.structure = structure;
	}
	
	@Override
	public TestCase minimize() {
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
