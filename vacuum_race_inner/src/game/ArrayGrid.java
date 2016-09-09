package game;


/**
 * Array implementation of the Grid interface. 
 * @param <T> The type of the object on the array grid. 
 */
public class ArrayGrid<T> implements Grid<T> {
	
	private int numRows;
	private int numColumns;
	private T [][] arrayGrid;
	
	
	/**
	 * Creates a new array grid with a number of rows and columns. 
	 * @param numRows The number of rows in the array grid.
	 * @param numColumns The number of columns in the array grid.
	 */
	@SuppressWarnings("unchecked")
	public ArrayGrid(int numRows, int numColumns){
		this.numRows = numRows;
		this.numColumns = numColumns;
		this.arrayGrid =  (T[][]) new Object[numRows][numColumns];
	} 

	/* (non-Javadoc)
	 * @see game.Grid#setCell(int, int, java.lang.Object)
	 */
	@Override
	public void setCell(int row, int column, T item) {
		this.arrayGrid[row][column] = item;
	}
	
	/* (non-Javadoc)
	 * @see game.Grid#getCell(int, int)
	 */
	@Override
	public T getCell(int row, int column) {
		return (T)arrayGrid[row][column];
	}
	
	/* (non-Javadoc)
	 * @see game.Grid#getNumRows()
	 */
	@Override
	public int getNumRows() {
		return this.numRows;
	}
	
	/* (non-Javadoc)
	 * @see game.Grid#getNumColumns()
	 */
	@Override
	public int getNumColumns() {
		return this.numColumns;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other){
		return ((other instanceof ArrayGrid) 
				&& (this.getNumRows() == ((ArrayGrid<T>) other).getNumRows())
			&& (this.getNumColumns() == ((ArrayGrid<T>)other).getNumColumns())
				&& (this.toString() == ((ArrayGrid<T>)other).toString()));
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		String result = "";
		for(int i = 0; i < this.numRows; i++){
			for(int j = 0; j < this.numColumns; j++){
				result += this.arrayGrid[i][j].toString();			
			}
			result += "\n";
		}
		return result;
	}
	
}
