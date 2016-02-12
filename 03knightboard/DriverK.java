public class DriverK {
    public static void main(String[]args) {
		KnightBoard mBoard;
		if (args.length == 2) {
			int col = Integer.parseInt(args[0]);
			int row = Integer.parseInt(args[1]);
			mBoard = new KnightBoard(col, row);
		} else {
			mBoard = new KnightBoard(4, 4);
		}
		System.out.println("Name: " + mBoard.name());
		//System.out.println(mBoard.toString());
		//mBoard.printSolution();
		//System.out.println(mBoard);
		System.out.println("Solved: " + mBoard.solve());
		//System.out.println(mBoard);
		System.out.println("Board: ");
		mBoard.printSolution();
    }
}
