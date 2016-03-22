public class MyLinkedList<T> {
    //Variables
    private LNode<T> start;
    private LNode<T> end;
    private int size;

    //Constructor
    public MyLinkedList() {
	start = null;
	end = null;
	size = 0;
    }

    //Array Based Constructor
    /*
    public MyLinkedList(int[] srcArr) {
	if (srcArr.length > 0) {
	    start = new LNode<T>(new Integer(srcArr[0]));
	    end = start;
	    size = 1;
	    for (int i = 1; i < srcArr.length; i++) {
		add(srcArr[i]);
	    }
	} else {
	    start = new LNode<Integer>();
	    end = start;
	    size = 1;
	}
    }
    */

    //Accessors/Getters

    //public int size()
    //returns number of elements in list
    public int size() {
	return size;
    }

    //public int get(index)
    //Get value at specified index
    public T get(int index) throws IndexOutOfBoundsException{
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	} else {
	    LNode<T> current = start;
	    for (int i = 1; i <= index; i++) {
		current = current.getNext();
	    }
	    return current.getData();
	}
    }

    //public int indexOf(value)
    //Returns index of specified value in linked list, -1 if not found
    public int indexOf(T value) {
	LNode<T> current = start;
	for (int i = 0; i < size; i++) {
	    if (current.getData().equals(value)) {
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
	LNode<T> current = start;
	for (int i = 0; i < size; i++) {
	    listStr += " " + current.getData().toString() + ",";
	    current = current.getNext();
	}
	return listStr.substring(0, listStr.length()-1) + " ]";
    }

    //Mutators/Setters

    //public boolean add(int value)
    //Adds LNode with value to end of linked list
    public boolean add(T data) {
	if (size == 0) {
	    start = new LNode<T>(data);
	    end = start;
	    size = 1;
	    return true;
	} else {
	    end.setNext(new LNode<T>(data));
	    end = end.getNext();
	    size++;
	    return true;
	}
    }

    //public boolean add(index, value)
    //Inserts LNode with value at specified location in list
    public boolean add(int index, T value) throws IndexOutOfBoundsException {
	if (index < 0 || index > size) {
	    throw new IndexOutOfBoundsException();
	} else if (index == size) {
	    return add(value);
	} else {
	    LNode<T> current = start;
	    for (int i = 0; i < index; i++) {
		current = current.getNext();
	    }
	    current = new LNode<T>(value, current);
	    size++;
	    return true;
	}
    }

    //public int set(index, newValue)
    //Sets value of LNode at specified location in list
    public T set(int index, T newValue) throws IndexOutOfBoundsException {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	} else {
	    LNode<T> current = start;
	    for (int i = 0; i < index; i++) {
		current = current.getNext();
	    }
	    T oldData = current.getData();
	    current.setData(newValue);
	    return oldData;
	}
    }

    //public int remove(index)
    //Removes LNode at specified location in list
    public T remove(int index) throws IndexOutOfBoundsException {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	} else {
	    LNode<T> current = start;
	    for (int i = 0; i < index - 1; i++) {
		current = current.getNext();
	    }
	    T oldValue;
	    LNode<T> tail;
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
    private class LNode<T> {
	//Variables
	private T data; //car, int value
	private LNode<T> next; //cdr, LNode tail
	
	//Constructors
	private LNode() {
	    data = null;
	    next = null;
	}

	private LNode(T data) {
	    this.data = data;
	    next = null;
	}

	private LNode(T data, LNode<T> next) {
	    this.data = data;
	    this.next = next;
	}

	//Getters
	private T getData() {
	    return data;
	}

	private LNode<T> getNext() {
	    return next;
	}

	//Setters
	private T setData(T newData) {
	    T orig = data;
	    data = newData;
	    return orig;
	}

	private LNode<T> setNext(LNode<T> newNode) {
	    LNode<T> orig = next;
	    next = newNode;
	    return orig;
	}
    }
}
