import java.util.*;
import java.io.*;

public class BetterMaze{
    
    private class Node{
	//Instance variables
	private int size;
	private int row;
	private int col;
	private Node prev;

	//Constructors
	public Node(int row, int col, Node prev) {
	    this(row,col);
	    this.prev = prev;
	    size = prev.getSize() + 1;
	}

	public Node(int row, int col) {
	    this.row = row;
	    this.col = col;
	    size = 1;
	}

	//Accessors

	public int getSize() {
	    return size;
	}
    
	public int getRow() {
	    return row;
	}

	public int getCol() {
	    return col;
	}

	public Node getPrev() {
	    return prev;
	}

	public String toString() {
	    return "[" + row + ", " + col + "]";
	}
    }

    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false

   /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
    **/
    public int[] solutionCoordinates(){
        /** IMPLEMENT THIS **/      
	if (solution == null) {
	    solution = new int[0];
	}
	return solution;
    }    


    /**initialize the frontier as a queue and call solve
    **/
    public boolean solveBFS(){  
        placesToGo = new FrontierQueue<Node>();
	return solve();
    }   


   /**initialize the frontier as a stack and call solve
    */ 
    public boolean solveDFS(){  
        placesToGo = new FrontierStack<Node>();
	return solve();
    }    

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of elements on the frontier.
    **/
    private boolean solve(){  
        if (startRow == -1) {
	    //solution = new int[0];
	    return false;
	}
	placesToGo.add(new Node(startRow, startCol));
	//maze[startRow][startCol] = '.';
	boolean solved = false;
	while (placesToGo.hasNext() && !solved) {
	    Node current = placesToGo.next();
	    solved = isEnd(current);
	    if (!solved) {
		processNext(current);
	    } else {
		makeSolution(current);
	    }
	    if (animate) {
		clearTerminal();
		System.out.println(toString());
	    }
	}
	return solved;
	/*
	if (solved) {
	    return true;
	} else {
	    solution = new int[0];
	    return false;
	}
	*/
    }

    private void processNext(Node cur) {
	maze[cur.getRow()][cur.getCol()] = '.';
	Integer[][] neighbors = new Integer[4][2];
	int curRow = cur.getRow();
	int curCol = cur.getCol();
	neighbors[0] = new Integer[] {curRow, curCol + 1};
	neighbors[1] = new Integer[] {curRow + 1, curCol};
	neighbors[2] = new Integer[] {curRow, curCol - 1};
	neighbors[3] = new Integer[] {curRow - 1, curCol};
	for (Integer[] arr : neighbors) {
	    if (canMove(maze[arr[0]][arr[1]])) {
		//maze[arr[0]][arr[1]] = '.';
		placesToGo.add(new Node(arr[0], arr[1], cur));
	    }
	}
	/*
	ArrayList<Integer[]> neighbors = new ArrayList<Integer[]>();
	int curRow = cur.getRow();
	int curCol = cur.getCol();
	neighbors.add({curRow, curCol + 1});
	neighbors.add({curRow + 1, curCol});
	neighbors.add({curRow, curCol - 1});
	neighbors.add({curRow - 1, curCol});
	for (Integer[] arr : neighbors) {
	    if (canMove(maze[arr.get(0)][arr.get(1)])) {
		maze[arr.get(0)][arr.get(1)] = '.';
		placesToGo.add(new Node(arr.get(0), arr.get(1), cur));
	    }
	}
	*/
    }

    private boolean isEnd(Node cur) {
	return 'E' == maze[cur.getRow()][cur.getCol()];
    }

    private boolean canMove(Node cur) {
	char curSyl = maze[cur.getRow()][cur.getCol()];
	return ' ' == curSyl || 'E' == curSyl;
    }

    private boolean canMove(char curSyl) {
	return ' ' == curSyl || 'E' == curSyl;
    }
     
   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){
	animate = b;
    }

    private void makeSolution(Node endpoint) {
	if (placesToGo == null) {
	    solution = new int[0];
	}
	solution = new int[endpoint.getSize() * 2];
	Node current = endpoint;
	int ind = solution.length - 1;
	while (current != null) {
	    solution[ind] = current.getRow();
	    ind--;
	    solution[ind] = current.getCol();
	    ind--;
	    current = current.getPrev();
	}
    }


    public BetterMaze(String filename){
	animate = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S'){
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }







    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    } 
    


       
    
    

}
