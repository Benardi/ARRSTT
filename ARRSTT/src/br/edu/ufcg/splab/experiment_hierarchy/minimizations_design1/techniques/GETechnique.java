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

public class GETechnique implements InterfaceMinimizationTechnique {
	private MinimizationStructure structure;
	
	public GETechnique(TestSuite testSuite, List<TestRequirement> requirements){
		MinimizationStructureFactory factory = new MinimizationStructureFactory();
		this.structure = factory.createStructure(testSuite, requirements); 
	}
	
	public GETechnique(MinimizationStructure structure) {
		this.structure = structure;
	}
	
	@Override
	public TestSuite minimize() {
		TestSuite minimizedTestSuite = new TestSuite();
		GTechnique gTechnique = new GTechnique(this.structure);
		
		while (!structure.isEmpty()) {
			TestCase tCase = this.doEssencial();
			
			if (tCase == null) {
				tCase = gTechnique.doGreedy();
			}
			
			minimizedTestSuite.add(tCase);
		}
		
		return minimizedTestSuite;
	}
	
	protected TestCase doEssencial() {
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
