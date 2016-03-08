public class Quick {
    public static int quickselect(int[] data, int k) {
	return 0;
    }

    private static int quickselectH(int[] data, int k, int left, int right) {
	return 0;
    }

    private static int partition(int[] data, int left, int right) {
	int pivotInd = (int)(Math.random() * (data.length + 1));
	int swapInd = left;
	int swap = data[right];
	data[right] = data[pivotInd];
	data[pivotInd] = swap;
	for (int i = left; i < right; i++) {
	    if (data[i] < data[right]) {
		swap = data[swapInd];
		data[swapInd] = data[i];	
		data[i] = swap;
		swapInd++;
	    }
	}
	swap = data[swapInd];
	data[swapInd] = data[right];
	data[right] = swap;
	return swapInd;
}
	
    
}
