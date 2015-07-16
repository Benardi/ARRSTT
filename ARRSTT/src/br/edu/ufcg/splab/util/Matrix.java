package br.edu.ufcg.splab.util;

public class Matrix {
	private Integer[][] innerMatrix;
	private int colAmount;
	private int rowAmount;
	
	public Matrix(int colAmount, int rowAmount) {
		this.innerMatrix = new Integer[rowAmount][colAmount];
		this.colAmount = colAmount;
		this.rowAmount = rowAmount;
	}

	public void setPos(int row, int col, Integer element) {
		innerMatrix[row][col] = element;
	}

	public Integer get(int row, int col) {
		return innerMatrix[row][col];
	}

	public boolean isEmpty() {
		return (innerMatrix.length > 0) ? (false) : (true);
	}

	public void remove(int row, int col) {
		innerMatrix[row][col] = -1;
	}

	public int getRowAmount() {
		return rowAmount;
	}
	
	public int getColAmount() {
		return colAmount;
	}
}
