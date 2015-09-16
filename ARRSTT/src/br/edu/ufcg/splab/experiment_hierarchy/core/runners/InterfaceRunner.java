package br.edu.ufcg.splab.experiment_hierarchy.core.runners;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;

public interface InterfaceRunner {
	public void runExperiment(List<Tuple<ExecutableTreatment>> combinations);
}
