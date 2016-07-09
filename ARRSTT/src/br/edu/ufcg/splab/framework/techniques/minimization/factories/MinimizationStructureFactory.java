package br.edu.ufcg.splab.framework.techniques.minimization.factories;

import java.util.List;

import br.edu.ufcg.splab.framework.techniques.minimization.requirements.TestRequirement;
import br.edu.ufcg.splab.framework.techniques.minimization.structures.MinimizationStructure;
import br.edu.ufcg.splab.util.testcollections.TestCase;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

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
