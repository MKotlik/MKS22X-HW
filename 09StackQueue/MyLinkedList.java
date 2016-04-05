import java.util.*;
public class MyLinkedList<T> implements Iterable<T>{
    //Variables
    private boolean DEBUG = false;
    private LNode start;
    private LNode end;
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
	    throw new
		IndexOutOfBoundsException("Index: "+index+", Size: "+size);
	} else {
	    LNode current = start;
	    for (int i = 0; i < index; i++) {
		current = current.getNext();
	    }
	    return current.getData();
	}
    }

    //public int indexOf(value)
    //Returns index of specified value in linked list, -1 if not found
    public int indexOf(T value) {
	LNode current = start;
	for (int i = 0; i < size; i++) {
	    if (current.getData().equals(value)) {
		return i;
	    } else {
		current = current.getNext();
	    }
	}
	return -1;
    }

    //public MLIterator<T> iterator()
    //returns an MLIterator<T> over the list
    public MLIterator iterator() {
	return new MLIterator(this);
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
	    printDebug("i:"+i+", data: "+current.getData().toString());
	    listStr += " " + current.getData().toString() + ",";
	    current = current.getNext();
	}
	return listStr.substring(0, listStr.length()-1) + " ]";
    }

    public String toString(boolean showHeadTail) {
	if (showHeadTail) {
	    return toString() + "\tStart: " + start.getData().toString() +
		" End: " + end.getData().toString();
	} else {
	    return toString();
	}
    }

    public void printDebug(String out) {
	if (DEBUG) {
	    System.out.println(out);
	}
    }

    //Mutators/Setters

    //public boolean add(int value)
    //Adds LNode with value to end of linked list
    public boolean add(T data) {
	if (size == 0) {
	    start = new LNode(data, null, null);
	    end = start;
	    size = 1;
	    return true;
	} else {
	    end.setNext(new LNode(data, end, null));
	    end = end.getNext();
	    size++;
	    return true;
	}
    }

    //public boolean add(index, value)
    //Inserts LNode with value at specified location in list
    public boolean add(int index, T value) throws IndexOutOfBoundsException {
	if (index < 0 || index > size) {
	    throw new
		IndexOutOfBoundsException("Index: "+index+", Size: "+size);
	} else if (index == size) {
	    return add(value);
	} else {
	    LNode current = start;
	    for (int i = 0; i < index - 1; i++) {
		current = current.getNext();
	    }
	    if (index == 0) {
		start = new LNode(value, null, current);
	    } else {
		current.setNext(new LNode(value, current, current.getNext()));
	    }
	    size++;
	    return true;
	}
    }

    //public int set(index, newValue)
    //Sets value of LNode at specified location in list
    public T set(int index, T newValue) throws IndexOutOfBoundsException {
	if (index < 0 || index >= size) {
	    throw new
		IndexOutOfBoundsException("Index: "+index+", Size: "+size);
	} else {
	    LNode current = start;
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
	    throw new
		IndexOutOfBoundsException("Index: "+index+", Size: "+size);
	} else {
	    LNode current = start;
	    for (int i = 0; i < index; i++) {
		current = current.getNext();
	    }
	    T oldValue = current.getData();
	    if (index == 0) {
		if (index != size - 1) {
		    current.getNext().setPrev(null);
		}
		start = current.getNext();
	    } else if (index == size - 1) {
		current.getPrev().setNext(null);
	    } else {
		current.getPrev().setNext(current.getNext());
		current.getNext().setPrev(current.getPrev());
	    }
	    if (index == size-1) {
		end = current;
	    }
	    size--;
	    return oldValue;
	}
    }

    public class MLIterator implements Iterator<T> {
	//Variables
	private MyLinkedList<T> source;
	private LNode next;

	//Constructor
	public MLIterator(MyLinkedList<T> src) {
	    source = src;
	    if (source.size() != 0) {
		next = start;
	    } else {
		next = null;
	    }
	}
	public boolean hasNext() {
	    return next != null;
	}

	public T next() throws NoSuchElementException {
	    if (hasNext()) {
		T curData = next.getData();
		next = next.getNext();
		return curData;
	    } else {
		throw new NoSuchElementException();
	    }
	}

	public void remove() throws UnsupportedOperationException {
	    throw new UnsupportedOperationException();
	}
    }

    
    //LNode Inner Class
    private class LNode {
	//Variables
	private T data; //car, int value
	private LNode next; //cdr, LNode tail
	private LNode prev;
	
	//Constructors
	private LNode() {
	    data = null;
	    prev = null;
	    next = null;
	}

	private LNode(T data) {
	    this.data = data;
	    prev = null;
	    next = null;
	}

	private LNode(T data, LNode next) {
	    this.data = data;
	    prev = null;
	    this.next = next;
	}

	private LNode(T data, LNode prev, LNode next) {
	    this.data = data;
	    this.prev = prev;
	    this.next = next;
	}

	//Getters
	private T getData() {
	    return data;
	}

	private LNode getPrev() {
	    return prev;
	}

	private LNode getNext() {
	    return next;
	}

	//Setters
	private T setData(T newData) {
	    T orig = data;
	    data = newData;
	    return orig;
	}

	private LNode setPrev(LNode newNode) {
	    LNode orig = prev;
	    prev = newNode;
	    return orig;
	}

	private LNode setNext(LNode newNode) {
	    LNode orig = next;
	    next = newNode;
	    return orig;
	}
    }
}
