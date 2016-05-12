public class Driver {
    public static void main(String[]args) {
	RunningMedian test = new RunningMedian();
	
	//test for empty exception
	//System.out.println(test.getMedian());
	//SUCCESS!

	test.add(11);
	System.out.println(test);
	test.add(12);
	System.out.println(test);
	test.add(13);
	System.out.println(test);
	test.add(-3);
	System.out.println(test);
	test.add(14);
	System.out.println(test);
	System.out.println(test.getMedian());
	test.add(7);
	System.out.println(test);
	System.out.println(test.getMedian());
    }
}
