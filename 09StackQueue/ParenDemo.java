public class ParenDemo {
    public static void main(String[]args) {
	if (args.length > 0) {
	    System.out.println(isMatching(args[0]));
	}

    }

    public static boolean isMatching(String parenStr) {
	MyStack<Character> openStack= new MyStack<Character>();
	for (int i = 0; i < parenStr.length(); i++) {
	    char cur = parenStr.charAt(i);
	    if (cur == '(' || cur == '{' || cur == '<' || cur == '[') {
		openStack.push(cur);
	    } else if (cur == ')') {
		if (openStack.peek == cur) {
		    openStack.pop();
		} else {
		    return false;
		}
	    }
	}
	return true;
    }
}
