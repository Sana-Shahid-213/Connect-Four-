package sanatorium;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Board {

	private Cell[][] board;
	private int rows;
	private int cols;
	private CellState currentPlayer;
	private boolean endedGame = false;
	


	/**
	 * Constructor for Boards.
	 * 
	 * @param aRows number of rows in board
	 * @param aCols number of columns in board
	 */
	public Board(int aRows, int aCols) {
		board = new Cell[aRows][aCols];
		rows = aRows;
		cols = aCols;
		currentPlayer = CellState.P1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = new Cell(CellState.EMPTY); // no color
			}
		}
	}

	/**
	 * Obtain the current player (colour)
	 * 
	 * @return player (colour)
	 */
	public CellState getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * Obtain the current number of rows.
	 * 
	 * @return number of rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Obtain the current number of columns.
	 * 
	 * @return number of columns
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * Check if a proposed location is valid.
	 * 
	 * @param rowIndex row index to check
	 * @param colIndex column index to check
	 * @return true if index value is valid, otherwise false
	 */
	public boolean isValid(int rowIndex, int colIndex) {
		return (rowIndex >= 0 && rowIndex < rows) && (colIndex >= 0 && colIndex < cols);
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
		board[rows - 1][column - 1].setState(player);

	}

	/**
	 * Purpose: drops a token into the 2D Array of Buttons, into a column specified
	 * by the user.
	 * 
	 * @param column        int returned when button above is selected by user
	 * @param modArray      array of buttons representing board
	 * @param currentPlayer current player and colour of token to drop
	 */


	public void drop(int column, Circle[][] modArray, CellState currentPlayer, Button[] tileBtns) {
		
		boolean placed = false;//checks from the bottom up, so only 1 token should be placed when drop is called.
		

		for (int i = modArray.length - 1; i >= 0; i--) {

			// if the space is free, add a token

			if (modArray[i][column].getFill() == (Color.MIDNIGHTBLUE) && placed == false) {

				// place red token if player is red
				if (currentPlayer == CellState.P1) {
					modArray[i][column].setFill(Color.RED);

					// System.out.println("it worked! red placed");
					checkWin(modArray, currentPlayer, column, tileBtns);
					switchPlayer(tileBtns);
					placed = true;

					// place yellow token if player is yellow
				} else if (currentPlayer == CellState.P2) {

					modArray[i][column].setFill(Color.YELLOW);

					checkWin(modArray, currentPlayer, column, tileBtns);
					switchPlayer(tileBtns);

					// System.out.println("it worked! yellow placed");
					placed = true;
				}

			}
		}

	}

	/**
	 * Purpose: changes currentPlayer. Helper method called when a token is dropped
	 */
	public void switchPlayer(Button tileBtns[]) {
		if (currentPlayer == CellState.P1) {
			// System.out.println("successfully changed to yellow");
			this.currentPlayer = CellState.P2;

		} else if (currentPlayer == CellState.P2) {
			// System.out.println("successfully changed to red");
			this.currentPlayer = CellState.P1;

		} else {
			this.currentPlayer = CellState.P1;
		}
		for (int i = 0; i < tileBtns.length; i++) {

			if (this.currentPlayer == CellState.P1) {
				tileBtns[i].setStyle("-fx-background-color: red; -fx-font: 20 arial; -fx-font-weight: bold;");

			} else if (this.currentPlayer == CellState.P2) {
				tileBtns[i].setStyle("-fx-background-color: yellow; -fx-font: 20 arial; -fx-font-weight: bold;");

			}
		}

	}

	/**
	 * Purpose: checks the board for a win, given a specific colour to search for
	 * (current player
	 * 
	 * @param board         2D Array of Buttons representing a board
	 * @param currentPlayer String representing current colour's turn
	 * @param col           int column specified (where it was dropped)
	 */
	public void checkWin(Circle[][] board, CellState currentPlayer, int col, Button[] tileBtns) {
		int fourInARow = 0;
		for (int i = board.length - 1; i >= 0; i--) {
			for (Circle rowElement : board[i]) {
				// start a count of the player's colour to 4, reset the count if not. if 4 is
				// reached then display win msg
				// TODO method to display win message

				// if player colour found, add to the count
				if (rowElement.getFill() == (Color.RED) && this.currentPlayer == CellState.P1) {
					fourInARow++;
					// System.out.println(currentPlayer + " GOTCHA " + fourInARow);

				} else if (rowElement.getFill() == (Color.YELLOW) && this.currentPlayer == CellState.P2) {
					fourInARow++;
					// System.out.println(currentPlayer + " GOTCHA " + fourInARow);

				}
				// if it is not the player's colour, reset count.
				else {
					// System.out.println(currentPlayer + " BACK TO ZERO");
					fourInARow = 0;
					// System.out.println(fourInARow);

				}
				// if 4 in a row is reached, congratulate player
				if (fourInARow >= 4) {
					System.out.println("YIPPEE " + currentPlayer + " you WON horizontally");
					// TODO end game here.
					gameOver(tileBtns, currentPlayer);

				}

			}

		}
		// now checking columns
		fourInARow = 0;
		for (int j = board.length - 1; j >= 0; j--) {

			// move up through rows
			for (Circle row[] : board) {

				// same concept as row check, count consecutive player pieces
				if (row[j].getFill() == (Color.RED) && this.currentPlayer == CellState.P1) {
					fourInARow++;

				} else if (row[j].getFill() == (Color.YELLOW) && this.currentPlayer == CellState.P2) {
					fourInARow++;

				}

				else {
					fourInARow = 0;
				}
				if (fourInARow >= 4) {
					System.out.println("YIPPEE " + currentPlayer + " YOU WON VERTICALLY");
					// TODO end game here - make game end method?? boolean???
					gameOver(tileBtns, currentPlayer);
				}
			}

		}
		// TODO implement diagonal row checking!!!!!

		// diagonal row checking below
		// TODO IN PROGRESS!!!! IN PROGRESS!!!!!! NOT DONE YET!!! DOES NOT
		// WORK!!!!!!!!!!!
		int n = 0;
		for (int k = 0; k < 12; k++) {
			if (n <= 6 && k < 6) {
				for (int l = 0; l < n; l++) {
					if (board[k][l].getFill() == (Color.RED) && this.currentPlayer == CellState.P1) {
						fourInARow++;
					} else if (board[k][l].getFill() == (Color.YELLOW) && this.currentPlayer == CellState.P2) {
						fourInARow++;
					} else {
						fourInARow = 0;
					}
					if (fourInARow >= 4) {
						System.out.println("YIPPEE " + currentPlayer + " YOU WON DIAGONALLY");
						// TODO end game here
						gameOver(tileBtns, currentPlayer);
					}

				}
			}
		}

	}

	public void gameOver(Button[] tileBtns, CellState winningPlayer) {
		endedGame = true;
		// disable buttons now.
		System.out.println("YO IT WORKS");
		String winner = "";

		if (winningPlayer == CellState.P1) {
			winner = "1";
		} else if (winningPlayer == CellState.P2) {
			winner = "2";
		}

		String[] pWins = { "P", winner, " ", "W", "I", "N", "S" };
		switchPlayer(tileBtns);
		for (int i = 0; i < tileBtns.length; i++) {
			// tileBtns[i].setStyle("-fx-background-color: darkblue");
			tileBtns[i].setText(pWins[i]);
			// tileBtns[i].setStyle("-fx-background-color: white; -fx-font-weight: bold");
			tileBtns[i].setTextFill(Color.WHITE);
			tileBtns[i].setDisable(true);

		}

	}

}