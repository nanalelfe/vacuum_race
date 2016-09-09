package ui;

import game.VacuumGame;
import game.Constants;

import java.awt.*;
import javax.swing.*;



/** A simple GUI for the game. */
@SuppressWarnings("serial")
public class GUI extends JFrame implements UI {

	private VacuumGame game;
	private JLabel[][] tiles;
	
	private ImageIcon[] spriteIcons; 

	/** Initializes a GUI for the given MazeGame.
	 * @param game The MazeGame of this GUI 
	 */
	public GUI(VacuumGame game) {
		this.game = game;
	}

	/** Returns the MazeGame of this GUI.
	 * @return the MazeGame of this GUI
	 */
	public VacuumGame getGame() {
		return this.game;
	}

	@Override
	public void launchGame() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 5);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 5);
	    this.setLocation(x, y);
		
		int numRows = this.game.getNumRows();
		int numCols = this.game.getNumColumns();
	

		Container c = this.getContentPane();
		c.setLayout(new GridLayout(numRows, numCols));
		this.tiles = new JLabel[numRows][numCols];
		this.spriteIcons = new ImageIcon[7];
		spriteIcons[0] = new ImageIcon(getClass().getResource("../res/clean.png"));
		spriteIcons[1] = new ImageIcon(getClass().getResource("../res/wall.png"));
		spriteIcons[2] = new ImageIcon(getClass().getResource("../res/p1.png"));
		spriteIcons[3] = new ImageIcon(getClass().getResource("../res/p2.png"));
		spriteIcons[4] = new ImageIcon(getClass().getResource("../res/dirt.png"));
		spriteIcons[5] = new ImageIcon(getClass().getResource("../res/dustball.png"));
		spriteIcons[6] = new ImageIcon(getClass().getResource("../res/dumpster.png"));

		GUIListener listener = new GUIListener(this);
		this.addKeyListener(listener);

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
			    JLabel label = new JLabel();
				/*label.setText("" + this.game.getSprite(i, j).toString());                
				label.setFont(new Font(null, Font.BOLD, 18));
				*/
			    
			    ImageIcon icon = getSpriteIcon(this.game.getSprite(i, j).toString().charAt(0));
			    icon.getImage().flush();
			    label.setIcon( icon );
			    label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setVerticalAlignment(SwingConstants.CENTER);
				
				c.add(label);
				this.tiles[i][j] = label;
			}
		}
		setVisible(true);
		pack();
	}

	@Override
	public void displayWinner() {

	    if (!this.game.gameOver()) {
	        return;
	    }
	    
	    int won = this.game.getWinner();
		String message;

		if (won == 1) {
			message = "Congratulations Player 1! You won the game with a score of " + 
					this.game.getVacuumOne().getScore() + ".";
		} else { 
			message = "Congratulations Player 2! You won the game with a score of " + 
					this.game.getVacuumTwo().getScore() + ".";
		}
		JOptionPane.showMessageDialog(null, message);
		setVisible(false);
	}

	/** Update the grid display. */
	public void updateLabels() {
		int numRows = this.game.getNumRows();
		int numCols = this.game.getNumColumns();

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
			
				
				//ImageIO image = ImageIO.read(getClass().getResource("/resources/icon.gif"));
				
				ImageIcon icon = getSpriteIcon(this.game.getSprite(i, j).toString().charAt(0));
			    icon.getImage().flush();
				this.tiles[i][j].setIcon(icon);
				
				//this.tiles[i][j].setText(this.game.getSprite(i, j).toString());
			    //label.setText("");
			}
		}
		displayWinner();
	}
	
	public ImageIcon getSpriteIcon(char symbol) {
		ImageIcon imageIcon = null;
		switch (symbol) {
		case Constants.CLEAN: imageIcon = this.spriteIcons[0];
							  break;
		case Constants.WALL: imageIcon = this.spriteIcons[1];
							break;
		case Constants.P1: imageIcon = this.spriteIcons[2];
							break;
		case Constants.P2: imageIcon = this.spriteIcons[3];
							break;
		case Constants.DIRT: imageIcon = this.spriteIcons[4];
							break;
		case Constants.DUST_BALL: imageIcon = this.spriteIcons[5];
								break;
		case Constants.DUMPSTER: imageIcon = this.spriteIcons[6];
								break;
		}
		
		return imageIcon;
	}
}