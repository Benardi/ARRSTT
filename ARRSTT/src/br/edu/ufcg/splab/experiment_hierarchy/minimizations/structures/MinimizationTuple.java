package br.edu.ufcg.splab.experiment_hierarchy.minimizations.structures;


import br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;

public class MinimizationTuple {
	private TestCase testCase;
	private TestRequirement testRequirement;
	
	public MinimizationTuple(TestCase testCase, TestRequirement testRequirement) {
		this.testCase = testCase;
		this.testRequirement = testRequirement;
	}

	public TestCase getTestCase() {
		return testCase;
	}

	public TestRequirement getTestRequirement() {
		return testRequirement;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof MinimizationTuple)) return false;
		
		MinimizationTuple sentinelTuple = (MinimizationTuple) obj;
		
		boolean isTestCaseEqual = this.getTestCase().equals(sentinelTuple.getTestCase());
		boolean isTestRequirementEqual = this.getTestRequirement().equals(sentinelTuple.getTestRequirement());
		
		return isTestCaseEqual && isTestRequirementEqual;
	}
}
