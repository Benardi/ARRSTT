package br.edu.ufcg.splab.experiment_hierarchy.util.matrix;

public interface Matrix {
	public void setPos(int row, int col, double element);
	public double get(int row, int col);
	public boolean isEmpty();
	public int getRowAmount();
	public int getColAmount();
	public void removeRow(int row);
	public void removeCol(int col);
	public int[] findMaxPos();
}
