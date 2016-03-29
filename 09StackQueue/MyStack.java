import java.util.*;
public class MyStack<T> implements Iterable<T>{
    //Variables
    private MyLinkedList<T> store;

    //Constructors
    public MyStack() {
	store = new MyLinkedList<T>();
    }

    //Setters

    /**
     * Adds the given item to the top of the stack.
     */
    public void push(T item) {
	store.add(0, item);
    }

    //Getters
    
    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T pop() throws NoSuchElementException {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	} else {
	    T target = store.get(0);
	    store.remove(0);
	    return target;
	}
    }

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	} else {
	    return store.get(0);
	}
    }
    
    /**
     * Returns the number of items currently in the stack.
     */
    public int size() {
	return store.size();
    }

    /**
     * Returns whether the stack is empty or not.
     */
    public boolean isEmpty() {
	return size() == 0;
    }

    /**
     * Returns an iterator over this stack.
     */
    public Iterator<T> iterator() {
	return store.iterator();
    }

    /**
     * Returns a string representation of this stack.
     */
    public String toString() {
	return store.toString();
	/*
	if (isEmpty()) {
	    return "[]";
	} else {
	    String output = "[";
	    for (T el : store) {
		output += " " + el.toString() + ",";
	    }
	    return output.substring(0, output.length()-1) + " ]";
	}
	*/
    }
}
