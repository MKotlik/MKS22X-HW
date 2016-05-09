public class Driver {
    public static void main(String[]args) {
	String[] input = new String[] {null, "A", "B", "C", "D", "E", "F"};
	//String[] input = new String[] {"F", "E", "C", "D", "B", "A"};
	MyHeap<String> test1 = new MyHeap<String>(input);
	System.out.println(test1);
	test1.add("R");
	System.out.println(test1);
    }
}
