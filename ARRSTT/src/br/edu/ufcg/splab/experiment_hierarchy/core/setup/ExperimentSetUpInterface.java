package br.edu.ufcg.splab.experiment_hierarchy.core.setup;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;

public interface ExperimentSetUpInterface {
	public List<Tuple<ExecutableTreatment>> getIndependentVariables();
}
