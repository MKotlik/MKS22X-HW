import java.util.*;
public class FrontierStack<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/

    //Instance variables
    private Stack<T> nodes;

    //Constructor
    public FrontierStack() {
	nodes = new Stack<T>();
    }

    //add
    public void add(T element) {
	nodes.push(element);
    }

    //next
    public T next() throws NoSuchElementException {
	if (nodes.empty()) {
	    throw new NoSuchElementException();
	}
	return nodes.pop();
    }
   
    //hasNext
    public boolean hasNext() {
	return !nodes.empty();
    }

    //iterator
    public Iterator<T> iterator() {
	return nodes.iterator();
    }
}
