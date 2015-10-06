package br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors;

import br.edu.ufcg.splab.experiment_hierarchy.core.treatments.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.util.Tuple;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.DVCType;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-13
 * 
 */
/**
 * <b>Objective:</b> Used in the ARRSTT experiments, this class is responsible
 * for collecting the size of the TestSuite generated by the
 * ExecutableTreatment.
 * <br>
 * <b>Description of use</b>: An ExecutableTreatment is passed to this class so
 * it can calculate and save the TestSuite's size generated by the treatment.
 * 
 * @author Wesley
 *
 */
public class ARRSTTSizeCollector implements DependentVariableCollector {

	@Override
	/**
	 * <b>Objective:</b> Calculate the size of the TestSuite generated by the
	 * Executable treatment in the tuple and add it in a StringBuffer.
	 * <br>
	 * <b>Example of use</b>: In the ARRSTT Selection Experiment this method receives an ExecutableTreatment
	 * so it can generate TestSuites and save it's sizes in a StringBuffer that will be returned.
	 * 
	 * @param treatment
	 * 			A tuple of ExecutableTreatments that is going to generate a TestSuite.
	 * @param The StringBuffer used to store the TestSuites' size.
	 */
	public StringBuffer collect(Tuple<ExecutableTreatment> treatment) {
		TestSuite testSuite = treatment.get(0).execute();		
		return new StringBuffer(testSuite.size() + "");
	}

	@Override
	public String toString() {
		return "DV Size";
	}
}
