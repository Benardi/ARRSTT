package br.edu.ufcg.splab.experiment_hierarchy.core.experiments;

import br.edu.ufcg.splab.experiment_hierarchy.core.runners.InterfaceRunner;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.InterfaceSetup;

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
