package br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
/* Change		Author		Date
 * Creation		Wesley		2015-09-13
 */
/**
 * Objective: Used in the ARRSTT experiments, this class is responsible
 * for collecting the ExecutableTreatment's execution time.
 * 
 * Description of use: An ExecutableTreatment is passed to this class so
 * it can calculate and save it's execution time.
 * 
 * @author Wesley
 *
 */
public class ARRSTTTimeCollector implements DependentVariableCollector {

	@Override
	/**
	 * Objective: Calculate the ExecutableTreatment's execution time.
	 * 
	 * Example of use: In the ARRSTT Selection Experiment this method receives an ExecutableTreatment
	 * so it can calculate and save it's execution time in a StringBuffer.
	 * 
	 * @param treatment
	 * 			A tuple of ExecutableTreatments.
	 * @param content
	 * 			The StringBuffer used to store the ExecutableTreatments' execution time.
	 */
	public void collect(Tuple<ExecutableTreatment> treatment,
			StringBuffer content) {
		Long initTime = System.nanoTime();
		treatment.get(0).execute();
		Long endTime = System.nanoTime();
		
		content.append(endTime - initTime + "\t");
	}

}
