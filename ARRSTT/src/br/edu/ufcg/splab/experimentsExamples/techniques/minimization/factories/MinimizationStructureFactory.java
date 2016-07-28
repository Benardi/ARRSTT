package br.edu.ufcg.splab.experimentsExamples.techniques.minimization.factories;

import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestCase;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.requirements.TestRequirement;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.structures.MinimizationStructure;

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
