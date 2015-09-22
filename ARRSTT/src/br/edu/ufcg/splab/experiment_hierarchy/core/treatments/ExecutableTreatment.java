package br.edu.ufcg.splab.experiment_hierarchy.core.treatments;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
/* Change		Author		Date
 * Creation		Unknown		Unknown
 */
/**
 * Objective: Represents a treatment that is able to process data. 
 * More specifically, executable treatments are going to use given
 * data to generate or manipulate a test suite.
 * 
 * Description of use: Used to process data that will make it possible
 * to collect the dependent variables.
 *
 */
public interface ExecutableTreatment {
	/**
	 * Objective: This method process data returning a TestSuite
	 * to reflect this data.
	 * 
	 * Exemple of use: In the ARRSTT Selection Experiment, this method is
	 * responsible for the generation of defective TestSuites.
	 * 
	 * @return
	 * 		The output test suite.
	 */
	public TestSuite execute();
	/**
	 * The title is the String that is shown in the output
	 * table about.
	 * 
	 * @return
	 *		The title of a treatment.
	 */
	@Deprecated
	public String getTitle();
}
