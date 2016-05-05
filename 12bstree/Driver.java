public class Driver {
    public static void main(String[]args) {
	BSTree<String> test1 = new BSTree<String>();
	test1.add("3");
	test1.add("2");
	test1.add("1");
	test1.add("5");
	test1.add("4");
	System.out.println(test1);
	System.out.println(test1.getHeight());
	System.out.println(test1.contains("5"));
	System.out.println(test1.contains("100"));
	
    }
}
