import java.util.*;
public class NodePath implements Iterable<Integer[]> {
    //Instance variables
    private ArrayDeque<Integer[]> nodes;

    //Constructor
    public NodePath() {
	nodes = new ArrayDeque<Integer[]>();
    }

    //getlast
    public Integer[] getEnd(){
	return nodes.getFirst();
    }
    
    //add
    public void add(Integer[] coords) {
	nodes.add(coords);
    }

    public void add(int row, int col) {
	Integer[] coords = {row, col};
	nodes.add(coords);
    }

    //iterator
    public Iterator<Integer[]> iterator() {
	return nodes.iterator();
    }
}
