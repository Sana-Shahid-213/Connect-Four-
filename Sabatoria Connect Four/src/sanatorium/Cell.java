package sanatorium;

public class Cell {

		private CellState state;


		public Cell(CellState cs) {
			state = cs;
		}

		public Cell() {
			state = CellState.EMPTY;
		}

		
		public void setState(CellState cs) {
			state = cs;
		}


		public CellState getState() {
			return state;
		}

	}

