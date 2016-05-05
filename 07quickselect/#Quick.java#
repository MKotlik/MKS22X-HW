import java.util.Arrays;
import java.util.Random;
public class Quick {
    //possible command call:
    //java Quick
    //java Quick new/old/default
    //java Quick new/old/default small/large/huge [verify] [print]
    //java Quick size <some num> [verify]
    
    public static void main(String[]args) {
	Random randGen = new Random();
	int[] largeTest;
	int[] comparisonArr;
	boolean verify;
	boolean large;
	boolean sizeOption;
	boolean print;
	if (args.length > 0) {
	    if (args.length > 1) {
		if (args[1].equalsIgnoreCase("large")) {
		    largeTest = new int[1000000]; //1 million element array
		} else if (args[1].equalsIgnoreCase("huge")) {
		    largeTest = new int[4000000]; //4 million element array
		} else {
		    largeTest = new int[100]; //100 element array
		}
	    } else {
		largeTest = new int[1000000]; //1 million element array
	    }
	    if (args.length > 2 && args[2].equalsIgnoreCase("verify")) {
		comparisonArr = new int[largeTest.length];
	    } else {
		comparisonArr = new int[2];
	    }
	    for (int i = 0; i < largeTest.length; i++) {
		//largeTest[i] = randGen.nextInt(); //should be a random int from min to max
		largeTest[i] = randGen.nextInt(4); //random int from 0 to 3 inclusive
		//Ints from -50,000 to 50,000
		if (args.length > 2 && args[2].equalsIgnoreCase("verify")) {
		    comparisonArr[i] = largeTest[i];
		}
	    }
	    if (args.length == 4 && args[3].equalsIgnoreCase("print") ||
		args.length == 3 && args[2].equalsIgnoreCase("print")) {
		System.out.println("===Original Array===");
		System.out.println(Arrays.toString(largeTest));
	    }
	    if (args[0].equalsIgnoreCase("new")) {
		quickSort(largeTest);
	    } else if (args[0].equalsIgnoreCase("old")) {
		quickSortOld(largeTest);
	    } else {
		Arrays.sort(largeTest);
	    }
	    if (args.length > 2 && args[2].equalsIgnoreCase("verify")) {
		Arrays.sort(comparisonArr);
	    }	
	    if (args.length == 4 && args[3].equalsIgnoreCase("print") ||
		(args.length == 3 && args[2].equalsIgnoreCase("print"))) {
		System.out.println("===Sorted Array===");
		System.out.println(Arrays.toString(largeTest));
	    }
	    if (args.length > 2 && args[2].equalsIgnoreCase("verify")) {
		System.out.println("Sorted correctly: " + Arrays.equals(largeTest, comparisonArr));
	    }	
	} else {
	    //Sort Tests
	    
	    int[] test1 = {};
	    System.out.println(Arrays.toString(test1));
	    quickSort(test1);
	    System.out.println(Arrays.toString(test1));
	    
	    int[] test2 = {-1};
	    System.out.println(Arrays.toString(test2));
	    quickSort(test2);
	    System.out.println(Arrays.toString(test2));
	    
	    int[] test3 = {2,-10};
	    System.out.println(Arrays.toString(test3));
	    quickSort(test3);
	    System.out.println(Arrays.toString(test3));
	    
	    int[] test4 = {10,-5,7,3,5,10};
	    System.out.println(Arrays.toString(test4));
	    quickSort(test4);
	    System.out.println(Arrays.toString(test4));
	    
	    int[] test5 = {10,-5,7,3,5,10,-1,-1,-2,-3,11,12,6,220,144,234,119,-1};
	    System.out.println(Arrays.toString(test5));
	    quickSort(test5);
	    System.out.println(Arrays.toString(test5));
	    
	//Select Tests
	/*
	int[] test1 = {};
	System.out.println(Arrays.toString(test1));
	System.out.println(quickselect(test1, 0));
	
	int[] test2 = {-1};
	System.out.println(Arrays.toString(test2));
	System.out.println(quickselect(test2, 0));
	
	int[] test3 = {2,-10};
	System.out.println(Arrays.toString(test3));
	System.out.println(quickselect(test3, 1));
	
	int[] test4 = {10,-5,7,3,5,10};
	System.out.println(Arrays.toString(test4));
	System.out.println(quickselect(test4, 3));
	
	int[] test5 = {10,-5,7,3,5,10,-1,-1,-2,-3,11,12,6,220,144,234,119,-1};
	System.out.println(Arrays.toString(test5));
	System.out.println(quickselect(test5, 8));
	*/
	
	//Partition Tests
	/*
	int[] test1 = {};
	System.out.println(Arrays.toString(test1));
	partition(test1, 0, test1.length - 1);
	System.out.println(Arrays.toString(test1));

	int[] test2 = {-1};
	System.out.println(Arrays.toString(test2));
	partition(test2, 0, test2.length - 1);
	System.out.println(Arrays.toString(test2));

	int[] test3 = {2,-10};
	System.out.println(Arrays.toString(test3));
	partition(test3, 0, test3.length - 1);
	System.out.println(Arrays.toString(test3));

	int[] test4 = {10,-5,7,3,5,10};
	System.out.println(Arrays.toString(test4));
	partition(test4, 0, test4.length - 1);
	System.out.println(Arrays.toString(test4));

	int[] test5 = {10,-5,7,3,5,10,-1,-1,-2,-3,11,12,6,220,144,234,119,-1};
	System.out.println(Arrays.toString(test5));
	System.out.println("Partition point: " + partition(test5, 0, test5.length - 1));
	System.out.println(Arrays.toString(test5));
	*/
	}
    }

    public static void quickSortOld(int[]data) {
	quickSortOld(data, 0, data.length-1);
    }

    public static void quickSort(int[]data) {
	quickSort(data, 0, data.length-1);
    }

    private static void quickSortOld(int[] data, int left, int right) {
	if (left < right) {
	    int pivot = partitionOld(data, left, right);
	    quickSortOld(data, left, pivot - 1);
	    quickSortOld(data, pivot + 1, right);
	}
    }

    private static void quickSort(int[] data, int left, int right) {
	if (left < right) {
	    int[] pivotIndices = partition(data, left, right);
	    quickSort(data, left, pivotIndices[0] - 1);
	    quickSort(data, pivotIndices[1] + 1, right);
	}
    }
    
    public static int quickselectOld(int[] data, int k) {
	if (data.length == 0) {
	    return 0;
	}
	return quickselectHOld(data, k, 0, data.length - 1);
    }

    public static int quickselect(int[] data, int k) {
	if (data.length == 0) {
	    return 0;
	}
	return quickselectH(data, k, 0, data.length - 1);
    }

    private static int quickselectHOld(int[] data, int k, int left, int right) {
	if (right == left) {
	    return data[right];
	}
	int pivotInd = partitionOld(data, left, right);
	if (pivotInd == k) {
	    return data[pivotInd];
	} else if (k < pivotInd) {
	    return quickselectHOld(data, k, left, pivotInd - 1);
	} else { //same as (k > pivotInd)
	    return quickselectHOld(data, k, pivotInd + 1, right);
	}
    }
    private static int quickselectH(int[] data, int k, int left, int right) {
	if (right == left) {
	    return data[right];
	}
	int[] pivotIndices = partition(data, left, right);
	if (pivotIndices[0] <= k && k <= pivotIndices[1]) {
	    return data[pivotIndices[0]];
	} else if (k < pivotIndices[0]) {
	    return quickselectH(data, k, left, pivotIndices[0] - 1);
	} else { //same as (k > pivotIndices[1])
	    return quickselectH(data, k, pivotIndices[1]  + 1, right);
	}
    }

    private static int partitionOld(int[] data, int leftInd, int rightInd) {
	if (data.length <= 1) {
	    return leftInd;
	}
	int pivotInd = (int)(Math.random() * (rightInd - leftInd + 1)) + leftInd; //+1 necessary to reach rightInd
	swap(data, pivotInd, rightInd);
	int swapInd = leftInd;
	for (int i = leftInd; i < rightInd; i++) {
	    if (data[i] < data[rightInd]) {
		swap(data, swapInd, i);
		swapInd++;
	    }
	}
	swap(data, swapInd, rightInd);
	return swapInd;
    }

    private static int[] partition(int[] data, int leftInd, int rightInd) {
	if (data.length <= 1) {
	    int[] retArray = {leftInd, leftInd};
	    return retArray;
	}
	int pivotInd = (int)(Math.random() * (rightInd - leftInd + 1)) + leftInd; //+1 necessary to reach rightInd
	swap(data, pivotInd, rightInd);
	int swapInd = leftInd;
	for (int i = leftInd; i < rightInd; i++) {
	    if (data[i] < data[rightInd]) {
		swap(data, swapInd, i);
		swapInd++;
	    }
	}
	swap(data, swapInd, rightInd);
	int leftPivot = swapInd;
	int rightPivot = swapInd;
	for (int i = swapInd + 1; i < rightInd; i++) {
	    if (data[i] == data[swapInd]) {
		swap(data, rightPivot + 1, i);
		rightPivot++;
	    }
	}
	int[] retArray = {swapInd, rightPivot};
	return retArray;
    }

    private static void swap(int[] data, int a, int b) {
	int swap = data[b];
	data[b] = data[a];
	data[a] = swap;
    }

    public static String name() {
	return "6,Kotlik,Mikhail";
    }	
    
}
