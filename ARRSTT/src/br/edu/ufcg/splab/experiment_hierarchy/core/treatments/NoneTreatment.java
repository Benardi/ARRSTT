package br.edu.ufcg.splab.experiment_hierarchy.core.treatments;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class NoneTreatment implements ExecutableTreatment{
	private TestSuite ts;
	
	public NoneTreatment(TestSuite ts){
		this.ts = ts;
	}
	
	
	@Override
	public TestSuite execute() {
		return ts;
	}

	@Override
	public String getTitle() {
		return "None";
	}

}
