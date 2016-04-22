package Chapter3;

import java.util.EmptyStackException;

public class StackMin {
	// Node class of Stack
	private static class StackMinNode {
		private int data;
		public int min = Integer.MAX_VALUE;
		private StackMinNode next;
		
		public StackMinNode(int data) {
			this.data = data;
			this.min = data;
		}
		
		public int getData(){
			return this.data;
		}		
	}
	
	private StackMinNode top;
	
	public int pop() {
		if (top == null) throw new EmptyStackException();
		int  data = top.getData();
		top = top.next;
		return data;
	}
	
	public int peek() {
		if (top == null) throw new EmptyStackException();
		int  data = top.getData();
		return data;
	}
	
	public void push(int data) {
		StackMinNode node = new StackMinNode(data);
		if (top != null) {
			node.min = Math.min(node.min, top.min);
		} 
		node.next = top;
		top = node;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public int min(){
		return top.min;
	}
	
	public static void main(String args[]) {
		StackMin stackMin = new StackMin();
		stackMin.push(5);
		stackMin.push(6);
		stackMin.push(7);
		stackMin.push(3);
		System.out.println("Min = "+stackMin.min()+" pop "+stackMin.pop());
		System.out.println("Min = "+stackMin.min()+" pop "+stackMin.pop());
		System.out.println("Min = "+stackMin.min()+" pop "+stackMin.pop());
	}
}
/*
 *push(), pop() and min() operate in O(1) time
 */
