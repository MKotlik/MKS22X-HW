import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {
    //Global settings
    private static boolean prettyPrint = true;
    
    //Instance variables
    private int size;
    private T[] data;
    private boolean isMax;

    //Constructors
    public MyHeap() {
	this(true);
    }
    
    public MyHeap(T[] array) {
	this(array, true);
    }
    
    public MyHeap(boolean isMax) {
	size = 0;
	this.isMax = isMax;
	data = (T[]) new Comparable[10];
    }

    public MyHeap(T[] array, boolean isMax) {
	size = array.length;
	this.isMax = isMax;
	data = (T[]) new Comparable[array.length+1];
	System.arraycopy(array, 0, data, 1, array.length);
	heapify();
      }
    
    /**pushDown
       precondition: datas[k]'s children are valid heaps
       postconditions:-the element at index k has been 
       shifted to the correct spot.
       -data[k] and is a valid heap
    */
    private void pushDown(int k) {
	//first check of if is unnecessary, but just-in-case
	//check if two children
	int swapInd = -1;
	if (2*k <= size && 2*k+1 <= size) {
	    //check which is greater/smaller
	    if ((isMax && data[2*k].compareTo(data[2*k+1]) > 0) ||
		(!isMax && data[2*k].compareTo(data[2*k+1]) < 0)) {
		swapInd = 2*k;
	    } else {
		swapInd = 2*k+1;
	    }
	} else if (2*k <= size) { //only left child
	    swapInd = 2*k;
	} else { //only right child, WHICH SHOULDNT HAPPEN
	    swapInd = 2*k+1;
	}
	swap(k, swapInd);
	if ((2*swapInd <= size && ((isMax && data[swapInd].compareTo(data[2*swapInd]) < 0) ||
				   (!isMax && data[swapInd].compareTo(data[2*swapInd]) > 0))) ||
	     (2*swapInd+1 <= size && ((isMax && data[swapInd].compareTo(data[2*swapInd+1]) < 0) ||
				      (!isMax && data[swapInd].compareTo(data[2*swapInd+1]) > 0)))) {
	    pushDown(swapInd);
	}
    }
    
    private void pushUp(int k) {
	int indParent = k/2;
	swap(k, indParent);
	//System.out.println(toString());
	//check if indParent is not root, and if it's bigger/smaller than its parent
	if (indParent/2 > 0 && ((isMax && data[indParent].compareTo(data[indParent/2]) > 0) ||
				(!isMax && data[indParent].compareTo(data[indParent/2]) < 0))) {
	    pushUp(indParent);
	}
    }

    private void swap(int a, int b) {
	T swapSpace = data[b];
	data[b] = data[a];
	data[a] = swapSpace;
    }
    
    private void heapify() {
	//only heapify if at least 2 els
	if (size >= 2) {
	    //start at middle element and go backwards
	    for (int k = size/2; k > 0; k--) {
		if ((2*k <= size && ((isMax && data[k].compareTo(data[2*k]) < 0) ||
					   (!isMax && data[k].compareTo(data[2*k]) > 0))) ||
		    (2*k+1 <= size && ((isMax && data[k].compareTo(data[2*k+1]) < 0) ||
					     (!isMax && data[k].compareTo(data[2*k+1]) > 0)))) {
		    pushDown(k);
		}
	    }
	}
    }

    
    public T delete() throws NoSuchElementException {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	T remValue = data[1];
	data[1] = data[size];
	data[size] = null;
	size--;
	if ((2 <= size && ((isMax && data[1].compareTo(data[2]) < 0) ||
				   (!isMax && data[1].compareTo(data[2]) > 0))) ||
	     (3 <= size && ((isMax && data[1].compareTo(data[3]) < 0) ||
				      (!isMax && data[1].compareTo(data[3]) > 0)))) {
	    pushDown(1);
	}
	return remValue;
    }
    
    
    public void add(T x) {
	if (size >= data.length-1) doubleSize();
	//System.out.println(toString());
	data[size+1] = x;
	//System.out.println(toString());
	size++;
	if (size/2 > 0 && ((isMax && data[size].compareTo(data[size/2]) > 0) ||
			   (!isMax && data[size].compareTo(data[size/2]) < 0))) {
	    pushUp(size);
	}
    }
    
    private void doubleSize() {
	T[] largerArray = (T[]) new Comparable[2*size];
	System.arraycopy(data, 0, largerArray, 0, data.length);
	data = largerArray;
    }

    //Peek
    public T peek() throws NoSuchElementException {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return data[1];
    }
    
    public String toString() {
	if (prettyPrint) {
	    String output = "[";
	    for (int i = 1; i <= size; i++) {
		output += data[i].toString();
		//System.out.println("access");
		if (i+1 <= size) {
		    output += ", ";
		}
	    }
	    return output + "]";
	} else {
	    return Arrays.toString(data) + " " + size;
	}
    }

    //Size
    public int getSize() {
	return size;
    }

    //isEmpty
    public boolean isEmpty() {
	return size == 0;
    }

}
