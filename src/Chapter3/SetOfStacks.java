package Chapter3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class SetOfStacks {
	ArrayList<Stack> stacks = new ArrayList<Stack> ();
	private static int CAPACITY = 3;
		
	public Stack getLastStack() {
		if (stacks.size() == 0)
			return null;
		return stacks.get(stacks.size()-1);
	}
	
	public boolean isEmpty() {
		return (stacks.size() == 0);
	}
	
	public boolean isFull() {
		return (getLastStack().size() == CAPACITY);
	}
	
	public void push(int item) {
		if ( getLastStack()== null || isFull()) {
			Stack stack = new Stack();
			stacks.add(stack);
			stack.push(item);
		} else {
			getLastStack().push(item);
		}
	}
	
	public int pop() {
		Stack stack = getLastStack();
		if (stack == null) throw new EmptyStackException();
		int item = (int) stack.pop();
		if (stack.size() == 0) stacks.remove(stacks.size()-1);
		return item;
	}
	
	public static void main(String[] args) {
		SetOfStacks stacks = new SetOfStacks();
		for (int i = 0; i < 7; i++) {
			stacks.push(i+1);
		}
		for (int i = 0; i <7; i++) {
			System.out.println("pop "+stacks.pop());
		}
	}	
}
