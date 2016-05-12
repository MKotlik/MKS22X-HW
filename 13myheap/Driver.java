public class Driver {
    public static void main(String[]args) {
	String[] input = new String[] {"1", "2", "5", "6", "7", "8"};
	//String[] input = new String[] {null, "A", "B", "E", "F", "G", "H"};
	//String[] input = new String[] {"F", "E", "C", "D", "B", "A"};
	MyHeap<String> test1 = new MyHeap<String>(input, false);
	System.out.println(test1);
	test1.add("-5");
	System.out.println(test1);
	test1.add("4");
	System.out.println(test1);
	System.out.println(test1.delete());
	System.out.println(test1);

	System.out.println("---------");
	MyHeap<String> test2 = new MyHeap<String>(input, true);
	System.out.println(test2);
	test2.add("-5");
	System.out.println(test2);
	test2.add("4");
	System.out.println(test2);
	System.out.println(test2.delete());
	System.out.println(test2);

	System.out.println("---------");
	MyHeap<Integer> test3 = new MyHeap<Integer>(true);
	System.out.println(test3);
	test3.add(11);
	System.out.println(test3);
	test3.add(12);
	System.out.println(test3);
	test3.add(-5);
	test3.add(20);
	System.out.println(test3);
	System.out.println(test3.peek());
	MyHeap<Integer> bHeap = new MyHeap<Integer>(false);
	System.out.println(bHeap);
	bHeap.add(test3.delete());
	bHeap.add(test3.delete());
	System.out.println(bHeap);
	System.out.println(test3);
	//System.out.println(test3.delete());
	System.out.println(test3.delete());
	System.out.println(test3);

	
	
	
    }
}
