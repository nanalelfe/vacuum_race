package sprites;

/**
 * A representation of a movaeble vacuum for the vacuum game.
 * At creation, it initializes its capacity, fullness and sets the surface
 * under it to a clean hallway. When asked to clean, it is only able to
 * do so when it is not full. 
 */
public class Vacuum extends Sprite implements Moveable {
	
	private int score;

	private int capacity;
	
	private int fullness;
	
	private Sprite under;
	
	/**
	 * Creates a new vacuum with a symbol, a location and a cleaning capacity.
	 * @param symbol The symbol representation of the vacuum.
	 * @param row The row location of the vacuum.
	 * @param column The column location of the vacuum.
	 * @param capacity The cleaning capacity of the vacuum.
	 */
	public Vacuum(char symbol, int row, int column, int capacity) {
		// capacity is 5, according to Constants class
		super(symbol, row, column);
		this.capacity = capacity;
		this.fullness = 0;
		this.under = new CleanHallway(' ', row, column);
		
	}


	/* (non-Javadoc)
	 * @see sprites.Moveable#moveTo(int, int)
	 */
	@Override
	public void moveTo(int row, int column) {
		this.row = row;
		this.column = column;

	}
	
	/** Cleans the surface under the vacuum, and increments the vacuum's score
	 * with score if it succeeds, i.e it has not reached its capacity.
	 * @param score The score gained by cleaning the surface underneath the 
	 * vacuum.
	 * @return true if the vacuum succeeds in cleaning the surface,
	 * false otherwise. 
	 */
	public boolean clean(int score){
		if (fullness < this.capacity){
			this.under = new CleanHallway(' ', this.row, this.column);
			this.score += score;
			fullness += 1;
			return true;
		}
		return false;
	}
	
	/**
	 * Empties the vacuum. 
	 */
	public void empty(){
		this.fullness = 0;
	}


	/**
	 * Returns the object under the vacuum.
	 * @return the object under the vacuum.
	 */
	public Sprite getUnder() {
		return this.under;
	}


	/** 
	 * Places the object under underneath the vacuum.
	 * @param under Object that has to be placed under the vacuum.
	 */
	public void setUnder(Sprite under) {
		this.under = under;
	}


	/**
	 * Returns the score of the vacuum.
	 * @return the score of the vacuum.
	 */
	public int getScore() {
		return this.score;
	}
	

}
