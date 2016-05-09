import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {
    //Instance variables
    private int size;
    private T[] data;
    private boolean isMax;

    //Constructors
    public MyHeap() {
	size = 0;
	data = null;
	isMax = true;
    }
    
    public MyHeap(T[] array) {
	size = array.length - 1;
	isMax = true;
	data = array;
	heapify();
    }
    
    /*
      public MyHeap(boolean isMax) {
      size = 0;
      this.isMax = isMax;
      data = null;
      }

      public MyHeap(T[] array, boolean isMax) {
      size = array.length;
      this.isMax = isMax;
      data = array;
      heapify();
      }
    */
    
    /**pushDown
       precondition: datas[k]'s children are valid heaps
       postconditions:-the element at index k has been 
       shifted to the correct spot.
       -data[k] and is a valid heap
    */
    private void pushDown(int k) {
	//for now, assume max_heap
	//first check of if is unnecessary, but just-in-case
	//check if two children
	int swapInd = -1;
	if (2*k < size && 2*k+1 < size) {
	    //check which is greater
	    if (data[2*k].compareTo(data[2*k+1]) >= 0) {
		swapInd = 2*k;
	    } else {
		swapInd = 2*k+1;
	    }
	} else if (2*k < size) { //only left child
	    swapInd = 2*k;
	} else { //only right child, WHICH SHOULDNT HAPPEN
	    swapInd = 2*k+1;
	}
	swap(k, swapInd);
	if ((2*swapInd < size && data[swapInd].compareTo(data[2*swapInd]) < 0) ||
	    (2*swapInd+1 < size && data[swapInd].compareTo(data[2*swapInd+1]) < 0)) {
	    pushDown(swapInd);
	}
	
    }
    
    private void pushUp(int k) {
	int indParent = k/2;
	swap(k, indParent);
	System.out.println(toString());
	//check if indParent is not root, and if it's bigger than its parent
	if (indParent/2 > 0 && data[indParent].compareTo(data[indParent/2]) > 0) {
	    pushUp(indParent);
	}
    }

    private void swap(int a, int b) {
	T swapSpace = data[b];
	data[b] = data[a];
	data[a] = swapSpace;
    }
    
    private void heapify() {
	//assume max-heap for now
	//only heapify if at least 2 els
	if (size >= 2) {
	    //start at middle element and go backwards
	    for (int k = (size-1)/2; k > 0; k--) {
		if ((2*k < size && data[k].compareTo(data[2*k]) < 0) ||
		    (2*k+1 < size && data[k].compareTo(data[2*k+1]) < 0)) {
		    pushDown(k);
		}
	    }
	}
    }

    /*
    public T delete() {

    }
    */
    
    public void add(T x) {
	if (size >= data.length-1) doubleSize();
	System.out.println(toString());
	data[size+1] = x;
	System.out.println(toString());
	size++;
	if (size/2 > 0 && data[size].compareTo(data[size/2]) > 0) {
	    pushUp(size);
	}
    }
    
    private void doubleSize() {
	T[] largerArray = (T[]) new Comparable[2*size];
	System.arraycopy(data, 0, largerArray, 0, data.length);
	data = largerArray;
    }
    
    public String toString() {
	return Arrays.toString(data) + " " + size;
    }

}
