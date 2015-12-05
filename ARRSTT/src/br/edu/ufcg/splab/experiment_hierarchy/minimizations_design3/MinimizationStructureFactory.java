package br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class MinimizationStructureFactory {
	
	public MinimizationStructure createStructure(TestSuite testSuite, List<TestRequirement> requirements) {
		MinimizationStructure creatingStructure = new MinimizationStructure();
		
		for (TestCase tc : testSuite) {
			for (TestRequirement req : requirements) {
				if (req.isCoveredBy(tc)) {
					creatingStructure.insert(tc, req);
				}
			}
		}
		
		return creatingStructure;
	}
}
