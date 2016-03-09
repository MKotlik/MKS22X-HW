import java.util.Arrays;
public class Quick {
    public static void main(String[]args) {
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
    }
    
    public static int quickselect(int[] data, int k) {
	return 0;
    }

    private static int quickselectH(int[] data, int k, int left, int right) {
	return 0;
    }

    private static int partition(int[] data, int leftInd, int rightInd) {
	if (data.length <= 1) {
	    return 0;
	}
	int pivotInd = (int)(Math.random() * (rightInd - leftInd)) + leftInd;
	int swapInd = leftInd;
	int swap = data[rightInd];
	data[rightInd] = data[pivotInd];
	data[pivotInd] = swap;
	for (int i = leftInd; i < rightInd; i++) {
	    if (data[i] < data[rightInd]) {
		swap = data[swapInd];
		data[swapInd] = data[i];	
		data[i] = swap;
		swapInd++;
	    }
	}
	swap = data[swapInd];
	data[swapInd] = data[rightInd];
	data[rightInd] = swap;
	return swapInd;
    }
	
    
}
