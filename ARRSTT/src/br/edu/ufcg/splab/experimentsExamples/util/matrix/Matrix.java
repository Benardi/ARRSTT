package br.edu.ufcg.splab.experimentsExamples.util.matrix;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-08-17
 * 
 */
/**
/**
 * <b>Objective:</b> This interface represents a matrix in which it is possible
 * to find a max position.<br>
 * <br>
 * <b>Description of use:</b> the Similarity Structure implments this interface.
 *
 */
public interface Matrix {

	/**
	 * <b>Objective:</b> Set the element of a certain position. <br>
	 * 
	 * <b>Example of use:</b> This method is used to manually change the matrix.
	 * 
	 * @param row
	 *            The position's row.
	 * @param col
	 *            The position's column.
	 * @param element
	 *            The new element that will be in the position.
	 */
	public void setPos(int row, int col, double element);

	/**
	 * <b>Objective:</b> Get the element of a certain position. <br>
	 * 
	 * <b>Example of use:</b> This method is used to give access to an element
	 * of the matrix.
	 * 
	 * @param row
	 *            The position's row
	 * @param col
	 *            The position's column
	 * @return the element in the position
	 */
	public double get(int row, int col);

	/**
	 * <b>Objective:</b> Inform whether the matrix is empty or not. <br>
	 * 
	 * <b>Example of use:</b> This method is used to verify if the matrix when
	 * initialized is truly empty.
	 * 
	 * @return If the matrix is empty.
	 */
	public boolean isEmpty();

	/**
	 * <b>Objective:</b> Calculate how many rows are in the matrix. <br>
	 * 
	 * <b>Example of use:</b> This method is used to help the navigation through
	 * the matrix.
	 * 
	 * @return the amount of rows
	 */
	public int getRowAmount();

	/**
	 * <b>Objective:</b> Calculate how many columns are in the matrix. <br>
	 * 
	 * <b>Example of use:</b> This method is used to help the navigation through
	 * the matrix.
	 * 
	 * @return the amount of columns
	 */
	public int getColAmount();

	/**
	 * <b>Objective:</b> Makes all elements of a row invalid. <br>
	 * 
	 * <b>Example of use:</b> This method is used to help eliminate the elements
	 * that are not priorities.
	 * 
	 * @param row
	 *            The row to be invalidated.
	 */
	public void removeRow(int row);

	/**
	 * <b>Objective:</b> Makes all elements of a column invalid. <br>
	 * 
	 * <b>Example of use:</b> This method is used to help eliminate the elements
	 * that are not priorities.
	 * 
	 * @param col
	 *            The column to be invalidated.
	 */
	public void removeCol(int col);

	/**
	 * <b>Objective:</b> Finds the position of the biggest element in the
	 * matrix. <br>
	 * 
	 * <b>Example of use:</b> This method is used to help prioritize the
	 * selection through the matrix.
	 * 
	 * @return An array with two numbers. The first one will be the row index
	 *         and the second one will be the column's index.
	 */
	public int[] findMaxPos();
}
