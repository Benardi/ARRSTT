package br.edu.ufcg.splab.experiment_hierarchy.core.treatments;

import br.edu.ufcg.splab.experiment_hierarchy.selections.InterfaceTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
/* Change		Author		Date
 * Creation		Unknown		Unknown
 */
/**
 * Objective: This class represents an ARRSTT experiment's executable
 * treatment that is capable of selecting an amount of test cases in
 * a test suite, hence creating a new TestSuite with the selected test
 * cases.
 * 
 * Description of use: Receives a percentage, a test suite and a
 * selection algorithm to return a new test suite with the selected
 * test cases.
 *
 */
public class SelectionTreatment implements ExecutableTreatment {
	private InterfaceTestCaseSelector selectionObject;
	private TestSuite testSuite;
	private Double percentage;

	/**
	 * 
	 * @param selectionObject
	 *            The selection algorithm.
	 * @param testSuite
	 *            The original test suite from which the percentage will be
	 *            chosen.
	 * @param percentage
	 *            The percentage that represents the section of the test
	 *            suite that will be chosen.
	 */
	public SelectionTreatment(InterfaceTestCaseSelector selectionObject, TestSuite testSuite, Double percentage) {
		this.selectionObject = selectionObject;
		this.testSuite = testSuite;
		this.percentage = percentage;
	}

	@Override
	/**
	 * Objective: This method is responsible for using the selection
	 * algorithm, TestSuite and percentage to create a new TestSuite
	 * with the selected testCases.
	 * 
	 * Exemple of use: In a experiment that aims analyze TestSuite
	 * selection algorithms with the purpose of compairing them
	 * with respect of amount of defects found, this can be used
	 * to generate both algorithms' TestSuites to compare them.
	 * 
	 * @return The new TestSuite with the selected TestCases.
	 */
	public TestSuite execute() {
		return selectionObject.select(testSuite, percentage);
	}

	@Override
	public String getTitle() {
		return "Selection";
	}

	/**
	 * 
	 * @return The selection algorithm bound to the class.
	 */
	public InterfaceTestCaseSelector getSelector() {
		return selectionObject;
	}
}