public class BSTree<T extends Comparable<T>> {
    //do not have to generatize node because it is an inner class
    public class Node {
	//Instance variables
	private T data;
	private Node left;
	private Node right;

<<<<<<< HEAD
	//constructor
	public Node(T newData) {
	    data = newData;
=======
	//Constructor
	public Node(T newData) {
	    data = newData;
	    left = null;
	    right = null;
>>>>>>> 0dede361f5e33f5b36739e8f76fbc1cdf8d4a62f
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

<<<<<<< HEAD
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
=======
	/*
	//OUTER methods here are wrapper methods for the root
	public getHeight(){
	    //call the root's methods
	    //check for empty first!
	    return root.height();
>>>>>>> 0dede361f5e33f5b36739e8f76fbc1cdf8d4a62f
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

	*/
    }
}
