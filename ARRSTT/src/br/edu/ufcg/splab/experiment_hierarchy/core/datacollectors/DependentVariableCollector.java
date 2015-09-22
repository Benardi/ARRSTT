package br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;

/* Change		Author		Date
 * Creation		Wesley		2015-09-13
 */
/**
 * Objective: This interface represents a dependent variable collector,
 * being responsible for the collecting an experiment's dependent variable
 * and saving it in a StringBuffer.
 * 
 * Description of use: It is used in an ExperimentRunner so it can collect
 * the experiment's dependent variable.
 * 
 * @author Wesley
 *
 */
public interface DependentVariableCollector {
	/**
	 * Objective: Add the dependent variable data collected from a tuple of
	 * ExecutableTreatments in a StringBuffer.
	 * 
	 * Example of use: In an experiment that is going to check if merge sort is
	 * quicker than bubble sort for a certain list, a Tuple of ExecutableTratment with
	 * the merge sort and the list can be passed to this method alongside with an empty
	 * StringBuffer so this method will write the execution time of the sort in the
	 * StringBuffer.
	 * 
	 * @param treatment
	 * 			A tuple of ExecutableTreatments that is going to have a dependent variable
	 * 			collected.
	 * @param content
	 * 			The StringBuffer used to store the dependent variable's data.
	 */
	public void collect(Tuple<ExecutableTreatment> treatment, StringBuffer content);
}
