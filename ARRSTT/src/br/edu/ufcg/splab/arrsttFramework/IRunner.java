package br.edu.ufcg.splab.arrsttFramework;

import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.util.Artifact;
import br.edu.ufcg.splab.arrsttFramework.util.ExperimentDataGroup;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-13
 * 
 */
/**
 * <b>Objective:</b> This interface represents a runner that
 * is responsible for getting a list of ExecutableTreatment's
 * tuple and execute them, collecting the experiment's dependent
 * variables while doing so.
 * <br>
 * <b>Description of use:</b> This is used in the Experiment class, so it
 * can get a SetUp's combinations.
 *
 */
public interface IRunner {
	/**
	 * <b>Objective:</b> this method is responsible for getting a 
	 * list of ExecutableTreatment's tuple and execute them,
	 * collecting the experiment's dependent variables while
	 * doing so.
	 * <br>
	 * <b>Exemple of use:</b> Used in the Experiment's method to execute
	 * the experiment.
	 * @param combinations
	 * 			The combinations generated by a set up.
	 */
	public List<ExperimentDataGroup> runExperiment(List<Artifact> artifacts);
}