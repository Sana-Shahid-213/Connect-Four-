package sanatorium;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Board {
	
	
	private Cell[][] board;
	private int rows;
	private int cols;
	private String currentPlayer;

	/**
	 * Constructor for Boards.
	 * @param aRows number of rows in board
	 * @param aCols number of columns in board
	 */
	public Board(int aRows, int aCols) {
		board = new Cell[aRows][aCols];
		rows = aRows;
		cols = aCols;
		currentPlayer = "Red";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = new Cell(CellState.EMPTY); // no color
			}
		}
	}
	/**
	 * Obtain the current player (colour)
	 * @return player (colour)
	 */
	public String getCurrentPlayer() {
		return currentPlayer;
	}
	
	/**
	 * Obtain the current number of rows.
	 * @return number of rows
	 */
	public int getRows(){
		return rows;
	}
	
	/**
	 * Obtain the current number of columns.
	 * @return number of columns
	 */
	public int getCols(){
		return cols;
	}
	
	/**
	 * Check if a proposed location is valid.
	 * @param rowIndex row index to check
	 * @param colIndex column index to check
	 * @return true if index value is valid, otherwise false
	 */
	public boolean isValid(int rowIndex, int colIndex){
		return (rowIndex>=0 && rowIndex < rows) && (colIndex>=0 && colIndex < cols);
	}
	
	
	
	
		
	
	
	public void display() {
		System.out.println("BOARD");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%s ", board[i][j]);
			}
			System.out.println();
		}
	}
	
	public void placePiece(int column, CellState player) {
		board[rows-1][column-1].setState(player);
		
	}
	/**
	 * Purpose: drops a token into the 2D Array of Buttons, into a column specified by the user.
	 * @param column int returned when button above is selected by user
	 * @param modArray array of buttons representing board
	 * @param currentPlayer current player and colour of token to drop
	 */
	public void drop(int column, Circle[][] modArray, String currentPlayer) {
		boolean placed = false;
		for (int i = modArray.length-1; i >= 0; i--) {

			// if the space is free, add a token
			//if (modArray[i][column].getStyle().equals(("-fx-base: blue")) && placed == false) {
			if (modArray[i][column].getFill() == (Color.MIDNIGHTBLUE) && placed == false) {
				if (currentPlayer == "Red") {
				//modArray[i][column].setStyle("-fx-base: red");
					modArray[i][column].setFill(Color.RED);
					//modArray[i][column].setStroke(Color.CRIMSON);
				 //System.out.println("it worked! red placed");
				 checkWin(modArray, currentPlayer, column);
				 switchPlayer();
				 placed = true;
				 
				}else if (currentPlayer == "Yellow") {
					//modArray[i][column].setStyle("-fx-base: yellow");
					modArray[i][column].setFill(Color.YELLOW);
					//modArray[i][column].setStroke(Color.GOLD);
					checkWin(modArray, currentPlayer, column);
					switchPlayer();
					
					// System.out.println("it worked! yellow placed");
					 placed = true;
					}
				 //placed = true;//so only one token can be placed at a time
				 
			}
			//placed = true;
		}
		
	}
	/**
	 * Purpose: changes currentPlayer. Helper method called when a token is dropped
	 */
	public void switchPlayer() {
		if (currentPlayer == "Red"){
			//System.out.println("successfully changed to yellow");
			this.currentPlayer = "Yellow";
			
		}else if (currentPlayer == "Yellow"){
			//System.out.println("successfully changed to red");
			this.currentPlayer = "Red";
			
		}else {
			this.currentPlayer = "Red";
		}
		
	}
	
	/**
	 * Purpose: checks the board for a win, given a specific colour to search for (current player
	 * @param board 2D Array of Buttons representing a board
	 * @param currentPlayer String representing current colour's turn
	 * @param col int column specified (where it was dropped)
	 */
	public void checkWin(Circle[][] board, String currentPlayer, int col) {
		int fourInARow = 0;
		for (int i = board.length-1; i >= 0; i--) {
			for (Circle rowElement : board[i]) {
				//TODO check each element of the row, given a certain colour to search for.
				//this will be called right after a turn.
				//start a count to 4, reset the count if not. if 4 is reached then display win msg.
				
				//if (rowElement.getFill().equals("-fx-base: red") && this.currentPlayer == "Red") {
				if (rowElement.getFill()==(Color.RED) && this.currentPlayer == "Red") {
					fourInARow++;
					//System.out.println(currentPlayer + " GOTCHA " + fourInARow);
					
				//}else if (rowElement.getStyle().equals("-fx-base: yellow") && this.currentPlayer == "Yellow") {
				}else if (rowElement.getFill() == (Color.YELLOW) && this.currentPlayer == "Yellow") {
					fourInARow++;
					//System.out.println(currentPlayer + " GOTCHA " + fourInARow);
				
				}
				
				
				else {
					//System.out.println(currentPlayer + " BACK TO ZERO");
					fourInARow = 0;
					//System.out.println(fourInARow);
					
				}
				if (fourInARow >= 4) {
					System.out.println("YIPPEE " + currentPlayer + " you WON horizontally");
					//TODO end game here.
					
				}
				
			}
			
			
			
			
		}
		//now checking columns
		fourInARow = 0;
		for (int j = board.length-1; j>=0; j--) {
			
			//move up through rows
			for (Circle row[] : board) {
			//if (row[j].getStyle().equals("-fx-base: red") && this.currentPlayer == "Red") {
			if (row[j].getFill() == (Color.RED) && this.currentPlayer == "Red") {
				fourInARow++;
			//}else if (row[j].getStyle().equals("-fx-base: yellow") && this.currentPlayer == "Yellow") {
			}else if (row[j].getFill() == (Color.YELLOW) && this.currentPlayer == "Yellow") {
				fourInARow++;
			
			}
			
			
			else {
				fourInARow = 0;
			}if (fourInARow >= 4) {
				System.out.println("YIPPEE " + currentPlayer + " YOU WON VERTICALLY");
				//TODO end game here
			}
			}
			
		}
		//TODO implement diagonal row checking!!!!!
		
		//diagonal row checking below
		//TODO IN PROGRESS!!!! IN PROGRESS!!!!!!
		int n = 0;
		for (int k=0; k<12; k++) {
			if (n<=6 && k<6) {
				for (int l=0; l<n; l++) {
					if (board[k][l].getFill() == (Color.RED) && this.currentPlayer == "Red") {
						fourInARow++;
					}else if (board[k][l].getFill() == (Color.YELLOW) && this.currentPlayer == "Yellow") {
						fourInARow++;
					}else {
						fourInARow = 0;
					}if (fourInARow >= 4) {
						System.out.println("YIPPEE " + currentPlayer + " YOU WON DIAGONALLY");
						//TODO end game here
					}
					
					
				}
			}
		}
		
		
		
		
	}
	
}