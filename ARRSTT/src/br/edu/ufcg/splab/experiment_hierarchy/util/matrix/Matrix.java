package br.edu.ufcg.splab.experiment_hierarchy.util.matrix;

/**
 * This interface represents a matrix in which it is possible to find a
 * max position. *
 */
public interface Matrix {
	/**
	 * Set the element of a certain position.
	 * @param row
	 * 		The position's row.
	 * @param col
	 * 		The position's column.
	 * @param element
	 * 		The new element that will be in the position.
	 */
	public void setPos(int row, int col, double element);
	/**
	 * Get the element of a certain position.
	 * @param row
	 * 		The position's row
	 * @param col
	 * 		The position's column
	 * @return the element in the position
	 */
	public double get(int row, int col);
	/**
	 * 
	 * @return If the matrix is empty.
	 */
	public boolean isEmpty();
	/**
	 * 
	 * @return the amount of rows
	 */
	public int getRowAmount();
	/**
	 * 
	 * @return the amount of columns
	 */
	public int getColAmount();
	/**
	 * Makes all elements of a row invalid.
	 * @param row 
	 * 		The row to be invalidated.
	 */
	public void removeRow(int row);
	/**
	 * Makes all elements of a column invalid.
	 * @param col
	 * 		The column to be invalidated.
	 */
	public void removeCol(int col);
	/**
	 * Finds the position of the biggest element in the matrix.
	 * @return An array with two numbers. The first one will be the
	 * row index and the second one will be the column's index.
	 */
	public int[] findMaxPos();
}
