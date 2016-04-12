public class NodeOut {
    //Instance variables
    private int size;
    private int row;
    private int col;
    private Node prev;

    //Constructors
    public Node(int row, int col, Node prev) {
	this(row,col);
	this.prev = prev;
	size = prev.getSize() + 1;
    }

    public Node(int row, int col) {
	this.row = row;
	this.col = col;
	size = 1;
    }

    //Accessors

    public int getSize() {
	return size;
    }
    
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
