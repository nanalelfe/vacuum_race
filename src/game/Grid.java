package game;

/**
 * A representation of a grid.
 * @param <T> The type of the object on the grid.
 */
public interface Grid<T> {
	
	/**
	 * Sets the object item to the location mentioned by coordinates row
	 *  and column. 
	 * @param row The row location of the item being added.
	 * @param column The column location of the item being added.
	 * @param item The item being added to the grid. 
	 */
	void setCell(int row, int column, T item);
	
	/**
	 * Returns the item in the grid at position row and column. 
	 * @param row The row location of the item being returned.
	 * @param column The column location of the item being returned.
	 * @return the item at the row and column location.
	 */
	T getCell(int row, int column);
	
	/**
	 * Returns the number of rows that the grid has.
	 * @return the number of rows of the grid.
	 */
	int getNumRows();
	
	/**
	 * Returns the number of columns that the grid has.
	 * @return the number of columns of the grid.
	 */
	int getNumColumns();
	
	/**
	 * Overrides the equals method from Object. Returns true if and only if
	 * other is a Grid, and has the same number of rows and columns.
	 * @param other The item being compared to with this grid.
	 * @return true if this and other are the same, false otherwise.
	 */
	boolean equals(Object other);  
	
	/**
	 * Overrides the String method from Object. Returns a string 
	 * representation of the grid. 
	 * @return a string representation of the grid.
	 */
	String toString(); 
	
}
