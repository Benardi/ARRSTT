package br.edu.ufcg.splab.experimentHierarchy.core.treatments;

import br.edu.ufcg.splab.experimentHierarchy.util.testcollections.TestSuite;

/**
 * Represents a treatment that is able to process data. 
 * More specifically, executable treatments are going to
 * use given data to generate or manipulate a test suite.
 *
 */
public interface ExecutableTreatment {
	/**
	 * This method process data.
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
	public String getTitle();
}
