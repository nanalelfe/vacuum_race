package sprites;


/**
 * A representation of a Sprite for a vacuum game.
 */
public abstract class Sprite {
	
	/**
	 * The symbol representing the sprite. 
	 */
	protected char symbol;
	
	/**
	 * The row in which the sprite is located.
	 */
	protected int row;
	
	/**
	 * The column in which the sprite is located.
	 */
	protected int column;
	
	/** Creates a new Sprite with a symbol and a location. 
	 * @param symbol The symbol representation of the sprite.
	 * @param row The row location of the sprite.
	 * @param column The column location of the sprite.
	 */
	public Sprite(char symbol, int row, int column){
		this.symbol = symbol;
		this.row = row;
		this.column = column;
	}
	
	/**
	 * Returns the symbol of the Sprite.
	 * @return symbol
	 */
	
	public char getSymbol(){
		return this.symbol;
	}
	
	/**
	 * Returns the row of the location of the sprite.
	 * @return row location of the Sprite.
	 */
	public int getRow(){
		return this.row;
	}
	
	/**
	 * Returns the column of the location of the sprite.
	 * @return column location of the Sprite.
	 */
	public int getColumn(){
		return this.column;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return String.valueOf(this.symbol);
	}

}
