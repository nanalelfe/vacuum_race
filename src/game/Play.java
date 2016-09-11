package game;

import java.io.File;
import java.io.IOException;


import ui.GUI;
import ui.UI;

public class Play {

	public static void main(String[] args) throws IOException {
		File file = new File (Constants.FILENAME);
		String absolutePath = file.getAbsolutePath();
    
		VacuumGame game = new VacuumGame(absolutePath);
		UI gameUI = new GUI(game);;
		gameUI.launchGame(); 
		gameUI.displayWinner();
	}
}
