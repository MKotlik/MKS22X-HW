import java.util.*;
public class RunningMedian {
    //Global settings
    private static boolean prettyPrint = true;
    
    //Instance variables
    MyHeap<Integer> smallerVals; //max-heap for vals < median
    MyHeap<Integer> biggerVals; //min-heap for vals > median

    //Constructors
    public RunningMedian() {
	smallerVals = new MyHeap<Integer>(true);
	biggerVals = new MyHeap<Integer>(false);
    }

    //Accessors
    public double getMedian() throws NoSuchElementException {
	if (smallerVals.isEmpty()) {
	    throw new NoSuchElementException();
	}
	if (smallerVals.getSize() == biggerVals.getSize()) {
	    return (smallerVals.peek() + biggerVals.peek()) / 2.0;
	} else {
	    return smallerVals.peek();
	}
    }

    public String toString() {
	return smallerVals.toString() + " | " + biggerVals.toString();
    }

    //Mutators
    public void add(Integer x) {
	if (smallerVals.isEmpty() || x < getMedian()) {
	    smallerVals.add(x);
	    while (smallerVals.getSize() - biggerVals.getSize() > 1) {
		biggerVals.add(smallerVals.delete());
	    }
	} else {
	    biggerVals.add(x);
	    while (biggerVals.getSize() > smallerVals.getSize()) {
		smallerVals.add(biggerVals.delete());
	    }
	}
    }
}
