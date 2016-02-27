public class Driver05{

    public static void main(String[]args){
		//My testing
		Maze m = new Maze("data1.dat",false);
		m.clearTerminal();
		System.out.println(m.toString());
		
		/*
        Maze f;
        f = new Maze("data1.dat",true);//true animates the maze.
        
        f.clearTerminal();
        f.solve();

        f.clearTerminal();
        System.out.println(f);
		*/
    }
}