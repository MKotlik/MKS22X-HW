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
	    limit = end + 1;
	}
	for (i = start; i < limit; i++) {
	    newData[newInd] = data[i];
	    //System.out.println(Arrays.toString(newData) + " Ind: " + newInd + " i: " + i);
	    if (end < start && i == data.length-1) {
		i = -1;
		limit = end + 1;
	    }
	    newInd++;
	}
	data = newData;
	start = 0;
	end = newInd - 1;
    }

    public int size() {
	return size;
    }

    public boolean isEmpty() {
	return size == 0;
    }

    public String toStringOld() {
	if (size == 0) {
	    return "[]";
	}
	String retStr = "[";
	for (int i = 0; i < data.length; i++) {
	    retStr += data[i] + ", ";
	}
	return retStr.substring(0, retStr.length() - 2) + "]";
    }

    public String toString() {
	return Arrays.toString(data);
    }

    public String toStringDebug() {
	return toString() + " Size: " + size + " Start: " + start + " End: " + end;
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
	data[start] = null;
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
	data[end] = null;
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
	if (size > 0) {
	    if (start == 0) {
		start = data.length - 1;
	    } else {
		start--;
	    }
	}
	data[start] = value;
	size++;
    }

    public void addLast(T value) {
	if (size == data.length) {
	    grow();
	}
	if (size > 0) {
	    if (end == data.length - 1) {
		end = 0;
	    } else  {
		end++;
	    }
	}
	data[end] = value;
	size++;
    }
}
