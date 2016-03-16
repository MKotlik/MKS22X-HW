public class MyLinkedList {
    //Variables
    private LNode start;
    private int size;

    //Constructor
    public MyLinkedList() {
	start = new LNode();
	size = 1;
    }

    //Array Based Constructor
    public MyLinkedList(int[] srcArr) {
	if (srcArr.length > 0) {
	    start = new LNode(srcArr[0]);
	    size = 1;
	    for (int i = 1; i < srcArr.length; i++) {
		add(srcArr[i]);
	    }
	} else {
	    start = new LNode();
	    size = 1;
	}
    }

    //Accessors/Getters

    //public int size()
    //returns number of elements in list
    public int size() {
	return size;
    }

    //public int get(index)
    //Get value at specified index
    public int get(int index) throws IndexOutOfBoundsException{
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	} else {
	    LNode current = start;
	    for (int i = 1; i <= index; i++) {
		current = current.getNext();
	    }
	    return current.getData();
	}
    }

    //public int indexOf(value)
    //Returns index of specified value in linked list, -1 if not found
    public int indexOf(int value) {
	LNode current = start;
	for (int i = 0; i < size; i++) {
	    if (current.getData() == value) {
		return i;
	    } else {
		current = current.getNext();
	    }
	}
	return -1;
    }

    //public String toString()
    //Returns formatted String representation of list
    public String toString() {
	if (size <= 0) {
	    return "[]";
	}
	String listStr = "[";
	LNode current = start;
	for (int i = 0; i < size; i++) {
	    listStr += " " + current.getData() + ",";
	    current = current.getNext();
	}
	return listStr.substring(0, listStr.length()-1) + " ]";
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

    //public boolean add(index, value)
    //Inserts LNode with value at specified location in list
    public boolean add(int index, int value) throws IndexOutOfBoundsException {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	} else {
	    LNode current = start;
	    for (int i = 0; i < index; i++) {
		current = current.getNext();
	    }
	    if (index == 0) {
		start = new LNode(value, current);
	    } else {
		LNode tail = current.getNext();
		current.setNext(new LNode(value, tail));
	    }
	    size++;
	    return true;
	}
    }

    //public int set(index, newValue)
    //Sets value of LNode at specified location in list
    public int set(int index, int newValue) throws IndexOutOfBoundsException {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	} else {
	    LNode current = start;
	    for (int i = 0; i < index; i++) {
		current = current.getNext();
	    }
	    int oldData = current.getData();
	    current.setData(newValue);
	    return oldData;
	}
    }

    //public int remove(index)
    //Removes LNode at specified location in list
    public int remove(int index) throws IndexOutOfBoundsException {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	} else {
	    LNode current = start;
	    for (int i = 0; i < index - 1; i++) {
		current = current.getNext();
	    }
	    int oldValue;
	    LNode tail;
	    if (index == 0) {
		oldValue = current.getData();
		tail = current.getNext();
		start = tail;
	    } else {
		oldValue = current.getNext().getData();
		tail = current.getNext().getNext();
		current.setNext(tail);
	    }
	    size--;
	    return oldValue;
	}
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
