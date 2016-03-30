import java.util.*;
public class DriverStackQueue {
    public static void main(String[]args) {
	MyStack<String> stackA = new MyStack<String>();
	MyQueue<String> queueA = new MyQueue<String>();

	for (int i = -10; i < 11; i++) {
	    stackA.push(i+"");
	    queueA.enqueue(i+"");
	}
	
	System.out.println("Stack: " + stackA);
	System.out.println("Queue: " + queueA);

	System.out.println("\nStack Tests");
	System.out.println("Peek: " + stackA.peek());
	System.out.println("Pop: " + stackA.pop());
	System.out.println("Pop again: " + stackA.pop());
	System.out.println("Peek: " + stackA.peek());
	System.out.println("Push: 200");
	stackA.push(200+"");
	System.out.println("Stack: " + stackA);

	System.out.println("Empty Stack Tests");
	stackA = new MyStack<String>();
	System.out.println("Size: " + stackA.size());
	System.out.println("Empty?: " + stackA.isEmpty());
	try {
	    stackA.peek();
	} catch (NoSuchElementException e) {
	    System.out.println("Success! Error on empty peek.");
	}
	try {
	    stackA.pop();
	} catch (NoSuchElementException e) {
	    System.out.println("Success! Error on empty pop.");
	}
	
	System.out.println("\nQueue Tests");
	System.out.println("Peek: " + queueA.peek());
	System.out.println("Dequeue: " + queueA.dequeue());
	System.out.println("Dequeue again: " + queueA.dequeue());
	System.out.println("Peek: " + queueA.peek());
	System.out.println("Enqueue: 200");
	queueA.enqueue(200+"");
	System.out.println("Queue: " + queueA);

	System.out.println("Empty Queue Tests");
	queueA = new MyQueue<String>();
	System.out.println("Size: " + queueA.size());
	System.out.println("Empty?: " + queueA.isEmpty());
	try {
	    queueA.peek();
	} catch (NoSuchElementException e) {
	    System.out.println("Success! Error on empty peek.");
	}
	try {
	    queueA.dequeue();
	} catch (NoSuchElementException e) {
	    System.out.println("Success! Error on empty dequeue.");
	}
	
	System.out.println("\nVerify Random Operations, Stack");
	MyStack<String> stackB = new MyStack<String>();
	Stack<String> verStack = new Stack<String>();
	Random rand = new Random();
	for (int i = 0; i < 5000; i++) {
	    
	}
    }
}
