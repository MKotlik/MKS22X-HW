import java.util.*;
public class FrontierQueue<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/

    //Instance variables
    private ArrayDeque<T> nodes;

    //Constructor
    public FrontierQueue() {
	nodes = new ArrayDeque<T>();
    }

    //add
    public void add(T element) {
	nodes.add(element);
    }

    //next
    public T next() throws NoSuchElementException {
	if (nodes.isEmpty()) {
	    throw new NoSuchElementException();
	}
	return nodes.remove();
    }
   
    //hasNext
    public boolean hasNext() {
	return !nodes.isEmpty();
    }

    //iterator
    public Iterator<T> iterator() {
	return nodes.iterator();
    }
}
