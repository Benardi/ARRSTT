package br.edu.ufcg.splab.util;

public class Matrix {
	private Double[][] innerMatrix;
	private int colAmount;
	private int rowAmount;
	
	public Matrix(int colAmount, int rowAmount) {
		this.innerMatrix = new Double[rowAmount][colAmount];
		this.colAmount = colAmount;
		this.rowAmount = rowAmount;
	}

	public void setPos(int row, int col, Double element) {
		innerMatrix[row][col] = element;
	}

	public Double get(int row, int col) {
		return innerMatrix[row][col];
	}

	public boolean isEmpty() {
		return (innerMatrix.length > 0) ? (false) : (true);
	}

	public void remove(int row, int col) {
		innerMatrix[row][col] = new Double(-1);
	}

	public int getRowAmount() {
		return rowAmount;
	}
	
	public int getColAmount() {
		return colAmount;
	}
}
