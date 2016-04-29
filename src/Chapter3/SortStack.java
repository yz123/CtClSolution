package Chapter3;

import java.util.Stack;

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
	
	public static void main(String args[]) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(3);
		s.push(4);
		s.push(2);
		s.push(1);
		SortStack.sortStack(s);
		int size = s.size();
		for (int i = 0;i < size;i++) {
			System.out.println(s.pop());
		}
	}
}
