package br.edu.ufcg.splab.experiment_hierarchy.core.setups;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
/* Change		Author		Date
 * Creation		Iaron		2015-08-11
 */
/**
 * Objective: This interface represents an experiment set up
 * that is responsible for organizing the executable treatments
 * for execution.
 * 
 * Description of use: This is used in the Experiment class with
 * a runner so the experiment can be executed and the dependent
 * variables collected.
 */
public interface InterfaceSetup {
	/**
	 * Objective: Return the desired combinations of independent
	 * variables of a certain experiment.
	 * 
	 * Exemple of use: The list of tuples returned can be used
	 * by a Runner that is going to execute the experiment. This
	 * generally happens in the Experiment class.  
	 * 
	 * @return The list of ExecutableTreatment's tuple, that
	 * represents independent variables combinations.
	 */
	public List<Tuple<ExecutableTreatment>> getIndependentVariables();
}
