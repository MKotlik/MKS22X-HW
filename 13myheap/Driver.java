public class Driver {
    public static void main(String[]args) {
	String[] input = new String[] {null, "1", "2", "5", "6", "7", "8"};
	//String[] input = new String[] {null, "A", "B", "E", "F", "G", "H"};
	//String[] input = new String[] {"F", "E", "C", "D", "B", "A"};
	MyHeap<String> test1 = new MyHeap<String>(input);
	System.out.println(test1);
	test1.add("-5");
	System.out.println(test1);
	test1.add("4");
	System.out.println(test1);
	System.out.println(test1.delete());
	System.out.println(test1);
    }
}
