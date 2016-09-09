package sprites;

/**
 * A blueprint for a moveable object. 
 */
public interface Moveable {
	
	/**
	 * Moves the moveable object to the location specified by the row and
	 * column.
	 * @param row  the row to which the moveable object should be moved.
	 * @param column  the column to which the moveable object should be moved.
	 */
	void moveTo(int row, int column);

}
