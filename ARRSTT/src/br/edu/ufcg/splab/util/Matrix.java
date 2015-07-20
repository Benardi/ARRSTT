package br.edu.ufcg.splab.util;

public interface Matrix {
	public void setPos(int row, int col, double element);
	public double get(int row, int col);
	public boolean isEmpty();
	public int getRowAmount();
	public int getColAmount();
}
