package br.edu.ufcg.splab.experiment_hierarchy.minimizations.structures;

import java.util.HashSet;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;

public class MinimizationStructure {
	private Set<MinimizationTuple> tuples;
	
	public MinimizationStructure() {
		this.tuples = new HashSet<MinimizationTuple>();
	}
	
	public void insert(TestCase testCase, TestRequirement testRequirement) {
		MinimizationTuple tuple = new MinimizationTuple(testCase, testRequirement);
		tuples.add(tuple);
	}
	
	public Set<TestRequirement> getTestRequirements(TestCase testCase) {
		Set<TestRequirement> requirements = new HashSet<TestRequirement>();
		
		for (MinimizationTuple tuple : tuples) {
			if (tuple.getTestCase().equals(testCase)) {
				requirements.add(tuple.getTestRequirement());
			}
		}
		
		return requirements;
	}
	
	public Set<TestRequirement> getTestRequirements() {
		Set<TestRequirement> requirements = new HashSet<TestRequirement>();
		
		for (MinimizationTuple tuple : tuples) {
			requirements.add(tuple.getTestRequirement());
		}
		
		return requirements;
	}
	
	public Set<TestCase> getTestCases() {
		Set<TestCase> testCases = new HashSet<TestCase>();
		
		for (MinimizationTuple tuple : tuples) {
			testCases.add(tuple.getTestCase());
		}
		
		return testCases;
	}
	
	public Set<TestCase> getTestCases(TestRequirement testRequirement) {
		Set<TestCase> testCases = new HashSet<TestCase>();
		
		for (MinimizationTuple tuple : tuples) {
			if (tuple.getTestRequirement().equals(testRequirement)) {
				testCases.add(tuple.getTestCase());
			}
		}
		
		return testCases;
	}
	
	public void removeTuples(TestCase testCase) {
		Set<MinimizationTuple> tuplesToRemove = new HashSet<MinimizationTuple>();
		
		for (MinimizationTuple tuple : tuples) {
			if (tuple.getTestCase().equals(testCase)) {
				tuplesToRemove.add(tuple);
			}
		}
		
		tuples.removeAll(tuplesToRemove);
	}
	
	public void removeTuples(TestRequirement testRequirement) {
		Set<MinimizationTuple> tuplesToRemove = new HashSet<MinimizationTuple>();
		
		for (MinimizationTuple tuple : tuples) {
			if (tuple.getTestRequirement().equals(testRequirement)) {
				tuplesToRemove.add(tuple);
			}
		}
		
		tuples.removeAll(tuplesToRemove);
	}
	
	public void removeAllTuples(Set<TestRequirement> reqs){
		for(TestRequirement req: reqs){
			removeTuples(req);
		}
	}
	
	public boolean isEmpty() {
		return tuples.isEmpty();
	}
}
