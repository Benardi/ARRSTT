package br.edu.ufcg.splab.framework.core.treatments;

import br.edu.ufcg.splab.framework.core.api.ExecutableTreatment;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

public class NoneTreatment implements ExecutableTreatment{
	private TestSuite ts;
	
	public NoneTreatment(TestSuite ts){
		this.ts = ts;
	}
	
	
	@Override
	public TestSuite execute() {
		return ts;
	}

}
