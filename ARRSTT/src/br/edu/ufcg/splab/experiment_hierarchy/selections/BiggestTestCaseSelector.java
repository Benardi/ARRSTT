package br.edu.ufcg.splab.experiment_hierarchy.selections;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

/**
 * This class represents the selection of a test case using as parameter its
 * dimension.
 * 
 * @author JoséBenardi
 *
 */
public class BiggestTestCaseSelector implements InterfaceTestCaseSelector {

	public BiggestTestCaseSelector() {

	}

	/**
	 * 
	 * @param testSuite
	 *            the test suite whose section will be separated
	 * @param percentage
	 *            the percentage desired from the test suite
	 * @return how many will be chosen.
	 */
	private int getQuantity(TestSuite testSuite, double percentage) {
		return (int) Math.ceil(testSuite.size() * percentage);
	}

	@Override
	public TestSuite select(TestSuite testSuite, Double percentage) {
		TestSuite result = new TestSuite();
		int quantity = getQuantity(testSuite, percentage);
		for (int i = 0; i < quantity; i++) {
			addBiggestTestCase(result, testSuite);
		}
		return result;
	}

	/**
	 * 
	 * @param result
	 *            the test suite that hold the biggest test cases.
	 * 
	 * @param testSuite
	 *            the test suite from where the biggest will be chosen.
	 */
	private void addBiggestTestCase(TestSuite result, TestSuite testSuite) {
		int maxSize = 0;
		int maxIndex = -1;
		for (int i = 0; i < testSuite.size(); i++) {
			if (!result.contains(testSuite.get(i))) {
				if (testSuite.get(i).size() > maxSize) {
					maxSize = testSuite.get(i).size();
					maxIndex = i;
				}
			}
		}

		result.add(new TestCase(testSuite.get(maxIndex)));

	}

}