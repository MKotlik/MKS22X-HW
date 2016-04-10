import java.util.*;
public class FrontierQueue<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/

    //Instance variables
    private ArrayDeque<T> paths;
    private Iterator<T> pathIterator;

    //Constructor
    public FrontierQueue() {
	paths = new ArrayDeque<T>();
	pathIterator = paths.iterator();
    }

    //add
    public void add(T element) {
	paths.add(element);
    }

    //next
    public T next() throws NoSuchElementException {
	//alternatively, I could just call pathIterator.next()
	//and pass or catch/rethrow the exception it throws
	//what is preferred in coding conventions?
	if (! hasNext()) {
	    throw new NoSuchElementException();
	}
	return pathIterator.next();
    }
   
    //hasNext
    public boolean hasNext() {
	return pathIterator.hasNext();
    }

    //iterator
    public Iterator<T> iterator() {
	return paths.iterator();
    }
}
