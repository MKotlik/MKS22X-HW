import java.util.*;

public class Driver {
    public static void main(String[]args) {
	BetterMaze puzzle = new BetterMaze("data1.dat");
	puzzle.setAnimate(true);
	puzzle.solveDFS();
	System.out.println(Arrays.toString(puzzle.solutionCoordinates()));
    }
}
