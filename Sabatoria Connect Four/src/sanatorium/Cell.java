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
	/**
	 * String representation of a cell
	 */
	@Override
	public String toString() {
		switch (state) {
		case P1:
			return "O";
		case P2:
			return "X";
		case EMPTY:
			return "-";
		default:
			return "-";
		}

}}
