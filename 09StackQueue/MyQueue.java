import java.util.*;
public class MyQueue<T> implements Iterable<T>{
    //Variables
    private MyLinkedList<T> store;

    //Constructors
    public MyQueue() {
	store = new MyLinkedList<T>();
    }

    //Setters
     /**
     * Adds the given item to the rear of the queue.
     */
    public void enqueue(T item) {
	store.add(item);
    }

    //Getters
    /**
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T dequeue() throws NoSuchElementException {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	} else {
	    T target = store.get(0);
	    store.remove(0);
	    return target;
	}
    }

    /**
     * Returns the front item from the queue without popping it.
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
     * Returns the number of items currently in the queue.
     */
    public int size() {
	return store.size();
    }
    

    /**
     * Returns whether the queue is empty or not.
     */
    public boolean isEmpty() {
	return size() == 0;
    }

    /**
     * Returns an iterator over the queue.
     */
    public Iterator<T> iterator() {
	return store.iterator();
    }

    /**
     * Returns a string representation of this queue.
     */
    public String toString() {
	return store.toString();
	/*
	if (isEmpty()) {
	    return "[]";
	} else {
	    String output = "";
	    for (T el : store) {
		output += " " + el.toString() + ",";
	    }
	    return output.substring(0, output.length()-1) + " ]";
	}
	*/
    }
}
