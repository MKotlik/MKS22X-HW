public class Driver01 {
	public static void main(String[]args) {
		Recursion guesser = new Recursion();
		/*
		System.out.println(guesser.percentError(4, 4));
		System.out.println(guesser.percentError(0, 0));
		System.out.println(guesser.percentError(2, 1.78923432345));
		System.out.println(guesser.percentError(1, 0.9999999999));
		*/
		System.out.println("--PERFECT SQUARE TESTS--");
		System.out.println(guesser.sqrt(0));
		System.out.println(guesser.sqrt(1));
		System.out.println(guesser.sqrt(4));
		System.out.println(guesser.sqrt(9));
		System.out.println(guesser.sqrt(16));
		System.out.println(guesser.sqrt(25));
		System.out.println(guesser.sqrt(36));
		System.out.println(guesser.sqrt(81));
		System.out.println(guesser.sqrt(100));
		System.out.println(guesser.sqrt(121));
		System.out.println(guesser.sqrt(144));
		System.out.println(guesser.sqrt(169));
		System.out.println("--TESTS FROM 0 TO 36--");
		for (int i = 0; i < 37; i++) {
			System.out.println(guesser.sqrt(i));
		}
		System.out.println("--TESTS FROM 0 TO 1--");
		for (double j = 0; j <= 1.00; j += 0.01) {
		    System.out.println(guesser.sqrt(j));
		}
		System.out.println("--NEGATIVE ARGUMENT TEST--");
		try {
		    System.out.println(guesser.sqrt(-20));
		} catch(IllegalArgumentException e) {
		    System.out.println("SUCCESS: Exception Thrown");
		}
	}
}
