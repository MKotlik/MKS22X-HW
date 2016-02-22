public class DriverQ {
	public static void main(String[]args) {
		QueenBoard b1;
		if (args.length > 0) {
			b1 = new QueenBoard(Integer.parseInt(args[0]));
		} else {
			b1 = new QueenBoard(8);
		}
		System.out.println("Name: " + b1.name());
		System.out.println("Starting view:");
		System.out.println(b1);
		System.out.println("Solved?: " + b1.solve());
		System.out.println("Result:");
		System.out.println(b1);
		System.out.println("Formatted Result:");
		b1.printSolution();
	}

}