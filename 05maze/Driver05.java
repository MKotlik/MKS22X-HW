public class Driver05{

    public static void main(String[]args){
		Maze m;
		//Driver takes file and animation arguments
		if (args.length == 2) {
			boolean ani;
			if (args[1].equals("true")) {
				ani = true;
			} else {
				ani = false;
			}
			m = new Maze(args[0], ani);
		} else {
			m = new Maze("data1.dat",true);
		}
		
        m.clearTerminal();
        m.solve();
		
        m.clearTerminal();
        System.out.println(m);
    }
}