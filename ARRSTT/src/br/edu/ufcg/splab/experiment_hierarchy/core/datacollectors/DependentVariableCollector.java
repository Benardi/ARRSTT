package br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;

public interface DependentVariableCollector {
	public void collect(ExecutableTreatment treatment);
}
