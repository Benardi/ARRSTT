package br.edu.ufcg.splab.experiment_hierarchy.core.experiments;

import br.edu.ufcg.splab.experiment_hierarchy.core.runners.InterfaceRunner;
import br.edu.ufcg.splab.experiment_hierarchy.core.setups.InterfaceSetup;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-13
 * 
 */
/**
 * <b>Objective:</b> This class receives an experiment's setup and
 * runner to execute it.
 */
public class Experiment {
	private InterfaceSetup setup;
	private InterfaceRunner runner;
	
	/**
	 * Experiment's constructor.
	 * @param setup
	 * 			The experiment set up.
	 * @param runner
	 * 			The experiment runner.
	 */
	public Experiment(InterfaceSetup setup, InterfaceRunner runner) {
		this.setup = setup;
		this.runner = runner;
	}
	
	/**
	 * <b>Objective:</b> Get the set up and runner to execute
	 * the experiment.
	 * 
	 */
	public void execute() {
		runner.runExperiment(setup.getIndependentVariables());
	}
}
