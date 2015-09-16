package br.edu.ufcg.splab.experiment_hierarchy.core.experiments;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.InterfaceSetup;
import br.edu.ufcg.splab.experiment_hierarchy.core.runners.InterfaceRunner;

public class Experiment {
	private InterfaceSetup setup;
	private InterfaceRunner runner;
	
	public Experiment(InterfaceSetup setup, InterfaceRunner runner) {
		this.setup = setup;
		this.runner = runner;
	}
	
	public void execute() {
		runner.runExperiment(setup.getIndependentVariables());
	}
}
