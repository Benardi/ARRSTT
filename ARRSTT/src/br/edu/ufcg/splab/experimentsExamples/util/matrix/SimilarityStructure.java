package br.edu.ufcg.splab.experimentsExamples.util.matrix;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.experimentsExamples.util.SimilarityCalculator;


/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-08-21
 * 
 */
/**
 * <b>Objective:</b> This class represents the structure needed for the test
 * case selection based on similarity technique.<br>
 * <br>
 * <b>Description of use:</b> In the By Similarity Selector the similarity
 * structure is used to prioritize the process of removal.
 *
 */
public class SimilarityStructure implements Matrix {
	/**
	 * The list of lists that represents this structure.
	 */
	private List<List<Double>> belowDiagonalStructure;
	/**
	 * An object that calculates the similarity between two test cases.
	 */
	private SimilarityCalculator similarityCalculator;

	/**
	 * <b>Objective:</b> Enable the construction of and object from this class. <br>
	 * <br>
	 * 
	 * <b>Description of use:</b> This constructor is used to create a new
	 * object from this class and initialize it by filling the structure with -1
	 * in every position.
	 * 
	 * @param testSuite
	 *            The test suite to have it's test cases' similarity analyzed.
	 */
	public SimilarityStructure(TestSuite testSuite) {
		this.similarityCalculator = new SimilarityCalculator();
		initializeList(testSuite);
		fillbelowDiagonal(testSuite);
	}

	/**
	 * <b>Objective:</b> Initialize the matrix in the convenient format to the
	 * selection. <br>
	 * 
	 * <b>Example of use:</b> This method is used to make the position in the
	 * matrix that will be manipulated through the selection capable of being
	 * used.
	 * 
	 * @param testSuite
	 *            the test suite in which the selection will be made.
	 */
	private void initializeList(TestSuite testSuite) {
		belowDiagonalStructure = new ArrayList<List<Double>>();
		for (int i = 0; i < testSuite.size(); i++) {
			belowDiagonalStructure.add(new ArrayList<Double>());
		}
	}

	/**
	 * <b>Objective:</b> Fills the matrix in the convenient format to the
	 * selection. <br>
	 * 
	 * <b>Example of use:</b> This method is used to fill the positions in the
	 * matrix that will be manipulated.
	 * 
	 * @param ts
	 *            the test suite in which the selection will be made.
	 */
	private void fillbelowDiagonal(TestSuite ts) {
		for (int i = 0; i < ts.size(); i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j) {
					belowDiagonalStructure.get(i).add(-1.0);
				} else {
					Double similarity = new Double(
							similarityCalculator.getSimilarity(ts.get(i),
									ts.get(j)));
					belowDiagonalStructure.get(i).add(similarity);
				}
			}
		}
	}

	public void setPos(int i, int j, double element) {
		belowDiagonalStructure.get(i).set(j, element);
	}

	public double get(int row, int col) {
		return belowDiagonalStructure.get(row).get(col);
	}

	public boolean isEmpty() {
		for (List<Double> list : belowDiagonalStructure) {
			if (!list.isEmpty())
				return false;
		}

		return true;
	}

	public int getRowAmount() {
		return belowDiagonalStructure.size();
	}

	public int getColAmount() {
		return belowDiagonalStructure.size();
	}

	public void removeRow(int row) {
		for (int i = 0; i < belowDiagonalStructure.get(row).size(); i++) {
			belowDiagonalStructure.get(row).set(i, -1.0);
		}
	}

	public void removeCol(int col) {
		for (int i = col + 1; i < getColAmount(); i++) {
			belowDiagonalStructure.get(i).set(col, -1.0);
		}
	}

	public int[] findMaxPos() {
		Double max = -1.0;
		int[] maxPos = new int[2];

		for (int i = 0; i < belowDiagonalStructure.size(); i++) {
			for (int j = 0; j <= i; j++) {
				if (max <= belowDiagonalStructure.get(i).get(j)) {
					maxPos[0] = i;
					maxPos[1] = j;
					max = belowDiagonalStructure.get(i).get(j);
				}
			}
		}

		return maxPos;
	}

}
