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

    public T getFirst() throws NoSuchElementException{
	if (size == 0) {
	    throw new NoSuchElementException();
	}
    }

    public T getLast() throws NoSuchElementException{
	if (size == 0) {
	    throw new NoSuchElementException();
	}
    }
    
    public T removeFirst() throws NoSuchElementException{
	if (size == 0) {
	    throw new NoSuchElementException();
	}
    }

    public T removeLast() throws NoSuchElementException{
	if (size == 0) {
	    throw new NoSuchElementException();
	}
    }

    
    public void addFirst(T value) {

    }

    public void addLast(T value) {

    }
}
