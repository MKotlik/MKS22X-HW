public class DriverK {
    public static void main(String[]args) {
	KnightBoard mBoard = new KnightBoard(4);
	System.out.println(mBoard.name());
	System.out.println(mBoard.toString());
	mBoard.printSolution();
    }
}
