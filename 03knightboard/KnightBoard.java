public class KnightBoard {
    private String name;
    private int[][] board;
    private int size;
    
    public KnightBoard(int size) {
	name = "KOTLIK,MIKHAIL";
	this.size = size;
	board = new int[size][size];
    }

    public String name() {
	return name;
    }

    public boolean solve() {
	return true;
    }

    public String toString() {
	String boardStr = "";
	for (int row = 0; row < size; row++) {
	    String rowStr = "";
	    for (int col = 0; col < size; col++) {
		rowStr += board[row][col] + " ";
	    }
	    boardStr += rowStr + "\n";
	}
	return boardStr;
    }

    public void printSolution() {
	System.out.println("Eureka!");
    }
    
}
