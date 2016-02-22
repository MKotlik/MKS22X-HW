import java.util.*;

public class LakeMaking {
    //Variables
    private static String fileName = "makelake.in";
    private String[][] lakeMap;
    private ArrayList<String> instructions;
    private int rows;
    private int cols;
    private int finalElevation;
    private int numInstructions;
    
    //Constructor

    //Input
    private boolean readFile() {
	try {
	    BufferedReader mainReader = new BufferedReader(new FileReader(fileName));
	    int ind = 0;
	    String line = null;
	    
	    while((line = BufferedReader.readLine()) != null) {
		if (ind = 0) {
		    
		}
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
