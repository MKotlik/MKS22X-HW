import java.util.*;
public class NodePath implements Iterable<Integer[]> {
    //Instance variables
    private ArrayDeque<Integer[]> nodes;

    //Constructor
    public NodePath() {
	nodes = new ArrayDeque<Integer[]>();
    }

    public NodePath(int row, int col) {
	nodes = new ArrayDeque<Integer[]>();
	add(row,col);
    }

    public NodePath(NodePath prev, int row, int col) {
	nodes = prev.copyDeque();
	add(row,col);
    }

    //getlast
    public Integer[] getEnd(){
	return nodes.getFirst();
    }

    private ArrayDeque<Integer[]> copyDeque() {
	return nodes.clone();
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
