public class Node {
    //Instance variables
    private int row;
    private int col;
    private Node prev;

    //Constructors
    public Node(int row, int col, Node prev) {
	this(row,col);
	this.prev = prev;
    }

    public Node(int row, int col) {
	this.row = row;
	this.col = col;
    }

    //Accessors
    
    public int getRow() {
	return row;
    }

    public int getCol() {
	return col;
    }

    public Node getPrev() {
	return prev;
    }

    public String toString() {
	return "[" + row + ", " + col + "]";
    }
}
