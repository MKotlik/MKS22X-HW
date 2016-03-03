import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Bronze {
    //Main
    public static void main(String[]args) {
		if (DEBUG) {
			Bronze solver;
			if (args.length == 1) {
				solver = new Bronze(args[0]);
			} else {
				solver = new Bronze();
			}
			if (solver.isReadSuccess()) {
			solver.printLakeMap();
			System.out.println("--");
			solver.printInstructions();
			solver.solve();
			System.out.println("--");
			solver.printLakeMap();
			solver.printVolume();
			}
		} else {
			Bronze solver = new Bronze();
			if (solver.isReadSuccess()) {
				solver.solve();
				System.out.println(solver.getVolume() + ",6,KOTLIK,MIKHAIL");
			}
		}
	}
	
    //Variables
    private static boolean DEBUG = false;
    private String fileName;
    private boolean readSuccess;
    private int[][] lakeMap;
    private int[][] instructions;
    private int rows;
    private int cols;
    private int finElev;
    private int numInstrs;
    private int volume;
    
    //Constructor
	public Bronze() {
	    fileName = "makelake.in";
		readSuccess = readFile();
	}
	
    public Bronze(String fileName) {
		this.fileName = fileName;
		readSuccess = readFile();
	}

    //Input
    private boolean readFile() {
		try {
			BufferedReader mainReader = new BufferedReader(new FileReader(fileName));
			int ind = 0;
			String line = null;
			
			while((line = mainReader.readLine()) != null) {
				Scanner lineReader = new Scanner(line);
				if (ind == 0) {
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
				} else if (ind > rows && ind < (rows + numInstrs + 1)) {
					for (int i = 0; i < 3; i++) {
						instructions[ind - rows - 1][i] = lineReader.nextInt();
					}
				}
				ind++;
			}
			return true;
		} catch(FileNotFoundException e) {
			System.out.println("ERROR: Couldn't open file " + fileName);
			return false;
		} catch(IOException e) {
			System.out.println("ERROR: Couldn't real file " + fileName);
			return false;
		}
    }
	
	public boolean isReadSuccess() {
		return readSuccess;
	}

    //Print Methods
    public void printVolume() {
		System.out.println(volume);
    }
    
	public void printInstructions() {
		//System.out.println(Arrays.deepToString(instructions));
		System.out.println(toStringInstructions());
	}
	
	public void printLakeMap() {
		//System.out.println(Arrays.deepToString(lakeMap));
		System.out.println(toStringLakeMap());
	}
	
	public String toStringLakeMap2() {
		String mapStr = "";
		for (int row = 0; row < rows; row++) {
			String rowStr = "";
			for (int col = 0; col < cols; col++) {
				rowStr += lakeMap[row][col] + "\t";
			}
			mapStr += rowStr + "\n";
		}
		return mapStr;
	}
	
	public String toStringLakeMap() {
		int maxDigits = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (countDigits(lakeMap[row][col]) > maxDigits) {
					maxDigits = countDigits(lakeMap[row][col]);
				}
			}
		}
		String boardStr = "";
		for (int row = 0; row < rows; row++) {
			String rowStr = "";
			for (int col = 0; col < cols; col++) {
				int diff = maxDigits - countDigits(lakeMap[row][col]);
				if (diff > 0) {
					for (int i = 0; i < diff; i++) {
						rowStr += " ";
					}
				}
				rowStr += lakeMap[row][col] + " ";
			}
			boardStr += rowStr + "\n";
		}
		return boardStr;
	}
	
	public String toStringInstructions() {
		int maxDigits = 0;
		for (int ind = 0; ind < numInstrs; ind++) {
			for (int j = 0; j < 3; j++) {
				if (countDigits(instructions[ind][j]) > maxDigits) {
					maxDigits = countDigits(instructions[ind][j]);
				}
			}
		}
		String boardStr = "";
		for (int ind = 0; ind < numInstrs; ind++) {
			String rowStr = "";
			for (int j = 0; j < 3; j++) {
				int diff = maxDigits - countDigits(instructions[ind][j]);
				if (diff > 0) {
					for (int i = 0; i < diff; i++) {
						rowStr += " ";
					}
				}
				rowStr += instructions[ind][j] + " ";
			}
			boardStr += rowStr + "\n";
		}
		return boardStr;
	}
	
	private int countDigits(int num) {
		int count = 1; //Has to be at least one digit, and while loop won't count it
		while ((num = num / 10) != 0) {
			count++;
		}
		return count;
	}

    //Solver
	public void solve() {
		for (int i = 0; i < numInstrs; i++) {
			stomp(instructions[i]);
		}
		calculateVolume();
	}

    public int getVolume() {
		return volume;
    }

    //Helpers
	private void stomp(int[] instr) {
		//Get row, col, depth diff
		int row = instr[0] - 1;
		int col = instr[1] - 1;
		int diff = instr[2];
		//Calculate stomping limits (if available space is less than 3 by 3)
		int rowLimit; //inclusive
		int colLimit; //inclusive
		if (row + 2 < rows) {
		    rowLimit = row + 2;
		} else {
			rowLimit = rows - 1;
		}
		if (col + 2 < cols) {
			colLimit = col + 2;
		} else {
			colLimit = cols - 1;
		}
		//Find highest depth in stomping ground
		int maxValue = 0;
		for (int r = row; r <= rowLimit; r++) {
			for (int c = col; c <= colLimit; c++) {
				if (lakeMap[r][c] > maxValue) {
					maxValue = lakeMap[r][c];
				}
			}
		}
		//Stomp
		for (int r = row; r <= rowLimit; r++) {
			for (int c = col; c <= colLimit; c++) {
				if (lakeMap[r][c] > maxValue - diff) {
				    lakeMap[r][c] = maxValue - diff;
				}
			}
		}
	}

    private void calculateVolume() {
		int sumDepth = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (lakeMap[r][c] < finElev) {
					sumDepth += finElev - lakeMap[r][c];
				}
			}
		}
		volume = sumDepth*72*72; //Vol in in^3 = depth in in * 72in *72in
    }
}
