import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Silver {
    //Main
    public static void main(String[]args) {
	Silver cowField = new Silver();
	System.out.println(cowField);
    }

    //Variables
    private static boolean DEBUG = false;
    private String fileName;
    private boolean readSuccess;
    private int[][] pasture1;
    private int rows;
    private int cols;
    private int startR;
    private int startC;
    private int endR;
    private int endC;
    private int timeLimit;

    //Constructor
    public Silver(String fileName) {
	this.fileName = fileName;
	readFile();
    }

    public Silver() {
	this("ctravel.in");
    }

    //Input
    private void readFile() {
	try {
	    BufferedReader mainReader = new BufferedReader(new FileReader(fileName));
	    int ind = 1; //USACO treats first line as row 1
	    String line = null;
	    while((line = mainReader.readLine()) != null) {
		Scanner lineReader = new Scanner(line);
		if (ind == 1) {
		    rows = lineReader.nextInt();
		    cols = lineReader.nextInt();
		    timeLimit = lineReader.nextInt();
		    pasture1 = new int[rows][cols];
		} else if (ind >= 2 && ind <= rows + 1) { //map
		    for (int col = 0; col < cols; col++) {
			//System.out.println("Ind: " + ind + " Col: " + col);
			if (line.charAt(col) == '.') {
			    pasture1[ind-2][col] = 0;
			} else {
			    pasture1[ind-2][col] = -1;
			}
		    }
		} else { //last line
		    startR = lineReader.nextInt();
		    startC = lineReader.nextInt();
		    endR = lineReader.nextInt();
		    endC = lineReader.nextInt();
		}
		ind++;
	    }
	    readSuccess = true;
	} catch(FileNotFoundException e) {
	    System.out.println("ERROR: Couldn't open file " + fileName);
	    readSuccess = false;
	} catch(IOException e) {
	    System.out.println("ERROR: Couldn't read file " + fileName);
	    readSuccess = false;
	}
    }

    public String toString() {
	String pastureStr = "";
	for (int row = 0; row < rows; row++) {
	    String rowStr = "";
	    for (int col = 0; col < cols; col++) {
		rowStr += pasture1[row][col] + "\t";
	    }
	    pastureStr += rowStr + "\n";
	}
	return pastureStr;
    }
}
