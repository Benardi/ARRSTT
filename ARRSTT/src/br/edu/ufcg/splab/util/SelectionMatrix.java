package br.edu.ufcg.splab.util;

public class SelectionMatrix {
	private double[][] innerMatrix;
	private int colAmount;
	private int rowAmount;
	
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
}
