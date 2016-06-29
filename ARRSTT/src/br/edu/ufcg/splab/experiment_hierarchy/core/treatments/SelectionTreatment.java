package br.edu.ufcg.splab.experiment_hierarchy.core.treatments;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.ExecutableTreatment;
import br.edu.ufcg.splab.experiment_hierarchy.techniques.selection.InterfaceSelectionTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-08-19
 * 
 */
/**
 * <b>Objective:</b> This class represents an ARRSTT experiment's executable
 * treatment that is capable of selecting an amount of test cases in
 * a test suite, hence creating a new TestSuite with the selected test
 * cases.
 * <br>
 * <b>Description of use:</b> Receives a percentage, a test suite and a
 * selection algorithm to return a new test suite with the selected
 * test cases.
 *
 */
public class SelectionTreatment implements ExecutableTreatment {
	private InterfaceSelectionTechnique selectionObject;
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
	public SelectionTreatment(InterfaceSelectionTechnique selectionObject, TestSuite testSuite, Double percentage) {
		this.selectionObject = selectionObject;
		this.testSuite = testSuite;
		this.percentage = percentage;
	}

	@Override
	/**
	 * <b>Objective:</b> This method is responsible for using the selection
	 * algorithm, TestSuite and percentage to create a new TestSuite
	 * with the selected testCases.
	 * <br>
	 * <b>Exemple of use:</b> In a experiment that aims analyze TestSuite
	 * selection algorithms with the purpose of compairing them
	 * with respect of amount of defects found, this can be used
	 * to generate both algorithms' TestSuites to compare them.
	 * 
	 * @return The new TestSuite with the selected TestCases.
	 */
	public TestSuite execute() {
		return selectionObject.select(testSuite, percentage);
	}

	/**
	 * 
	 * @return The selection algorithm bound to the class.
	 */
	public InterfaceSelectionTechnique getSelector() {
		return selectionObject;
	}
	
	@Override
	public String toString() {
		return testSuite.toString();
	}
}