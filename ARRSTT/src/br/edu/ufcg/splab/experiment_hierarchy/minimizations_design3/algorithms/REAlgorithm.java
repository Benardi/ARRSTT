package br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.algorithms;

import java.util.HashSet;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.MinimizationAlgorithmFactory;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations_design3.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;

public class REAlgorithm implements InterfaceMinimizationAlgorithm {
	
	@Override
	public TestCase execute(MinimizationStructure structure) {
		Set<TestCase> tCases = structure.getTestCases();
		Set<TestCase> toBeRemoved = new HashSet<>();
		
		for(TestCase tc : tCases){
			for(TestCase tc2 : tCases){
				if(! tc.equals(tc2) && tc.containsAll(tc2)){
					toBeRemoved.add(tc2);
				}
			}
		}
		
		for(TestCase removed : toBeRemoved) {
			structure.removeTuples(removed);
		}
		
		MinimizationAlgorithmFactory factory = new MinimizationAlgorithmFactory();
		return factory.createEssentialAlgorithm().execute(structure);
	}
}