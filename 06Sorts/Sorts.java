import java.util.Arrays;
import java.util.Random;

public class Sorts{
	 public static void insertionSort(int[] data){
        for (int i = 1; i < data.length; i++){
            if (data[i] < data[i-1]){
                int j = i;
                while (j > 0 && data[i] < data[j-1]){
                    j--;
                }
                int temp = data[i];
                for (int k = i-1; k >= j; k--){
                    data[k+1] = data[k];
                }
                data[j] = temp;
            }
        }
    }

    public static void selectionSort(int[] data){
		for (int swapInd = 0; swapInd < data.length; swapInd++){
	    	int minInd = swapInd;
	    	int min = data[minInd];
	    	for (int i = swapInd; i < data.length; i++){
				if (data[i] < min){
		    		minInd = i;
		    		min = data[minInd];
				}
	    	}
	    	data[minInd] = data[swapInd];
	    	data[swapInd] = min;
		}
    }

    public static void bubbleSort(int[] data){
		for (int upperBound = data.length - 1; upperBound > 0; upperBound--){
		    int swap = 0;
		    for (int i = 0; i < upperBound; i++){
				if (data[i] > data[i+1]){
			    	swap = data[i + 1];
			    	data[i+1] = data[i];
			    	data[i] = swap;
				}
		    }
		}
    }


    //Wrapper function
    //Takes array, tries to split it into two
    public static void mergeSort(int[] data) {
	if (data.length > 1) {
	    mergeSortHelp(data, 0, data.length);
	}
    }

    //Helper function
    //Sorts section of array
    //Endpoints are exclusive
    private static void mergeSortHelp(int[] data, int start, int end) {
	if (end > start + 1) { //As long as array has at least two elements
	    int mid = (start + end) / 2;
	    mergeSortHelp(data, start, mid);
	    mergeSortHelp(data, mid, end);
	    merge(data, start, mid, end);
	}
    }

    //Merge function
    //Merges/sorts subarrays into cohesive array
    private static void merge(int[] data, int startA, int mid, int endB) {
	int[] sortedArray = new int[endB - startA];
	int indA = startA;
	int indB = mid;
	for (int i = 0; i < sortedArray.length; i++) {
	    if (indB >= endB || (indA < mid && data[indA] < data[indB])) {
		sortedArray[i] = data[indA];
		indA++;
	    } else {
		sortedArray[i] = data[indB];
		indB++;
	    }
	}
	int origInd = startA;
	for (int j = 0; j < sortedArray.length; j++) {
	    data[origInd] = sortedArray[j];
	    origInd++;
	}
    }


    public static void main(String[]args){
    	if (args.length == 0){
	    //MergeSort Tests
	    System.out.println("Testing Merge Sort");
	    int[] testm1 = {};
	    System.out.println(Arrays.toString(testm1));
	    mergeSort(testm1);
	    System.out.println(Arrays.toString(testm1));
	    
	    int[] testm2 = {-1};
	    System.out.println(Arrays.toString(testm2));
	    mergeSort(testm2);
	    System.out.println(Arrays.toString(testm2));
	    
	    int[] testm3 = {4,5};
	    System.out.println(Arrays.toString(testm3));
	    mergeSort(testm3);
	    System.out.println(Arrays.toString(testm3));
	    
	    int[] testm4 = {5,4};
	    System.out.println(Arrays.toString(testm4));
	    mergeSort(testm4);
	    System.out.println(Arrays.toString(testm4));
	    
	    int[] testm5 = {7,-5,3};
	    System.out.println(Arrays.toString(testm5));
	    mergeSort(testm5);
	    System.out.println(Arrays.toString(testm5));
	    
	    int[] testm6 = {112, -1, 5, 3, 7, -10, 20};
	    System.out.println(Arrays.toString(testm6));
	    mergeSort(testm6);
	    System.out.println(Arrays.toString(testm6));
	    
	    	//SelectionSort Sort tests
	    	System.out.println("Testing Selection Sort");
			int[] test1 = {};
			System.out.println(Arrays.toString(test1));
			selectionSort(test1);
			System.out.println(Arrays.toString(test1));

			int[] test2 = {1};
			System.out.println(Arrays.toString(test2));
			selectionSort(test2);
			System.out.println(Arrays.toString(test2));

			int[] test3 = {1,0};
			System.out.println(Arrays.toString(test3));
			selectionSort(test3);
			System.out.println(Arrays.toString(test3));

			int[] test4 = {0,1,2,3,4,5};
			System.out.println(Arrays.toString(test4));
			selectionSort(test4);
			System.out.println(Arrays.toString(test4));

			int[] test5 = {3,0,4,1,2,5};
			System.out.println(Arrays.toString(test5));
			selectionSort(test5);
			System.out.println(Arrays.toString(test5));

			int[] test6 = {-1,0,-5,6,3,-11,12,2};
			System.out.println(Arrays.toString(test6));
			selectionSort(test6);
			System.out.println(Arrays.toString(test6));

			//InsertionSort Sort tests
			System.out.println("Testing Insertion Sort");
			int[] test1i = {};
			System.out.println(Arrays.toString(test1i));
			insertionSort(test1i);
			System.out.println(Arrays.toString(test1i));

			int[] test2i = {1};
			System.out.println(Arrays.toString(test2i));
			insertionSort(test2i);
			System.out.println(Arrays.toString(test2i));

			int[] test3i = {1,0};
			System.out.println(Arrays.toString(test3i));
			insertionSort(test3i);
			System.out.println(Arrays.toString(test3i));

			int[] test4i = {0,1,2,3,4,5};
			System.out.println(Arrays.toString(test4i));
			insertionSort(test4i);
			System.out.println(Arrays.toString(test4i));

			int[] test5i = {3,0,4,1,2,5};
			System.out.println(Arrays.toString(test5i));
			insertionSort(test5i);
			System.out.println(Arrays.toString(test5i));

			int[] test6i = {-1,0,-5,6,3,-11,12,2};
			System.out.println(Arrays.toString(test6i));
			insertionSort(test6i);
			System.out.println(Arrays.toString(test6i));

			//Bubble Sort Testing
			System.out.println("Testing Bubble Sort");
			int[] test1b = {};
			System.out.println(Arrays.toString(test1b));
			bubbleSort(test1b);
			System.out.println(Arrays.toString(test1b));

			int[] test2b = {1};
			System.out.println(Arrays.toString(test2b));
			bubbleSort(test2b);
			System.out.println(Arrays.toString(test2b));

			int[] test3b = {1,0};
			System.out.println(Arrays.toString(test3b));
			bubbleSort(test3b);
			System.out.println(Arrays.toString(test3b));

			int[] test4b = {0,1,2,3,4,5};
			System.out.println(Arrays.toString(test4b));
			bubbleSort(test4b);
			System.out.println(Arrays.toString(test4b));

			int[] test5b = {3,0,4,1,2,5};
			System.out.println(Arrays.toString(test5b));
			bubbleSort(test5b);
			System.out.println(Arrays.toString(test5b));

			int[] test6b = {-1,0,-5,6,3,-11,12,2};
			System.out.println(Arrays.toString(test6b));
			bubbleSort(test6b);
			System.out.println(Arrays.toString(test6b));
		} else if (args[0].equals("insertion") || args[0].equals("selection") || args[0].equals("bubble")) { //If a known sort algo is specified
			int[] largeTest = new int[100000]; //Create test array
			int[] comparisonArray = new int[largeTest.length]; //Create array for default algo comparison
			Random randGen = new Random(); //Fill with random integers
			for (int i = 0; i < largeTest.length; i++){
				largeTest[i] = randGen.nextInt(100000) - 50000;
			}
			if (args.length == 2 && args[1].equals("verify")){ //If verification option specified, copy main test array into comparison
				System.arraycopy(largeTest, 0, comparisonArray, 0, largeTest.length);
			}
			if (args[0].equals("insertion")) { //Run algo corresponding to option
				insertionSort(largeTest);
			} else if (args[0].equals("selection")) {
				selectionSort(largeTest);
			} else if (args[0].equals("bubble")) {
				bubbleSort(largeTest);
			}
			if (args.length == 2 && args[1].equals("verify")){ //If verification option specified, compare array after default sorting to chosen algo sorting
				Arrays.sort(comparisonArray);
				System.out.println("Sorted correctly: " + Arrays.equals(largeTest, comparisonArray));
			}
		} else if (args[0].equals("default")) { //For testing default algo time
			int[] largeTest = new int[100000];
			Random randGen = new Random();
			for (int i = 0; i < largeTest.length; i++){
				largeTest[i] = randGen.nextInt(100000) - 50000;
			}
			Arrays.sort(largeTest);
	}
    }
}
