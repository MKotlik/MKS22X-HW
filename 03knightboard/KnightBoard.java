public class KnightBoard {
    private String name;
    private int[][] board;
    private int cols;
	private int rows;
	private int initCol;
	private int initRow;
	private static boolean closed = false;
	private static boolean DEBUG = false;
    
    public KnightBoard(int cols, int rows) {
		name = "KOTLIK,MIKHAIL";
		this.cols = cols;
		this.rows = rows;
		board = new int[rows][cols];
    }

    public String name() {
		return name;
    }

    public boolean solve() {
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (closed) {
					initCol = col;
					initRow = row;
				}
				if (solveH(row, col, 1)) return true;
			}
		}
		return false;
    }
	
	public boolean solveH(int row, int col, int move) {
		if (move > cols * rows) {
			if (closed) {
				return row == initRow && col == initCol;
			} else {
				return true;
			}
		}
		if (! isOnBoard(row, col)) return false;
		if (board[row][col] != 0) return false;
		board[row][col] = move;
		debug(toString());
		if (solveH(row - 2, col + 1, move + 1)) {
			return true;
		} else if (solveH(row - 1, col + 2, move + 1)) {
			return true;
		} else if (solveH(row + 1, col + 2, move + 1)) {
			return true;
		} else if (solveH(row + 2, col + 1, move + 1)) {
			return true;
		} else if (solveH(row + 2, col - 1, move + 1)) {
			return true;
		} else if (solveH(row + 1, col - 2, move + 1)) {
			return true;
		} else if (solveH(row - 1, col - 2, move + 1)) {
			return true;
		} else if (solveH(row - 2, col - 1, move + 1)) {
			return true;
		}
		board[row][col] = 0;
		return false;
	}
	
	private boolean isOnBoard(int row, int col) {
		return row >= 0 && row < rows && col >= 0 && col < cols;
	}

    public String toString() {
		String boardStr = "";
		for (int row = 0; row < rows; row++) {
			String rowStr = "";
			for (int col = 0; col < cols; col++) {
				rowStr += board[row][col] + "\t";
			}
			boardStr += rowStr + "\n";
		}
		return boardStr;
    }

    public void printSolution() {
		System.out.println(toString());
    }
	
	private void debug(String output) {
		if (DEBUG) System.out.println(output);
	}
    
}
