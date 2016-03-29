import java.util.*;
public class ParenDemo {
    
    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println( isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}	
    }

    public static boolean isMatching(String parenStr) {
	MyStack<String> openStack= new MyStack<String>();
	String[] openParensArray = {"(","{","<","["};
	String[] closeParensArray = {")","}",">","]"};
	ArrayList<String> openParens = new ArrayList<String>(Arrays.asList(openParensArray));
	ArrayList<String> closeParens = new ArrayList<String>(Arrays.asList(closeParensArray));
	for (int i = 0; i < parenStr.length(); i++) {
	    String cur = parenStr.substring(i,i+1);
	    if (openParens.contains(cur)) {
		openStack.push(cur);
	    } else if (closeParens.contains(cur)) {
		if (!openStack.isEmpty() && openStack.peek().equals(openParens.get(closeParens.indexOf(cur)))) {
		    openStack.pop();
		} else {
		    return false;
		}
	    }
	}
	return openStack.isEmpty();
    }

    /*
    public static boolean isMatching(String parenStr) {
	MyStack<Character> openStack= new MyStack<Character>();
	for (int i = 0; i < parenStr.length(); i++) {
	    char cur = parenStr.charAt(i);
	    if (cur == '(' || cur == '{' || cur == '<' || cur == '[') {
		openStack.push(cur);
	    } else if (cur == ')') {
		if (openStack.peek() == '(') {
		    openStack.pop();
		} else {
		    return false;
		}
	    } else if (cur == '}') {
		if (openStack.peek() == '{') {
		    openStack.pop();
		} else {
		    return false;
		}
	    } else if (cur == '>') {
		if (openStack.peek() == '<') {
		    openStack.pop();
		} else {
		    return false;
		}
	    } else if (cur == ']') {
		if (openStack.peek() == '[') {
		    openStack.pop();
		} else {
		    return false;
		}
	    }
	}
	return true;
    }
    */
}
