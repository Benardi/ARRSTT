package br.edu.ufcg.splab.experiment_hierarchy.selections;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

/**
 * This interface represents what a selector should be capable of doing.
 * 
 * @author JoséBenardi
 *
 */
public interface InterfaceTestCaseSelector {
	/**
	 * 
	 * @param testSuite
	 *            the original test suite
	 * @param percentage
	 *            the percentage that shall be separated
	 * @return the sub test suite desired.
	 */
	public TestSuite select(TestSuite testSuite, Double percentage);
}
