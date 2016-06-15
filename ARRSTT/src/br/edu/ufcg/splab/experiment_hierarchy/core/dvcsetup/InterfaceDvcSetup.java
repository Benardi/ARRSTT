package br.edu.ufcg.splab.experiment_hierarchy.core.dvcsetup;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;

public interface InterfaceDvcSetup {
	public List<List<DependentVariableCollector>> getDVCs();
}
