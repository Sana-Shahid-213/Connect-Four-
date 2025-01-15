package sanatorium;

public class Board {
	

	private String board[][];
	private int rows;
	private int columns;
	
	
	public Board(int row, int column) {
		
		row = this.rows;
		column = this.columns;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				board[i][j] = "O"; // no color
			}
		
		
		
	}
	}
}
