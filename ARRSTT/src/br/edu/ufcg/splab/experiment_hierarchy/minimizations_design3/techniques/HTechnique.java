package br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.techniques;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.algorithms.InterfaceMinimizationAlgorithm;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.factories.MinimizationAlgorithmFactory;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.factories.MinimizationStructureFactory;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class HTechnique implements InterfaceMinimizationTechnique {
	private MinimizationStructure structure;
	
	public HTechnique(TestSuite testSuite, List<TestRequirement> requirements) {
		MinimizationStructureFactory factory = new MinimizationStructureFactory();
		this.structure = factory.createStructure(testSuite, requirements);
	}

	@Override
	public TestSuite minimize() {
		MinimizationAlgorithmFactory factory = new MinimizationAlgorithmFactory();
		
		InterfaceMinimizationAlgorithm harroldAlgorithm = factory.createHarroldAlgorithm();
		
		TestSuite minimizationTestSuite = new TestSuite();
		
		while (!structure.isEmpty()) {
			minimizationTestSuite.add(harroldAlgorithm.execute(structure));
		}
		
		return minimizationTestSuite;
	}
}
