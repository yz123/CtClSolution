package Chapter3;

import java.util.Stack;

import CtCILibrary.AssortedMethods;

public class SortStack {

	public static Stack<Integer> sortStack(Stack<Integer> s) {
		Stack<Integer> t = new Stack<Integer>();
		int size = s.size();
		
		for (int i = 0; i < size; i++) {
			int max = s.pop();
			for (int j = 0; j < size-i-1;j++) {
				if (s.peek()> max ){
					t.push(max);
					max = s.pop();
				} else {
					t.push(s.pop());
				}
			}
			t.push(max);	
			for (int j = 0; j < size-i;j++) {
				s.push(t.pop());
			}
		}
		return s;
	}
	
	public static void main(String [] args) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			int r = AssortedMethods.randomIntInRange(0,  1000);
			s.push(r);
		}
		
		SortStack.sortStack(s);
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
}

/*
 * Space Complexity O(N) 
 * Time Complexity O(N^2) where N is the number of elements in the stack
 * 
*/
