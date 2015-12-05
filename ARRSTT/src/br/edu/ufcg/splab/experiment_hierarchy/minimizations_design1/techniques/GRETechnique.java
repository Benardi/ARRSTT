package br.edu.ufcg.splab.experiment_hierarchy.minimizations_design1.techniques;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design1.MinimizationStructureFactory;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design1.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design1.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class GRETechnique implements InterfaceMinimizationTechnique {
	private MinimizationStructure structure;
	
	public GRETechnique(TestSuite testSuite, List<TestRequirement> requirements) {
		MinimizationStructureFactory factory = new MinimizationStructureFactory();
		this.structure = factory.createStructure(testSuite, requirements);
	}
	
	public GRETechnique(MinimizationStructure structure){
		this.structure = structure;
	}
	
	@Override
	public TestSuite minimize() {
		TestSuite minimizedTestSuite = new TestSuite();
		GTechnique gTechnique = new GTechnique(this.structure);
		GETechnique geTechnique = new GETechnique(this.structure);
		
		while (!structure.isEmpty()) {
			TestCase tCase  = doOneToOneRedundantEssencial(geTechnique);
			
			if (tCase == null) {
				tCase = gTechnique.doGreedy();
			}
			
			minimizedTestSuite.add(tCase);
		}
		
		return minimizedTestSuite;
	}
	
	protected TestCase doOneToOneRedundantEssencial(GETechnique geTechnique) {
		Set<TestCase> tCases = structure.getTestCases();
		Set<TestCase> toBeRemoved = new HashSet<>();
		for(TestCase tc : tCases){
			for(TestCase tc2 : tCases){
				if(! tc.equals(tc2) && tc.containsAll(tc2)){
					toBeRemoved.add(tc2);
				}
			}
		}
		
		for(TestCase removed : toBeRemoved){
			structure.removeTuples(removed);
		}
		
		return geTechnique.doEssencial();
	}
}
