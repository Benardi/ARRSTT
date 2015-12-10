package br.edu.ufcg.splab.experiment_hierarchy.core.benchmarking;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-13
 * 
 */
/**
 * <b>Objective:</b> Used in the ARRSTT experiments, this class is responsible
 * for collecting the ExecutableTreatment's execution time.
 * <br>
 * <b>Description of use</b>: An ExecutableTreatment is passed to this class so
 * it can calculate and save it's execution time.
 * 
 * @author Wesley
 *
 */
public class ARRSTTTimeCollector implements DependentVariableCollector {

	@Override
	/**
	 * <b>Objective:</b> Calculate the ExecutableTreatment's execution time.
	 * <br>
	 * <b>Example of use</b>: In the ARRSTT Selection Experiment this method receives an ExecutableTreatment
	 * so it can calculate and save it's execution time in a StringBuffer that will be returned.
	 * 
	 * @param treatment
	 * 			A tuple of ExecutableTreatments.
	 * @param The StringBuffer used to store the ExecutableTreatments' execution time.
	 */
	public StringBuffer collect(TestSuite testSuite) {
		Long initTime = System.nanoTime();
		treatment.get(0).execute();
		Long endTime = System.nanoTime();
		
		return new StringBuffer(endTime - initTime + "");
	}

	@Override
	public String toString() {
		return "DV Time";
	}
}