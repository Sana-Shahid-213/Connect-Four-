package sanatorium;

import java.util.Arrays;

public class ConnectFourTextDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] boardArray = {{'O','O','O','O','O','O'},{'O','O','O','O','O','O'},{'O','O','O','O','O','O'},{'O','O','O','O','O','O'},{'O','O','O','O','O','O'},{'O','O','O','O','O','O'},{'O','O','O','O','O','O'}};
		String[][] boardArray2 = {{"O","O","O","O","O","O","O"},{"O","O","O","O","O","O","O"},{"O","O","O","O","O","O","O"},{"O","O","O","O","O","O","O"},{"O","O","O","O","O","O","O"},{"O","O","O","O","O","O","O"},{"O","O","O","O","O","O","O"}};
		
		
		System.out.println("Connect Four");
		System.out.println("--------------");
		System.out.println("                ");
		for (int i = 0; i< boardArray2.length-1; i++ ) {
		System.out.println(Arrays.toString(boardArray2[1]));}
	}

}
