public class BSTree<T extends Comparable<T>> {
    //do not have to generatize node because it is an inner class
    public class Node {
	//Instance variables
	private T data;
	private Node left;
	private Node right;

	//Constructor
	public Node(T newData) {
	    data = newData;
	    left = null;
	    right = null;
	}
	
	//setters & getters
	public Node getLeft() {
	    return left;
	}

	public Node getRight() {
	    return right;
	}

	public T getData(){
	    return data;
	}

	public void setLeft(Node newLeft) {
	    left = newLeft;
	}

	public void setRight(Node newRight) {
	    right = newRight;
	}

	public void setData(T newData) {
	    data = newData;
	}

	//hasChildren
	public boolean hasChildren(){
	    return left != null || right != null;
	}

	public int height(){ 
	    if (! hasChildren()) {
		return 1;
	    } else if (left != null) {
		return left.height() + 1;
	    } else if (right != null) {
		return right.height() + 1;
	    } else {
		return Math.max(left.height(), right.height()) + 1;
	    }
	}

	public void add(T value){
	    if (data.compareTo(value) > 0) {
		if (left == null) {
		    left = new Node(value);
		} else {
		    left.add(value);
		}
	    } else {
		if (right == null) {
		    right = new Node(value);
		} else {
		    right.add(value);
		}
	    }
	}

	public String toString(){
	    String outStr = data.toString() + " ";
	    if (left != null) {
		outStr += left.toString() + " ";
	    } else {
		outStr += "_" + " ";
	    }
	    if (right != null) {
		outStr += right.toString() + " ";
	    } else {
		outStr += "_" + " ";
	    }
	    return outStr;
	}

	public boolean contains(T value){
	    if (! hasChildren()) {
		return data.equals(value);
	    } else if (left != null) {
		return left.contains(value) || data.equals(value);
	    } else if (right != null) {
		return right.contains(value) || data.equals(value);
	    } else {
		return right.contains(value) || left.contains(value) ||
		    data.equals(value);
	    }
	}
    }

    //BSTREE VARIABLES
    Node root;

    //BSTREE METHODS

    //constructor
    public BSTree() {
	root = null;
    }

    public BSTree(T value) {
	root = new Node(value);
    }

    //OUTER methods here are wrapper methods for the root
    public int getHeight(){
	if (root == null) {
	    return 0;
	}
	return root.height();
    }
    
    public void add(T value){
	if (root == null) {
	    root = new Node(value);
	} else {
	    root.add(value);
	}
    }

    public String toString(){
	if (root == null) {
	    return "";
	} else {
	    return root.toString();
	}
    }

    public boolean contains(T value){
	if (root == null) {
	    return false;
	} else {
	    return root.contains(value);
	}

    }
}
