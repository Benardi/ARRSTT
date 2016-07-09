package br.edu.ufcg.splab.framework.core.treatments;

import br.edu.ufcg.splab.framework.core.api.ExecutableTreatment;
import br.edu.ufcg.splab.framework.techniques.minimization.techniques.InterfaceMinimizationTechnique;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

public class MinimizationTreatment implements ExecutableTreatment {
	private InterfaceMinimizationTechnique technique;
	
	public MinimizationTreatment(InterfaceMinimizationTechnique technique) {
		this.technique = technique;
	}

	@Override
	public TestSuite execute() {
		return technique.minimize();
	}
	
	@Override
	public String toString() {
		return technique.toString();
	}
}