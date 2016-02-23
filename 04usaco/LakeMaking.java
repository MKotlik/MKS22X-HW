import java.util.*;

public class LakeMaking {
    //Variables
    private static String fileName = "makelake.in";
    private int[][] lakeMap;
    private int[][] instructions;
    private int rows;
    private int cols;
    private int finElev;
    private int numInstrs;
    
    //Constructor

    //Input
    private boolean readFile() {
	try {
	    BufferedReader mainReader = new BufferedReader(new FileReader(fileName));
	    int ind = 0;
	    String line = null;
	    
	    while((line = BufferedReader.readLine()) != null) {
		Scanner lineReader = new Scanner(line);
		if (ind = 0) {
		    rows = lineReader.nextInt();
		    cols = lineReader.nextInt();
		    finElev = lineReader.nextInt();
		    numInstrs = lineReader.nextInt();
		    lakeMap = new int[rows][cols];
		    instructions = new int[numInstrs][3];
		} else if (ind > 0 && ind < rows + 1) {
		    for(int col = 0; col < cols; col++) {
			lakeMap[ind-1][col] = lineReader.nextInt();
		    }
		} else if (ind > rows
		ind++;
	    }
	} catch(FileNotFoundException e) {
	    System.out.println("ERROR: Couldn't open file " + fileName);
	} catch(IOException e) {
	    System.out.println("ERROR: Couldn't real file " + fileName);
	}
    }

    //Name

    //Print Solution

    //Solver

    //Helpers
}
