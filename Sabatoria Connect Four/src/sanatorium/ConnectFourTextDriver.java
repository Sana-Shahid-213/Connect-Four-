package sanatorium;

import java.util.Arrays;
import java.util.Scanner;

public class ConnectFourTextDriver {

	public static void main(String[] args) {
		menu();
		Scanner in = new Scanner(System.in);
	
		String[][] boardArray2 = {{"O","O","O","O","O","O","O"},{"O","O","O","O","O","O","O"},{"O","O","O","O","O","O","O"},{"O","O","O","O","O","O","O"},{"O","O","O","O","O","O","O"},{"O","O","O","O","O","O","O"},{"O","O","O","O","O","O","O"}};

		for (int i = 0; i< boardArray2.length-1; i++ ) {
		System.out.println(Arrays.toString(boardArray2[1]));}

	}
	
	public static void menu() {
		
		System.out.println("Connect Four");
		System.out.println("--------------");
		System.out.println("                ");
		System.out.println("How to play: ");
		System.out.println("Decide what colour you would like to be");
		System.out.println("Enter the position of where you would like to drop your colour token ");
		System.out.println("Try to get 4 of your coloured tokens in a row, either horizontally, vertacally or diagonally");
		System.out.println("                ");
	}

}


