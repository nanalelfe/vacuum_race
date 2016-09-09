package ui;

/**
 * A user interface that launches a game and displays
 * the winner once the game is over.
 */
public interface UI {

	/**
	 * Launches the game.
	 */
	void launchGame();
	
	/**
	 * Displays the winner of the game.
	 */
	void displayWinner();
	
}
