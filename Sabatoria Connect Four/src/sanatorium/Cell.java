package sanatorium;
/**
 * Purpose: Cell objects representing the status of board spaces (empty, occupied by colour)
 * Text representation in console while JavaFX graphics runs
 * @author Sana & Victoria
 * @date 20 January 2025
 */
public class Cell {

	private CellState state;
	
	/**
	 * Change Cell state
	 * @param cs Cell state
	 */
	public Cell(CellState cs) {
		state = cs;
	}
	
	/**
	 * Set Cell state to EMPTY
	 */
	public Cell() {
		state = CellState.EMPTY;
	}
	
	/**
	 * Set state of Cell
	 * @param cs
	 */
	public void setState(CellState cs) {
		state = cs;
	}
	
	/**
	 * Get state of Cell
	 * @return
	 */
	public CellState getState() {
		return state;
	}
	
	/**
	 * String representation of a cell, printing to console for visual representation
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
