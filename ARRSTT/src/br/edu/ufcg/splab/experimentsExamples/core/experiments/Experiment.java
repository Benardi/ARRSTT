package br.edu.ufcg.splab.experimentsExamples.core.experiments;

import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.IRunner;
import br.edu.ufcg.splab.arrsttFramework.ISetup;
import br.edu.ufcg.splab.arrsttFramework.util.ExperimentDataGroup;
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
	private ISetup setup;
	private IRunner runner;
	
	/**
	 * Experiment's constructor.
	 * @param setup
	 * 			The experiment set up.
	 * @param runner
	 * 			The experiment runner.
	 */
	public Experiment(ISetup setup, IRunner runner) {
		this.setup = setup;
		this.runner = runner;
	}
	
	/**
	 * <b>Objective:</b> Get the set up and runner to execute
	 * the experiment.
	 * 
	 */
	public List<ExperimentDataGroup> execute() {
		return runner.runExperiment(setup.getArtifacts());
	}
}
