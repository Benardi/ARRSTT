package br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.techniques;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.algorithms.InterfaceMinimizationAlgorithm;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.factories.MinimizationAlgorithmFactory;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.factories.MinimizationStructureFactory;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class GETechnique implements InterfaceMinimizationTechnique {
	private MinimizationStructure structure;
	
	public GETechnique(TestSuite testSuite, List<TestRequirement> testRequirements){
		MinimizationStructureFactory factory = new MinimizationStructureFactory();
		this.structure = factory.createStructure(testSuite, testRequirements);
	}
	
	@Override
	public TestSuite minimize() {
		MinimizationAlgorithmFactory factory = new MinimizationAlgorithmFactory();
		
		InterfaceMinimizationAlgorithm greedyAlgorithm = factory.createGreedyAlgorithm();
		InterfaceMinimizationAlgorithm essentialAlgorithm = factory.createEssentialAlgorithm();
		
		TestSuite minimizedTestSuite = new TestSuite();
		
		
		while (!structure.isEmpty()) {
			TestCase tCase = essentialAlgorithm.execute(structure);
			
			if (tCase == null) {
				tCase = greedyAlgorithm.execute(structure);
			}
			
			minimizedTestSuite.add(tCase);
		}
		
		return minimizedTestSuite;
	}
}
