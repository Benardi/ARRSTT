package br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.techniques;

import java.util.HashSet;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_unchanged_design.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;

public class OneToOneRedundantEssentialTechnique extends EssentialTechnique{
	
	
	public OneToOneRedundantEssentialTechnique(MinimizationStructure structure) {
		super(structure);
	}

	@Override
	public TestCase minimize() {
		Set<TestCase> tCases = getStructure().getTestCases();
		Set<TestCase> toBeRemoved = new HashSet<>();
		for(TestCase tc : tCases){
			for(TestCase tc2 : tCases){
				if(! tc.equals(tc2) && tc.containsAll(tc2)){
					toBeRemoved.add(tc2);
				}
			}
		}
		
		for(TestCase removed : toBeRemoved){
			getStructure().removeTuples(removed);
		}
		
		return super.minimize();
	}

}
