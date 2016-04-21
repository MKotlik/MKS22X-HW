public class BSTree<T extends Comparable<T>> {
    //do not have to generatize node because it is an inner class
    public class Node {
	private T data;
	private Node left;
	private Node right;
	
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

	//OUTER methods here are wrapper methods for the root
	public getHeight(){
	    //call the root's methods
	    //check for empty first!
	    return root.height();
	}
	
	public void add(T value){
	    //check for empty before you do things with root.
	}
	public String toString(){
	    //check for empty before you do things with root.
	    return "";
	}
	public boolean contains(T value){
	    //check for empty before you do things with root.
	    return false;
	}
    }
}
