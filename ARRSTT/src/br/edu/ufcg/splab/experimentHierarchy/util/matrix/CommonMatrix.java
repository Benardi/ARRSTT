package br.edu.ufcg.splab.experimentHierarchy.util.matrix;


public class CommonMatrix implements Matrix {
	private double[][] innerMatrix;
	private int colAmount;
	private int rowAmount;
	
	public CommonMatrix(int colAmount, int rowAmount) {
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
}
