package game;
import game.Constants;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import sprites.CleanHallway;
import sprites.Dirt;
import sprites.Dumpster;
import sprites.DustBall;
import sprites.Sprite;
import sprites.Vacuum;
import sprites.Wall;

/**
 * A class that represents the basic functionality of the vacuum game.
 * This class is responsible for performing the following operations:
 * 1. At creation, it initializes the instance variables used to store the
 *        current state of the game.
 * 2. When a move is specified, it checks if it is a legal move and makes the
 *        move if it is legal.
 * 3. It reports information about the current state of the game when asked.
 */
public class VacuumGame {

    // a random number generator to move the DustBalls
    private Random random;

    // the grid
    private Grid<Sprite> grid;

    // the first player
    private Vacuum vacuum1;

    /// the second player
    private Vacuum vacuum2;

    // the dirt (both static dirt and mobile dust balls)
    private List<Dirt> dirts;

    // the dustballs
    private List<DustBall> dustballs;

    /**
     * Creates a new VacuumGame that corresponds to the given input text file.
     * Assumes that the input file has one or more lines of equal lengths, and
     * that each character in it (other than newline) is a character that 
     * represents one of the sprites in this game.
     * @param layoutFileName path to the input grid file
     */
    public VacuumGame(String layoutFileName) throws IOException {
        this.dirts = new ArrayList<Dirt>();
        this.dustballs = new ArrayList<DustBall>(); // Jen: may not need this
        this.random = new Random();

        // open the file, read the contents, and determine 
        // dimensions of the grid
        int[] dimensions = getDimensions(layoutFileName);
        this.grid = new ArrayGrid<Sprite>(dimensions[0], dimensions[1]);

        // open the file again, read the contents, and store them in grid
        Scanner sc = new Scanner(new File(layoutFileName));
      

	// INITIALIZING THE GRID HERE
        
        // i represents the rows of the array grid. 
        for (int i=0; i< dimensions[0]; i++){
        	String nextline = sc.nextLine();
        	populateGrid(nextline,i);
        }
        	
        sc.close();
    }
    
    private void populateGrid(String line, int row){
    	
    	/* Compares the characters found in the line to the 
    	 * String of the sprites, initializes the sprites and 
    	 * adds them to the array grid. 
    	 * The rows are the numbers given to the method, and the
    	 * columns are the indexes of the characters in the line. 
    	 */
    	
    	for (int i = 0; i < line.length(); i++){
        	char c = line.charAt(i);
      
        	if (c == Constants.CLEAN){
        		CleanHallway hall = new CleanHallway(Constants.CLEAN, row, i);
        		this.grid.setCell(row, i, hall);
        	}
        	else if (c == Constants.WALL){
        		Wall wall = new Wall(Constants.WALL, row, i);
        		this.grid.setCell(row, i, wall);
        	}
        	else if (c == Constants.DUMPSTER){
        		Dumpster dump = new Dumpster(Constants.DUMPSTER, row, i);
        		this.grid.setCell(row, i, dump);
        	}
        	else if(c == Constants.DIRT){
        		Dirt dirt = new Dirt(Constants.DIRT, row, i,
        				Constants.DIRT_SCORE);
        		this.grid.setCell(row, i, dirt);
        		this.dirts.add(dirt);
        	}
        	else if(c == Constants.DUST_BALL){
        		DustBall dustBall = new DustBall(Constants.
        				DUST_BALL,row, i, Constants.DUST_BALL_SCORE);
        		this.grid.setCell(row, i, dustBall);
        		this.dirts.add(dustBall);
        		this.dustballs.add(dustBall);
        	}
        	else if (c == Constants.P1) {
        		vacuum1 = new Vacuum(Constants.P1, row, i, Constants.CAPACITY);
        		CleanHallway cleanHall = new CleanHallway(Constants.CLEAN, row,
        				i);
        		vacuum1.setUnder(cleanHall);
        		this.grid.setCell(row,i, vacuum1);
        	}
        	else{
        		vacuum2 = new Vacuum(Constants.P2, row, i, Constants.CAPACITY);
        		CleanHallway cleanHall = new CleanHallway(Constants.CLEAN, row,
        				i);
        		vacuum2.setUnder(cleanHall);
        		this.grid.setCell(row,i, vacuum2);
        	}
        	
    	} 
        	
    }
    
    /**
     * Returns the gaming grid of the vacuum game.
     * @return the grid of the game.
     */
    public Grid<Sprite> getGrid(){
    	return this.grid;
    }
    
    /**
     * Returns the first player of the game, i.e vacuum one.
     * @return vacuum one. 
     */
    public Vacuum getVacuumOne(){
    	return this.vacuum1;
    	
    }
    
    /**
     * Returns the second player of the game, i.e vacuum two.
     * @return vacuum two.
     */
    public Vacuum getVacuumTwo(){
    	return this.vacuum2;
    }

    /**
     * Returns the number of rows that this game's grid has.
     * @return the number of rows of this game's grid.
     */
    public int getNumRows(){
    	return this.grid.getNumRows();
    }
    
    /**
     * Returns the number of columns that this game's grid has.
     * @return the number of columns of this game's grid.
     */
    public int getNumColumns(){
    	return this.grid.getNumColumns();
    }
    
    /**
     * Returns the sprite which is at location (i,j) on the game's grid.
     * @param i The row location of the sprite being returned.
     * @param j The column location of the sprite being returned.
     * @return the sprite at location (i,j).
     */
    public Sprite getSprite(int i, int j){
    	return this.grid.getCell(i,j);
    }
    
    /**
     * Returns true if the move nextMove is a valid move and applies 
     * that move. Returns false is the move is invalid. 
     * @param nextMove The move inserted by the user.
     * @return true is nextMove is valid, false otherwise. 
     */
    public boolean move(char nextMove){
    	
    	if (nextMove == Constants.P1_LEFT){
    		
    		/*The applyMove method takes in a vacuum, the change in the
    		 *row location and the change in the column location made 
    		 * if we move to the new location. */
    		return this.applyMove(vacuum1, 0, Constants.LEFT);
    	}
    	else if (nextMove == Constants.P1_RIGHT){
    		return this.applyMove(vacuum1, 0, Constants.RIGHT);
    	}
    	else if (nextMove == Constants.P1_UP){
    		return this.applyMove(vacuum1, Constants.UP, 0);
    	}
    	else if (nextMove == Constants.P1_DOWN){
    		return this.applyMove(vacuum1,  Constants.DOWN, 0);
    	}
    	else if (nextMove == Constants.P2_LEFT){
    		return this.applyMove(vacuum2, 0, Constants.LEFT);
    	}
    	else if (nextMove == Constants.P2_RIGHT){
    		return this.applyMove(vacuum2, 0, Constants.RIGHT);
    	}
    	else if (nextMove == Constants.P2_UP){
    		return this.applyMove(vacuum2, Constants.UP, 0);
    	}
    	else if (nextMove == Constants.P2_DOWN){
    		return this.applyMove(vacuum2,  Constants.DOWN, 0);
    	}
    	this.moveDustBall();
    	return false;
    }
    
    /** Applies a move made by a vacuum. */
    private boolean applyMove(Vacuum vacuum, int changeRow, int changeCol){
    	// This method applies the move that was asked to be made
    	// in the move method. 
    	
    	/*Saving the old and new coordinates of the vacuum in a list. 
    	 *The new coordinates are the location to which the user wants to move.
    	 */
    	Integer[] coordOld = {vacuum.getRow(), vacuum.getColumn()};
    	Integer[] coordNew = {vacuum.getRow() + changeRow, vacuum.getColumn()
    			+ changeCol};
    	
		if (validVacuumMove(coordNew[0], coordNew[1])){
			Sprite oldSprite = vacuum.getUnder();
			vacuum.moveTo(coordNew[0], coordNew[1]);
			Sprite spriteUnder = this.getSprite(coordNew[0], coordNew[1]);
			vacuum.setUnder(spriteUnder);
			
			// setting the vacuum to the new location on the grid.
			this.grid.setCell(coordNew[0], coordNew[1], vacuum);
			
			/* if spriteUnder is a dirt and vacuum can clean it,
			 * we remove the dirt from the list of dirts.
			 */
			if ((spriteUnder.getSymbol() == Constants.DIRT) && (vacuum
					.clean(Constants.DIRT_SCORE))){
				this.dirts.remove(spriteUnder);
			}
			
			// same rule as above applies.
			else if ((spriteUnder.getSymbol() == Constants.DUST_BALL)
					&& (vacuum.clean(Constants.DUST_BALL_SCORE))){
				this.dirts.remove(spriteUnder);
				this.dustballs.remove(spriteUnder);
			}
			
			// if the sprite at the new location is a dumpster,
			// empty the vacuum.
			else if (spriteUnder.getSymbol() == Constants.DUMPSTER){
				vacuum.empty();
			}	
			
			// we need to add the sprite that was under the vacuum 
			// at the old location to the grid. 
			this.grid.setCell(coordOld[0], coordOld[1], oldSprite);
		}
		
		// no matter whether the vecuum moves or not, move all the dustballs.
		this.moveDustBall();
		return true;
    }
    
    private Integer[] DustballGetMove(DustBall dustBall, int row, int column){
    	
    	// This method picks a random move for the dustball
    	// out of all the possible moves.
    	
    	/* All the possible dustball moves */
    	Integer[] move1 = {row + Constants.UP, column};
    	Integer[] move2 = {row, column + Constants.LEFT};
    	Integer[] move3 = {row + Constants.DOWN, column};
    	Integer[] move4 = {row, column + Constants.RIGHT};
    	//=========================================================
    	
    	// We create an array of all the possible moves and 
    	// convert it to an Arraylist (to save ourselves from adding
    	// all four moves to the ArrayList separately)
    	Integer [][] sampleSpace = {move1, move2, move3, move4};
    	ArrayList<Integer[]> possibleMoves = new ArrayList<Integer[]>
    	(Arrays.asList(sampleSpace));
    	
    	// We pick a move at random from the list of possible moves.
    	Integer[] pickMove = possibleMoves.get(random.nextInt(possibleMoves
    			.size()));
    	
    	// if pickMove is not a valid move, we remove that move from
    	// the list of possible moves, and pick another move from the 
    	// remaining elements in the list. 
    	while(!validDustballMove(pickMove[0], pickMove[1])){
    		possibleMoves.remove(pickMove);
    		
    		// if there are valid moves left
    		if (possibleMoves.size() > 0)
    			pickMove = possibleMoves.get(random.nextInt(possibleMoves
    					.size()));
    		
    		// else return null 
    		else
    			return null;
    	}
    	return pickMove;
    }
    
    private void moveDustBall(){
    	
    	// This method moves all the dustballs available in the game as
    	// soon as a vacuum moves. 
    	
    	for (java.util.Iterator<DustBall> it = dustballs.iterator();
    			it.hasNext();){
    		DustBall dustBall = it.next();
    		int row = dustBall.getRow();
    		int column = dustBall.getColumn();
    		Integer[] move = DustballGetMove(dustBall, row, column);
    		
    		// if there are no valid moves left, do nothing.
    		if (move != null){
	    		dustBall.moveTo(move[0], move[1]);
	    		
	    		// if the new position has dirt in it, consume the dirt.
	    		Sprite sprite1 = this.getSprite(move[0], move[1]);
	    		if ((sprite1.getSymbol() == Constants.DIRT)){
	    			dirts.remove(sprite1);
	    		}
	    		this.grid.setCell(move[0], move[1], dustBall);
	    		
	    		Sprite sprite = this.getSprite(row, column);	
	    		Dirt dirt = new Dirt(Constants.DIRT, row, column,
	    				Constants.CAPACITY);
	    		
	    		// if the previous position had a vacuum on top, leave
	    		// dirt underneath the vacuum.
	    		if ((sprite.getSymbol() == Constants.P1) || (sprite
	    				.getSymbol() == Constants.P2)){
	    			((Vacuum)sprite).setUnder(dirt);
	    		}
	    		
	    		//else leave dirt behind.
	    		else{
	    			dirts.add(dirt);
	    			this.grid.setCell(row, column, dirt);
	    		}
    		}
    	}	
    }
    
    private boolean validVacuumMove(int row, int column){
    	// takes in the coordinates where the vacuum wants to move to, 
    	// then checks if the sprite in this location can be moved onto by 
    	// the vacuum.
    	Sprite sprite = this.getSprite(row, column);
    	return ((sprite.getSymbol() == Constants.DIRT) || (sprite.getSymbol()
    			== Constants.DUST_BALL) || (sprite.getSymbol()
    					== Constants.CLEAN)  || (sprite.getSymbol(
    							) == Constants.DUMPSTER));
    }
    
    private boolean validDustballMove(int row, int column){
    	// takes in the coordinates where the dustball wants to move to, 
    	// then checks if the sprite in this location can be moved onto by 
    	// the dustball.
    	Sprite sprite = this.getSprite(row, column);
    	return ((sprite.getSymbol() == Constants.DIRT) || (sprite
    			.getSymbol() == Constants.CLEAN));
    }
    
    /**
     * Returns true if the game is over, false otherwise.
     * @return true if and only if the game is over.
     */
    public boolean gameOver(){
    	return this.dirts.size() == 0;
    }
    
    /**
     * Returns 1 is the first player won the game, 2 if the second player won
     * the game, and 0 if the game ended in a tie.
     * @return 1 if vacuum 1 wins, 2 is vacuum 2 wins, 0 otherwise.
     */
    public int getWinner(){
    	if (vacuum1.getScore() > vacuum2.getScore())
    		return 1;
    	else if (vacuum1.getScore() < vacuum2.getScore())
    		return 2;
    	else
    		return 0;
    }

    /**
     * Returns the dimensions of the grid in the file named layoutFileName.
     * @param layoutFileName path of the input grid file
     * @return an array [numRows, numCols], where numRows is the number
     * of rows and numCols is the number of columns in the grid that
     * corresponds to the given input grid file
     * @throws IOException
     */
    private int[] getDimensions(String layoutFileName) throws IOException {       

        Scanner sc = new Scanner(new File(layoutFileName));

        // find the number of columns
        String nextLine = sc.nextLine();
        int numCols = nextLine.length();

        int numRows = 1;

        // find the number of rows
        while (sc.hasNext()) {
            numRows++;
            nextLine = sc.nextLine();
        }

        sc.close();
        return new int[]{numRows, numCols};
    }
    
}
