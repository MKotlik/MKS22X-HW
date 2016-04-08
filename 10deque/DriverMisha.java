public class DriverMisha {
    public static void main(String[]args) {
	MyDeque<Integer> a = new MyDeque<Integer>();
	System.out.println(a);

	for (int i = 0; i < 10; i++) {
	    a.addLast(i);
	}
	System.out.println(a.toStringDebug());
	a.addLast(100);
	System.out.println(a.toStringDebug());
	for (int i = -1; i > -6; i--) {
	    a.addFirst(i);
	}
	System.out.println(a.toStringDebug());
	for (int i = 101; i < 106; i++) {
	    a.addLast(i);
	}
	System.out.println(a.toStringDebug());
	for (int i = 0; i < 3; i++) {
	    System.out.println(a.removeFirst());
	}
	System.out.println(a.toStringDebug());
	for (int i = 0; i < 3; i++) {
	    System.out.println(a.removeLast());
	}
	System.out.println(a.toStringDebug());
	for (int i = -3; i > -11; i--) {
	    a.addFirst(i);
	}
	System.out.println(a.toStringDebug());
	for (int i = -3; i > -11; i--) {
	    System.out.println(a.removeFirst());
	}
	System.out.println(a.toStringDebug());
	for (int i = 103; i < 130; i++) {
	    a.addLast(i);
	}
	System.out.println(a.toStringDebug());
    }
}
