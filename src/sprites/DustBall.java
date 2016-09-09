package sprites;

/**
 * A representation of a dust ball for the vacuum game.
 */
public class DustBall extends Dirt implements Moveable {

	/**
	 * Creates a new dust ball with a symbol, a location and a value. 
	 * @param symbol The symbol representing the dust ball.
	 * @param row  The row location of the dust ball.
	 * @param column The column location of the dust ball.
	 * @param value The value of the dust ball.
	 */
	public DustBall(char symbol, int row, int column, int value) {
		super(symbol, row, column, value);
	}

	/* (non-Javadoc)
	 * @see sprites.Moveable#moveTo(int, int)
	 */
	@Override
	public void moveTo(int row, int column) {
		this.row = row;
		this.column = column;

	}
	
}


