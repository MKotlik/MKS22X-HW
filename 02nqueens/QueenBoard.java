public class QueenBoard implements hw02 {
	private int[][] board;
	private int size;
	private String name;
	private static boolean DEBUG = false;
	
	public QueenBoard(int size) {
		this.size = size;
		board = new int[size][size];
		name = "KOTLIK,MIKHAIL";
	}
	
	public String name() {
		return name;
	}
	
	public boolean solve() {
		return solveH(0);
	}
	
	private boolean solveH(int col) {
		if (col >= size) return true; //All queens placed if last column reached
		for (int row = 0; row < size; row++) { //Loop through rows of given col
			if (addQueen(row, col)) { //Check if queen can be added at this spot
				return solveH(col + 1); //If added, move to next col
			} else {
				removeQueen(row, col); //Else, remove queen & try a different row
			}
		}
		if (col > 0) { //If no queens can be added in this col, but not first col
			return solveH(col - 1); //Backtrack to previous col
		} else {
			return false; //Else, unsolvable if first col, return false
		}
	}
	
	public boolean addQueen(int row, int col){
		if(board[row][col] != 0){
			return false;
		}
		board[row][col] = 1;
		int offset = 1;
		while(col+offset < board[row].length){
			board[row][col+offset]--;
			if(row - offset >= 0){
				board[row-offset][col+offset]--;
			}
			if(row + offset < board.length){
				board[row+offset][col+offset]--;
			}
			offset++;
		}
		return true;
    }

    public boolean removeQueen(int row, int col){
		if(board[row][col] != 1){
			return false;
		}
		board[row][col] = 0;
		int offset = 1;
		while(col+offset < board[row].length){
			board[row][col+offset]++;
			if(row - offset >= 0){
				board[row-offset][col+offset]++;
			}
			if(row + offset < board.length){
				board[row+offset][col+offset]++;
			}
			offset++;
		}
		return true;
    }
	
	public String toString() {
		String boardStr = "";
		for (int row = 0; row < size; row++) {
			String rowStr = "";
			for (int col = 0; col < size; col++) {
				rowStr += board[row][col] + "\t";
			}
			boardStr += rowStr + "\n";
		}
		return boardStr;
    }
	
	public void printSolution() {
		String boardStr = "";
		for (int row = 0; row < size; row++) {
			String rowStr = "";
			for (int col = 0; col < size; col++) {
				if (board[row][col] == 1) {
					rowStr += "Q";
				} else {
					rowStr += "_";
				}
				rowStr += " ";
			}
			boardStr += rowStr + "\n";
		}
		System.out.println(boardStr);
	}
	
	private void debug(String output) {
		if (DEBUG) System.out.println(output);
	}
}