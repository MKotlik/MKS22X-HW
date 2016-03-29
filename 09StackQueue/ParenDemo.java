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
	MyStack<Character> openStack= new MyStack<Character>();
	for (int i = 0; i < parenStr.length(); i++) {
	    char cur = parenStr.charAt(i);
	    if (cur == '(' || cur == '{' || cur == '<' || cur == '[') {
		openStack.push(cur);
	    }
	}
	ArrayList<String> openParens = new ArrayList<String>(Arrays.asList

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
}
