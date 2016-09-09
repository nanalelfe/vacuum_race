package game;

import java.io.IOException;


import ui.GUI;
import ui.UI;

public class Play {

	public static void main(String[] args) throws IOException {
    
		VacuumGame game = new VacuumGame(Constants.FILENAME);
		UI gameUI = new GUI(game);;
		gameUI.launchGame(); 
		gameUI.displayWinner();
	}
}
