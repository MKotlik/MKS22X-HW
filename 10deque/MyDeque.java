import java.util.*;
public class MyDeque<T> {
    //generic array
    private T[] data;
    private int size;
    private int start;
    private int end;

    //suppress this ONE function from
    //having warnings.
    @SuppressWarnings("unchecked")	    
    public MyDeque(){
	//typecast object array to generic array
	data = (T[]) new Object[10];
	size = 0;
	start = 0;
	end = 0;
    }

    //suppress this ONE function from
    //having warnings.
    @SuppressWarnings("unchecked")
    private void grow() {
	T[] newData = (T[]) new Object[data.length * 2];
	int i;
	int limit;
	int newInd = 0;
	if (end < start) {
	    limit = data.length;
	} else {
	    limit = end;
	}
	for (i = start; i < limit; i++) {
	    newData[newInd] = data[i];
	    if (end < start && i == data.length-1) {
		i = 0;
		limit = end + 1;
	    }
	    newInd++;
	}
	data = newData;
    }

    public int size() {
	return size;
    }

    public String toString() {
	if (size == 0) {
	    return "[]";
	}
	String retStr = "[";
	for (int i = 0; i < data.length; i++) {
	    retStr += data[i] + ", ";
	}
	return retStr.substring(0, retStr.length() - 2) + "]";
    }

    public T getFirst() throws NoSuchElementException{
	if (size == 0) {
	    throw new NoSuchElementException();
	} else {
	    return data[start];
	}
	
    }

    public T getLast() throws NoSuchElementException{
	if (size == 0) {
	    throw new NoSuchElementException();
	} else {
	    return data[end];
	}
    }
    
    public T removeFirst() throws NoSuchElementException{
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	T oldValue = data[start];
	if (start == data.length - 1) {
	    start = 0;
	} else {
	    start++;
	}
	size--;
	return oldValue;
    }

    public T removeLast() throws NoSuchElementException{
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	T oldValue = data[end];
	if (end == 0) {
	    end = data.length - 1;
	} else {
	    end--;
	}
	size--;
	return oldValue;
    }

    
    public void addFirst(T value) {
	if (size == data.length) {
	    grow();
	}
	if (start == 0) {
	    start = data.length - 1;
	} else {
	    start--;
	}
	data[start] = value;
	size++;
    }

    public void addLast(T value) {
	if (size == data.length) {
	    grow();
	}
	if (end == data.length - 1) {
	    end = 0;
	} else  {
	    end++;
	}
	
	size++;
    }
}
