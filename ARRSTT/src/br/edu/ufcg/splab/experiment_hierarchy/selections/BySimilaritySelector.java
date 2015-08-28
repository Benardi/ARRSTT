package br.edu.ufcg.splab.experiment_hierarchy.selections;

import java.util.Random;

import br.edu.ufcg.splab.experiment_hierarchy.util.matrix.Matrix;
import br.edu.ufcg.splab.experiment_hierarchy.util.matrix.SimilarityStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

/**
 * 
 * This class represents a selector guided by the principle of similarity.
 *
 */
public class BySimilaritySelector implements InterfaceTestCaseSelector {
	private Matrix matrix;

	public BySimilaritySelector() {

	}

	public TestSuite select(TestSuite testSuite, Double percentage) {
		matrix = new SimilarityStructure(testSuite);
		int selectingAmount = (int) Math.ceil(testSuite.size() * percentage);
		int limitIterations = testSuite.size() - selectingAmount;
		TestSuite selectedTS = new TestSuite(testSuite);

		for (int i = 0; i < limitIterations; i++) {
			int removingPosition = chooseRemoval(testSuite);
			removeFromMatrix(removingPosition);
			selectedTS.nulify(removingPosition);
		}

		cleanTestSuite(selectedTS);
		return selectedTS;
	}

	private int chooseRemoval(TestSuite testSuite) {
		int[] maxPos = matrix.findMaxPos();

		if (testSuite.get(maxPos[0]).size() < testSuite.get(maxPos[1]).size()) {
			return maxPos[0];
		} else if (testSuite.get(maxPos[1]).size() < testSuite.get(maxPos[0])
				.size()) {
			return maxPos[1];
		} else {
			Random randomGenerator = new Random();
			return maxPos[randomGenerator.nextInt(2)];
		}
	}

	private void removeFromMatrix(int pos) {
		matrix.removeCol(pos);
		matrix.removeRow(pos);
	}

	private void cleanTestSuite(TestSuite selectedTS) {
		for (int i = selectedTS.size() - 1; i >= 0; i--)
			if (selectedTS.get(i) == null)
				selectedTS.remove(i);
	}
}