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
	System.out.println(cowField.countSolutions() + ",6,KOTLIK,MIKHAIL");
	/*
	System.out.println("Initial:\n" + cowField);
	System.out.println("Solving:");
	System.out.println(cowField.countSolutions());
	System.out.println(cowField);
	*/
    }

    //Variables
    private static boolean DEBUG = false;
    private String fileName;
    private boolean readSuccess;
    private int[][] pasture0;
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
		    pasture0 = new int[rows][cols];
		    pasture1 = new int[rows][cols];
		} else if (ind >= 2 && ind <= rows + 1) { //map
		    for (int col = 0; col < cols; col++) {
			//System.out.println("Ind: " + ind + " Col: " + col);
			if (line.charAt(col) == '.') {
			    pasture0[ind-2][col] = 0;
			} else {
			    pasture0[ind-2][col] = -1;
			}
		    }
		} else { //last line
		    startR = lineReader.nextInt() - 1;
		    startC = lineReader.nextInt() - 1;
		    endR = lineReader.nextInt() - 1;
		    endC = lineReader.nextInt() - 1;
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

    //Output
    public String toString() {
	String pastureStr = "";
	for (int row = 0; row < rows; row++) {
	    String rowStr = "";
	    for (int col = 0; col < cols; col++) {
		if (timeLimit % 2 == 0) {
		    rowStr += pasture0[row][col] + "\t";
		} else {
		    rowStr += pasture1[row][col] + "\t";
		}
	    }
	    pastureStr += rowStr + "\n";
	}
	return pastureStr;
    }

    public String toStringBoth() {
	//pasture0
	String pasture0Str = "pasture0:\n";
	for (int row = 0; row < rows; row++) {
	    String rowStr = "";
	    for (int col = 0; col < cols; col++) {
		rowStr += pasture0[row][col] + "\t";
	    }
	    pasture0Str += rowStr + "\n";
	}
	//pasture1
	String pasture1Str = "pasture1:\n";
	for (int row = 0; row < rows; row++) {
	    String rowStr = "";
	    for (int col = 0; col < cols; col++) {
		rowStr += pasture1[row][col] + "\t";
	    }
	    pasture1Str += rowStr + "\n";
	}
	return pasture0Str + pasture1Str;
    }

    //Solution
    public int countSolutions() {
	int time;
	for (time = 0; time <= timeLimit; time++) {
	    solve(time % 2, time);
	    printDebug(toStringBoth());
	}
	if ((time - 1) % 2 == 0) {
	    return pasture0[endR][endC];
	} else {
	    return pasture1[endR][endC];
	}
    }

    private void solve(int boardNum, int time) {
	int[][] prevBoard;
	int[][] nextBoard;
	if (time == 0) {
	    pasture0[startR][startC] = 1;
	} else {
	    if (boardNum == 0) {
		prevBoard = pasture1;
		nextBoard = pasture0;
	    } else {
		prevBoard = pasture0;
		nextBoard = pasture1;
	    }
	    for (int r = 0; r < rows; r++) {
		for (int c = 0; c < cols; c++) {
		    if (prevBoard[r][c] != 0 && prevBoard[r][c] != -1) {
			nextBoard[r][c] = 0;
		    } else if (prevBoard[r][c] == 0) {
			nextBoard[r][c] = sumNeighbors(r, c, boardNum);
		    } else if (prevBoard[r][c] == -1) {
			nextBoard[r][c] = -1;
		    }
		}
	    }
	}
    }

    private int sumNeighbors(int row, int col, int boardNum) {
	int[][] prevBoard;
	if (boardNum == 0) {
	    prevBoard = pasture1;
	} else {
	    prevBoard = pasture0;
	}
	int sum = 0;
	if (isInBounds(row, col - 1) && prevBoard[row][col-1] != -1) {
	    sum += prevBoard[row][col-1];
	}
	if (isInBounds(row, col + 1) && prevBoard[row][col+1] != -1) {
	    sum += prevBoard[row][col+1];
	}
	if (isInBounds(row + 1, col) && prevBoard[row+1][col] != -1) {
	    sum += prevBoard[row+1][col];
	}
	if (isInBounds(row - 1, col) && prevBoard[row-1][col] != -1) {
	    sum += prevBoard[row-1][col];
	}
	return sum;
    }

    private boolean isInBounds(int row, int col) {
	return (row >= 0 && row < rows && col >= 0 && col < cols);
    }

    private void printDebug(String text) {
	if (DEBUG) {
	    System.out.println(text);
	}
    }
}
