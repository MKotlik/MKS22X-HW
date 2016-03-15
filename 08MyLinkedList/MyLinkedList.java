public class MyLinkedList {
    //Variables
    private LNode start;
    private int size;

    //Constructor
    public MyLinkedList() {
	start = new LNode();
	size = 1;
    }

    //Constructor with size

    //Accessors/Getters

    //public int size()
    //returns number of elements in list
    public int size() {
	return size;
    }


    //public int get(index)
    //Get value at specified index
    public int get(int index) throws IndexOutOfBoundsException{
	if (index >= size) {
	    throw new IndexOutOfBoundsException();
	} else {
	    LNode current = start;
	    for (int i = 1; i <= index; i++) {
		current = current.getNext();
	    }
	    return current.getData();
	}
    }

    //Mutators/Setters

    //public boolean add(int value)
    //Adds LNode with value to end of linked list
    public boolean add(int value) {
	LNode current = start;
	for (int i = 1; i < size; i++) {
	    current = current.getNext();
	}
	current.setNext(new LNode(value));
	size++;
	return true;
    }

    //LNode Inner Class
    private class LNode {
	//Variables
	private int data; //car, int value
	private LNode next; //cdr, LNode tail
	
	//Constructors
	private LNode() {
	    data = 0;
	    next = null;
	}

	private LNode(int data) {
	    this.data = data;
	    next = null;
	}

	private LNode(int data, LNode next) {
	    this.data = data;
	    this.next = next;
	}

	//Getters
	private int getData() {
	    return data;
	}

	private LNode getNext() {
	    return next;
	}

	//Setters
	private int setData(int newData) {
	    int orig = data;
	    data = newData;
	    return orig;
	}

	private LNode setNext(LNode newNode) {
	    LNode orig = next;
	    next = newNode;
	    return orig;
	}
    }
}
