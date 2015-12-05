package br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.techniques;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.MinimizationAlgorithmFactory;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.MinimizationStructureFactory;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.algorithms.InterfaceMinimizationAlgorithm;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class GRETechnique implements InterfaceMinimizationTechnique {
	private MinimizationStructure structure;
	
	public GRETechnique(TestSuite testSuite, List<TestRequirement> requirements) {
		MinimizationStructureFactory factory = new MinimizationStructureFactory();
		this.structure = factory.createStructure(testSuite, requirements);
	}
	
	public TestSuite minimize() {
		MinimizationAlgorithmFactory factory = new MinimizationAlgorithmFactory();
		
		InterfaceMinimizationAlgorithm greedyAlgorithm = factory.createGreedyAlgorithm();
		InterfaceMinimizationAlgorithm essentialRedundantAlgorithm = factory.createEssentialRedundantAlgorithm();
		
		TestSuite minimizedTestSuite = new TestSuite();
		
		
		while (!structure.isEmpty()) {
			TestCase tCase  = essentialRedundantAlgorithm.execute(structure);
			
			if (tCase == null) {
				tCase = greedyAlgorithm.execute(structure);
			}
			
			minimizedTestSuite.add(tCase);
		}
		
		return minimizedTestSuite;
	}
	
	
}
