package br.edu.ufcg.splab.experiment.core.treatments;

import br.edu.ufcg.splab.util.TestSuite;

public interface ExecutableTreatment {
	public TestSuite execute();
	public String getTitle();
}
