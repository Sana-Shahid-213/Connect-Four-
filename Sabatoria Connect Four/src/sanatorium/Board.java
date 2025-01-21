package sanatorium;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Purpose: Contains gameplay tracking methods for Connect Four
 * @author Sana & Victoria
 * @date Jan 20th 2025
 */
public class Board {
	private Cell[][] board;
	private int rows;
	private int cols;
	private CellState currentPlayer;
	
	/**
	 * Constructor for Boards.
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
	 * @return player (colour)
	 */
	public CellState getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * Obtain the current number of rows.
	 * @return number of rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Obtain the current number of columns.
	 * @return number of columns
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * Purpose: prints updated text-based board in console
	 */
	public void display() {
        System.out.println("BOARD");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%s ", board[i][j]);
            }
            System.out.println();
        }
    }
	
	
	
	/**
	 * drops a token into the 2D Array of Buttons, into a column specified
	 * by the user.
	 * @param column int returned when button above is selected by user
	 * @param modArray array of buttons representing board
	 * @param currentPlayer current player and colour of token to drop
	 * @param tileBtns Array of clickable buttons for the user to indicate what column to drop a token
	 */
	public void drop(int column, Circle[][] modArray, CellState currentPlayer, Button[] tileBtns) {

		boolean placed = false;// checks from the bottom up, so only 1 token should be placed when drop is
								// called.

		for (int i = modArray.length - 1; i >= 0; i--) {

			// if the space is free, add a token

			if (modArray[i][column].getFill() == (Color.MIDNIGHTBLUE) && placed == false) {

				// place red token if player is red
				if (currentPlayer == CellState.P1) {
					modArray[i][column].setFill(Color.CRIMSON);
					board[i][column].setState(currentPlayer);

					// System.out.println("it worked! red placed");
					checkWin(modArray, currentPlayer, column, tileBtns);
					switchPlayer(tileBtns);
					placed = true;

					// place yellow token if player is yellow
				} else if (currentPlayer == CellState.P2) {
					modArray[i][column].setFill(Color.GOLD);
					board[i][column].setState(currentPlayer);

					checkWin(modArray, currentPlayer, column, tileBtns);
					switchPlayer(tileBtns);

					// System.out.println("it worked! yellow placed");
					placed = true;
				}

			}
		}

	}

	/**
	 * Purpose - to switch the player colours of the overhead buttons upon taking a turn
	 * @param tileBtns - Array of clickable buttons for the user to choose a column to drop a token
	 */
	public void switchPlayer(Button[] tileBtns) {
		if (currentPlayer == CellState.P1) {
			// System.out.println("successfully changed to yellow");
			this.currentPlayer = CellState.P2;

		} else if (currentPlayer == CellState.P2) {
			// System.out.println("successfully changed to red");
			this.currentPlayer = CellState.P1;

		} /*else {
			this.currentPlayer = CellState.P1;
		}*/
		for (int i = 0; i < tileBtns.length; i++) {

			if (this.currentPlayer == CellState.P1) {
				tileBtns[i].setStyle("-fx-background-color: crimson; -fx-font: 20 arial; -fx-font-weight: bold;");

			} else if (this.currentPlayer == CellState.P2) {
				tileBtns[i].setStyle("-fx-background-color: gold; -fx-font: 20 arial; -fx-font-weight: bold;");

			}
		}

	}

	/**
	 * Purpose: checks the board for a win, given a specific colour to search for
	 * @param board - 2D Array of Circle objects representing 
	 * @param currentPlayer - CellState object determining who is taking a turn
	 * @param col - int representing the user indicated column
	 * @param tileBtns - Array of Buttons for the user to click
	 */
	public void checkWin(Circle[][] board, CellState currentPlayer, int col, Button[] tileBtns) {
		int fourInARow = 0;
		for (int i = board.length - 1; i >= 0; i--) {
			for (Circle rowElement : board[i]) {
				// start a count of the player's colour to 4, reset the count if not. if 4 is
				// reached then display win msg
				// TODO method to display win message

				// if player colour found, add to the count
				if (rowElement.getFill() == (Color.CRIMSON) && this.currentPlayer == CellState.P1) {
					fourInARow++;
					// System.out.println(currentPlayer + " GOTCHA " + fourInARow);

				} else if (rowElement.getFill() == (Color.GOLD) && this.currentPlayer == CellState.P2) {
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
					gameOver(tileBtns, currentPlayer, board);

				}

			}

		}
		// now checking columns
		fourInARow = 0;
		for (int j = board.length - 1; j >= 0; j--) {

			// move up through rows
			for (Circle row[] : board) {

				// same concept as row check, count consecutive player pieces
				if (row[j].getFill() == (Color.CRIMSON) && this.currentPlayer == CellState.P1) {
					fourInARow++;

				} else if (row[j].getFill() == (Color.GOLD) && this.currentPlayer == CellState.P2) {
					fourInARow++;

				}

				else {
					fourInARow = 0;
				}
				if (fourInARow >= 4) {
					System.out.println("YIPPEE " + currentPlayer + " YOU WON VERTICALLY");
					// TODO end game here - make game end method?? boolean???
					gameOver(tileBtns, currentPlayer, board);
				}
			}

		}

		// diagonal row checking below
		//check from top left to bottom right 
		//Concept taken from Google Gemini, modified to be used in our game
		
		//different approach
		for (int k=0; k<=2; k++) {
            for (int l=0; l<=3; l++) {
                if (board[k][l].getFill() == (Color.CRIMSON) && currentPlayer == CellState.P1 && 
                    board[k+1][l+1].getFill() == (Color.CRIMSON) && currentPlayer == CellState.P1 &&
                    board[k+2][l+2].getFill() == (Color.CRIMSON) && currentPlayer == CellState.P1 &&
                    board[k+3][l+3].getFill() == (Color.CRIMSON) && currentPlayer == CellState.P1) {
                    gameOver(tileBtns, currentPlayer, board);
                }else if (board[k][l].getFill() == (Color.GOLD) && currentPlayer == CellState.P2 && 
                        board[k+1][l+1].getFill() == (Color.GOLD) && currentPlayer == CellState.P2 &&
                        board[k+2][l+2].getFill() == (Color.GOLD) && currentPlayer == CellState.P2 &&
                        board[k+3][l+3].getFill() == (Color.GOLD) && currentPlayer == CellState.P2) {
                        gameOver(tileBtns, currentPlayer, board);
                        System.out.println("YIPPEE " + currentPlayer + " YOU WON DIAGONALLY");
                    }
            }
        }

        // checking from bottom left to top right
        for (int m=5; m>=3; m--) {
            for (int n=0; n<=3; n++) {
                if (board[m][n].getFill() == (Color.CRIMSON) && currentPlayer == CellState.P1 && 
                    board[m-1][n+1].getFill() == (Color.CRIMSON) && currentPlayer == CellState.P1 &&
                    board[m-2][n+2].getFill() == (Color.CRIMSON) && currentPlayer == CellState.P1 &&
                    board[m-3][n+3].getFill() == (Color.CRIMSON) && currentPlayer == CellState.P1) {
                    gameOver(tileBtns, currentPlayer, board);
                }
                if (board[m][n].getFill() == (Color.GOLD) && currentPlayer == CellState.P2 && 
                        board[m-1][n+1].getFill() == (Color.GOLD) && currentPlayer == CellState.P2 &&
                        board[m-2][n+2].getFill() == (Color.GOLD) && currentPlayer == CellState.P2 &&
                        board[m-3][n+3].getFill() == (Color.GOLD) && currentPlayer == CellState.P2) {
                        gameOver(tileBtns, currentPlayer, board);
                        System.out.println("YIPPEE " + currentPlayer + " YOU WON DIAGONALLY");
                    }
            }
        }

	}
	/**
	 * Purpose: to determine whether the game is tied.
	 * @param board - 2D Array of circles representing the board
	 * @param tileBtns - Array of Tiles representing clickable column buttons
	 */
	public void checkTie(Circle[][] board, Button[] tileBtns) {
	
		boolean isTie = true;
		CellState winningPlayer = CellState.EMPTY;

		for (int p = 0; p<6; p++) {

		if (board[0][p].getFill() == (Color.MIDNIGHTBLUE)){

		isTie = false;

		}
	}
		if (isTie) {
			gameOver(tileBtns, winningPlayer, board);
		}
	}
	
	/**
	 * Purpose: to end the game, called in different circumstances (winning, tieing)
	 * @param tileBtns - Array of Buttons for user to drop tokens in columns 
	 * @param winningPlayer - CellState indicating which player has won
	 * @param circles - 2D Array of Circles representing the connect 4 board
	 */
	public void gameOver(Button[] tileBtns, CellState winningPlayer, Circle[][] circles) {
		
		//disable buttons now.
		String winner = "";
		boolean isTie = true;
		String[] message;
		
		if (winningPlayer == CellState.P1) {
			winner = "1";
		}else if (winningPlayer == CellState.P2) {
			winner = "2";
		}
		
		//end message
		String[] pWins = {"P", winner, " ", "W","I", "N", "S"};
		String[] pTie = {" ", " ", "T", "I","E", " ", " "};
		
		

		System.out.println(winningPlayer);
		
		for (int p = 0; p<6; p++) {

			if (circles[0][p].getFill() == (Color.MIDNIGHTBLUE)){

			isTie = false;

			}
		}
		if (isTie) {
			message = pTie;
		}else {
			message = pWins;
		}
	
	
	switchPlayer(tileBtns);
	

	for (int i = 0; i < tileBtns.length; i++) {
			tileBtns[i].setText(message[i]);
			tileBtns[i].setTextFill(Color.WHITE);
			tileBtns[i].setDisable(true);
			
		}

		
	}
	/**
	 * Purpose: to clear the board. Called when reset button is pressed by user
	 * @param tileBtns - Array of buttons for the user to indicate what column to drop the token
	 * @param modArray - 2D Array of Circles representing the Connect Four board
	 * @param board - Board object representing the board
	 */
	public void clearBoard(Button[] tileBtns, Circle[][] modArray, Board board) {
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				modArray[i][j].setFill(Color.MIDNIGHTBLUE);
			
			}
		}
		for (int i = 0; i < tileBtns.length; i++) {
			tileBtns[i].setText(Integer.toString(i+1));
			tileBtns[i].setTextFill(Color.BLACK);
			tileBtns[i].setDisable(false);
		
	}
		switchPlayer(tileBtns);

	}
}