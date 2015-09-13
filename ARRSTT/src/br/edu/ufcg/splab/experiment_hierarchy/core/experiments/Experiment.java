package br.edu.ufcg.splab.experiment_hierarchy.core.experiments;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.ExperimentSetUpInterface;
import br.edu.ufcg.splab.experiment_hierarchy.core.runners.Runnable;

public class Experiment {
	private ExperimentSetUpInterface setup;
	private Runnable runner;
	
	public Experiment(ExperimentSetUpInterface setup, Runnable runner) {
		this.setup = setup;
		this.runner = runner;
	}
	
	public void execute() {
		runner.runExperiment(setup.getIndependentVariables());
	}
}
