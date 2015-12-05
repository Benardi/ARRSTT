package br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.Randomizer;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;

public class EAlgorithm implements InterfaceMinimizationAlgorithm {
	@Override
	public TestCase execute(MinimizationStructure structure) {
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
			structure.removeTuples(selected);
		}
		
		return selected;
	}
}
