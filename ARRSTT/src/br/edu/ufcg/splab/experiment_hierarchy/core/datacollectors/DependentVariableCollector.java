package br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;

public interface DependentVariableCollector {
	public void collect(Tuple<ExecutableTreatment> treatment, StringBuffer content);
}
