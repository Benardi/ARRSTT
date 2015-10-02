package br.edu.ufcg.splab.experiment_hierarchy.selections;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Iaron Araujo		2015-08-15
 * 
 */
/**
 * Objective: This interface represents what a selector should be capable of
 * doing.
 * 
 * Description of use: Every and each selector of this working set implements
 * this interface and can be declared as one.
 *
 */
public interface InterfaceTestCaseSelector {
	/**
	 * Objective: Generate a smaller test suite from the test cases selected
	 * from a previous through some method.
	 * 
	 * Description of use: If a test suite is selected through the biggest case
	 * selector with 0.5 percentage, half of the previous test suite will be in
	 * the new one and this new one will be filled by the biggest test case from
	 * the other.
	 * 
	 * @param testSuite
	 *            the original test suite
	 * @param percentage
	 *            the percentage that shall be separated
	 * @return the sub test suite desired.
	 */
	public TestSuite select(TestSuite testSuite, Double percentage);
}
