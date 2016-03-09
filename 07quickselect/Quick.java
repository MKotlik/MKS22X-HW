import java.util.Arrays;
public class Quick {
    public static void main(String[]args) {
	//Select Tests
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

    public static int quickSort(int[]data) {
	quickSort(data, 0, data.length-1);
    }

    private static void quickSort(int[] data, int left, int right) {
	if (left < right) {
	    int pivot = partition(data, left, right);
	    quickSort(data, left, k - 1);
	    quickSort(data, k + 1, right);
	}
    }
    
    public static int quickselect(int[] data, int k) {
	if (data.length == 0) {
	    return 0;
	}
	return quickselectH(data, k, 0, data.length - 1);
    }

    private static int quickselectH(int[] data, int k, int left, int right) {
	if (right == left) {
	    return data[right];
	}
	int pivotInd = partition(data, left, right);
	if (pivotInd == k) {
	    return data[pivotInd];
	} else if (k < pivotInd) {
	    return quickselectH(data, k, left, pivotInd - 1);
	} else { //same as (k > pivotInd)
	    return quickselectH(data, k, pivotInd + 1, right);
	}
    }

    private static int partition(int[] data, int leftInd, int rightInd) {
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

    private static void swap(int[] data, int a, int b) {
	int swap = data[b];
	data[b] = data[a];
	data[a] = swap;
    }

    public static String name() {
	return "6,Kotlik,Mikhail";
    }	
    
}
