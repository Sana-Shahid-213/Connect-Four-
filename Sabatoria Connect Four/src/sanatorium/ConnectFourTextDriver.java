package sanatorium;

import java.util.Arrays;
import java.util.Scanner;

public class ConnectFourTextDriver {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int column = 0;
		int row;
		boolean playerOneTurn = true;
		// connect 4 board as a 2D Array
		String[][] boardArray2 = { { "O", "O", "O", "O", "O", "O", "O" }, { "O", "O", "O", "O", "O", "O", "O" },
				{ "O", "O", "O", "O", "O", "O", "O" }, { "O", "O", "O", "O", "O", "O", "O" },
				{ "O", "O", "O", "O", "O", "O", "O" }, { "O", "O", "O", "O", "O", "O", "O" },
				{ "O", "O", "O", "O", "O", "O", "O" } };
		
		
		//start time
		menu();
		printBoard(boardArray2);
		
		//for (int i = 0; i < boardArray2.length - 1; i++) {
			//System.out.println(Arrays.toString(boardArray2[i]));
		//}
		// prompting user input
		// System.out.println(" ");

		// System.out.println("\nEnter the column number (0-6):");
		// column = in.nextInt();
		// in.nextLine();
		/*
		 * System.out.println("Enter the row number (0-5): "); row = in.nextInt();
		 * 
		 * boardArray2[row][column] = "R"; for (int i = 0; i < boardArray2.length - 1;
		 * i++) { System.out.println(Arrays.toString(boardArray2[i])); }
		 */

		// implementing dropping

		// back up 1
		// drop(column, boardArray2);
		// printBoard(boardArray2);

		boolean gameOver = false;
		String currentPlayer = "R";

		// looping to let players alternate placing tokens
		while (gameOver == false) {
			System.out.println("\n" + currentPlayer + ", enter a column number from values 1-7");
			column = in.nextInt() - 1;
			in.nextLine();

			drop(column, currentPlayer, boardArray2);
			printBoard(boardArray2);
			checkRow(boardArray2, currentPlayer);
			checkColumn(boardArray2, currentPlayer);
			// switching player
			if (currentPlayer == "R") {
				currentPlayer = "Y";
			} else {
				currentPlayer = "R";
			}
		}

	}

	public static void drop(int column, String player, String[][] modArray) {
		boolean placed = false;

		for (int i = 6; i >= 0; i--) {

			// if the space is free, add a token
			if (modArray[i][column] == "O" && placed == false) {

				// System.out.println("it worked!");

				// depending on the current player, place a different colour of token
				if (player == "Y") {
					modArray[i][column] = "Y";

				} else if (player == "R") {
					modArray[i][column] = "R";

				}
				// System.out.println("column" + column + "row" + i);
				placed = true;
			}
		}
	}
	
	//checking horizontally for wins
	public static void checkRow(String[][] board, String colour) {
		//TODO 
		int fourInARow = 0;
		
		for (int i = board.length-1; i >= 0; i--) {
			for (String rowElement : board[i]) {
				//TODO check each element of the row, given a certain colour to search for.
				//this will be called right after a turn.
				//start a count to 4, reset the count if not. if 4 is reached then display win msg.
				
				if (rowElement == colour) {
					//System.out.println(rowElement + "GOTCHA");
					fourInARow++;
				}else {
					//System.out.println("BACK TO ZERO");
					fourInARow = 0;
					
				}if (fourInARow >= 4) {
					System.out.println("YIPPEE " + colour + " you WON horizontally");
					
				}
				
			}
			
			
			
			
		}
		}
		
	//checking vertically for wins
	public static void checkColumn(String[][] board, String colour) {
		//start at index of row, move up thru columns instead [row][column]
		//column is i, row 
		int fourInARow = 0;
		for (int i = board.length-1; i>=0; i--) {
			
			//move up through rows
			for (String[] row : board) {
			if (row[i] == colour) {
				fourInARow++;
			}else {
				fourInARow = 0;
			}if (fourInARow >= 4) {
				System.out.println("YIPPEE " + colour + " YOU WON VERTICALLY");
			}
			}
			
		}
	}
	
	public static void checkDiagonal(String[][] board, String colour ) {
		
	}
	
	
	// prints the updated board.
	public static void printBoard(String[][] board) {
		for (int j = 0; j < board.length; j++) {
			System.out.println(Arrays.toString(board[j]));
			// System.out.println("row " + j);
		}
	}

	//prints menu
	/**
	 * 
	 */
	public static void menu() {

		System.out.println("Connect Four");
		System.out.println("--------------");
		
		System.out.println("\nHow to play: ");
		System.out.println("Decide what colour you would like to be");
		System.out.println("Enter the position of where you would like to drop your colour token ");
		System.out.println(
				"Try to get 4 of your coloured tokens in a row, either horizontally, vertically or diagonally");
		System.out.println("Player 1 is Red represented by R");
		System.out.println("Player 2 is Yellow represented by Y\n");
	}

}
