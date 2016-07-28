package br.edu.ufcg.splab.arrsttFramework;

import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.util.Artifact;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Iaron Araujo		2015-08-11
 * 
 */
/**
 * <b>Objective:</b> This interface represents an experiment set up
 * that is responsible for organizing the executable treatments
 * for execution.
 * <br>
 * <b>Description of use:</b> This is used in the Experiment class with
 * a runner so the experiment can be executed and the dependent
 * variables collected.
 */
public interface ISetup {
	/**
	 * <b>Objective:</b> Return the desired combinations of independent
	 * variables of a certain experiment.
	 * <br>
	 * <b>Example of use:</b> The list of tuples returned can be used
	 * by a Runner that is going to execute the experiment. This
	 * generally happens in the Experiment class.  
	 * 
	 * @return The list of ExecutableTreatment's tuple, that
	 * represents independent variables combinations.
	 */
	public List<Artifact> getArtifacts();
}
