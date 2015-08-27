package br.edu.ufcg.splab.trash;

import br.edu.ufcg.splab.experiment_hierarchy.util.matrix.Matrix;

/**
 * This class matrix to represent the structure needed for the testcase
 * selection based on similarity technique.
 */
public class SelectionMatrix implements Matrix {
	/**
	 * The inner matrix.
	 */
	private double[][] innerMatrix;
	/**
	 * The amount of columns.
	 */
	private int colAmount;
	/**
	 * The amount of rows.
	 */
	private int rowAmount;

	/**
	 * Constructor of the class.
	 * 
	 * @param colAmount
	 *            The amount of columns the matrix will have.
	 * @param rowAmount
	 *            The amount of rows the matrix will have.
	 */
	public SelectionMatrix(int colAmount, int rowAmount) {
		this.innerMatrix = new double[rowAmount][colAmount];
		this.colAmount = colAmount;
		this.rowAmount = rowAmount;
	}

	public void setPos(int row, int col, double element) {
		innerMatrix[row][col] = element;
	}

	public double get(int row, int col) {
		return innerMatrix[row][col];
	}

	public boolean isEmpty() {
		return (innerMatrix.length > 0) ? (false) : (true);
	}

	public int getRowAmount() {
		return rowAmount;
	}

	public int getColAmount() {
		return colAmount;
	}

	public void removeCol(int col) {
		for (int i = 0; i < innerMatrix.length; i++)
			innerMatrix[i][col] = -1;
	}

	public void removeRow(int row) {
		for (int i = 0; i < innerMatrix[row].length; i++)
			innerMatrix[row][i] = -1;
	}

	@Override
	public int[] findMaxPos() {
		double maxValue = this.get(0, 0);
		int[] maxPos = { 0, 0 };
		for (int row = 0; row < getRowAmount(); row++) {
			for (int col = 0; col < getColAmount(); col++) {
				if (maxValue < get(row, col)) {
					maxValue = get(row, col);
					maxPos[0] = row;
					maxPos[1] = col;

				}

			}
		}
		return maxPos;
	}
}
