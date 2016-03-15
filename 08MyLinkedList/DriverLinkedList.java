public class DriverLinkedList {
    public static void main(String[]args) {
	MyLinkedList newList = new MyLinkedList();
	System.out.println(newList.get(0));
	newList.add(5);
	System.out.println("Size: " + newList.size());
	System.out.println(newList.get(0));
	System.out.println(newList.get(1));
    }
}
