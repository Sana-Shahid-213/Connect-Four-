package sanatorium;

import java.util.Arrays;
import java.util.Scanner;

public class ConnectFourTextDriver {

	public static void main(String[] args) {
		menu();
		Scanner in = new Scanner(System.in);
		int column = 0;
		int row;
		boolean playerOneTurn = true;

		String[][] boardArray2 = { { "O", "O", "O", "O", "O", "O", "O" }, { "O", "O", "O", "O", "O", "O", "O" },
				{ "O", "O", "O", "O", "O", "O", "O" }, { "O", "O", "O", "O", "O", "O", "O" },
				{ "O", "O", "O", "O", "O", "O", "O" }, { "O", "O", "O", "O", "O", "O", "O" },
				{ "O", "O", "O", "O", "O", "O", "O" } };

		for (int i = 0; i < boardArray2.length - 1; i++) {
			System.out.println(Arrays.toString(boardArray2[i]));
		}

		System.out.println("                ");

		System.out.println("Enter the columm number (0-6):");
		column = in.nextInt();

		System.out.println("Enter the row number (0-5): ");
		row = in.nextInt();

		boardArray2[column][row] = "R";
		for (int i = 0; i < boardArray2.length - 1; i++) {
			System.out.println(Arrays.toString(boardArray2[i]));
		}

	}

	public static void menu() {

		System.out.println("Connect Four");
		System.out.println("--------------");
		System.out.println("                ");
		System.out.println("How to play: ");
		System.out.println("Decide what colour you would like to be");
		System.out.println("Enter the position of where you would like to drop your colour token ");
		System.out.println(
				"Try to get 4 of your coloured tokens in a row, either horizontally, vertacally or diagonally");
		System.out.println("Player 1 is Red represented by R");
		System.out.println("Player 2 is Yellow represented by Y");
		System.out.println("  ");
	}

}
