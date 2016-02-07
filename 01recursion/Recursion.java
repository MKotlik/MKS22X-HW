public class Recursion implements hw01{
	private String name; //My name
	private double marginError; //How accurate the square root must be, in acceptable % error
	
	public Recursion() {
		name = "KOTLIK,MIKHAIL";
		marginError = 0.001;
	}
	
	public String name() {
		return name;
	}
	
	public double sqrt(double n) throws IllegalArgumentException {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		return recursiveGuess(n, n / 2);
	}
	
	public double recursiveGuess(double n, double guess) {
		if (percentError(n, guess * guess) < marginError) {
			return guess;
		} else {
			double newGuess = ((n / guess) + guess) / 2;
			return recursiveGuess(n, newGuess);
		}
	}
	
	public double percentError(double expected, double experimental) {
		if (expected == 0) {
			return 0;
		}
		return Math.abs((expected - experimental) / expected) * 100; 
	}
}