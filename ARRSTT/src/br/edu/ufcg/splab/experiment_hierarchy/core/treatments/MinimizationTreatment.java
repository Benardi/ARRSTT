package br.edu.ufcg.splab.experiment_hierarchy.core.treatments;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations.techniques.InterfaceMinimizationTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

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
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
