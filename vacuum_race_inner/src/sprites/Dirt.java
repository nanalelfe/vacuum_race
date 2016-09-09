package sprites;

/**
 * A representation of dirt for the vacuum game.
 */
public class Dirt extends Sprite {
	
	/**
	 *  The value of cleaning the dirt. 
	 */
	protected int value;

	/**
	 * Creates a new dirt with a symbol representing it, a location and a value.
	 * @param symbol The symbol that represents the dirt.
	 * @param row The row location of the dirt.
	 * @param column The column location of the dirt.
	 * @param value The value of the dirt.
	 */
	public Dirt(char symbol, int row, int column, int value) {
		super(symbol, row, column);
		this.value = value;
		
	}

	/**
	 * Returns the value of the dirt.
	 * @return value of the dirt.
	 */
	public int getValue(){
		return this.value;
	}	
}
