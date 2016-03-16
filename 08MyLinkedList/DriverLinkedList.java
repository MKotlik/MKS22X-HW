public class DriverLinkedList {
    public static void main(String[]args) {
	MyLinkedList newList = new MyLinkedList();
	System.out.println(newList.get(0));
	newList.add(5);
	System.out.println("Size: " + newList.size());
	System.out.println(newList.get(0));
	System.out.println(newList.get(1));
	int[] src = {-10,4,5,2,110,-11,21,-3};
	MyLinkedList srcdList = new MyLinkedList(src);
	System.out.println(srcdList);
	System.out.println(srcdList.size());
	srcdList.set(3,500);
	srcdList.remove(srcdList.size()-2);
	srcdList.add(2,144);
	System.out.println(srcdList);
	//should throw error
	//srcdList.set(500,1);
	//srcdList.remove(500);
	//srcdList.add(500,1);
	//All errors thrown correctly!
	System.out.println(srcdList.indexOf(-10));
	System.out.println(srcdList.indexOf(777));
	//All tests passed!
	System.out.println("0 Index Tests");
	//0 Index remove fixed, last index tested
	//System.out.println(srcdList);
	//System.out.println(srcdList.remove(srcdList.size()-1));
	//System.out.println(srcdList);
	//0 Index add fix, passed test
	//System.out.println(srcdList);
	//System.out.println(srcdList.add(0, 43110));
	//System.out.println(srcdList);
	//System.out.println(srcdList.get(0));
    }
}
