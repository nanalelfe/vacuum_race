package sprites;

/**
 * A representation of a wall in the vacuum game.
 */
public class Wall extends Sprite {

	/**
	 * Creates a new wall with a symbol and a location.
	 * @param symbol The symbol that represents the wall.
	 * @param row The row location of the wall.
	 * @param column The column location of the wall.
	 */
	public Wall(char symbol, int row, int column) {
		super(symbol, row, column);
	}
	

}
