package br.edu.ufcg.splab.experiment_hierarchy.core.treatments;

import br.edu.ufcg.splab.experiment_hierarchy.selections.InterfaceTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

/**
 * Class that represents the use of a selection technique to choose a percentage
 * of a test suite.
 * 
 * @author JoséBenardi
 *
 */
public class SelectionTreatment implements ExecutableTreatment {
	private InterfaceTestCaseSelector selectionObject;
	private TestSuite testSuite;
	private Double percentage;

	/**
	 * 
	 * @param selectionObject
	 *            The selection technique.
	 * @param testSuite
	 *            The original test suite from whom the percentage shall be
	 *            chosen.
	 * @param percentage
	 *            The section of the test suite chosen.
	 */
	public SelectionTreatment(InterfaceTestCaseSelector selectionObject, TestSuite testSuite, Double percentage) {
		this.selectionObject = selectionObject;
		this.testSuite = testSuite;
		this.percentage = percentage;
	}

	@Override
	public TestSuite execute() {
		return selectionObject.select(testSuite, percentage);
	}

	@Override
	public String getTitle() {
		return "Selection";
	}

	/**
	 * 
	 * @return The selection technique bound to the class.
	 */
	public InterfaceTestCaseSelector getSelector() {
		return selectionObject;
	}
}