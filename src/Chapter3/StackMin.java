package Chapter3;

import java.util.EmptyStackException;

public class StackMin {
	private static class StackMinNode {
		private int data;
		public static int min = Integer.MAX_VALUE;
		private StackMinNode next;
		
		public StackMinNode(int data) {
			this.data = data;
			this.min = Math.min(this.min, data);
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
		node.next = top;
		top = node;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public int getMin(){
		return top.min;
	}
	
	public static void main(String args[]) {
		StackMin stackMin = new StackMin();
		stackMin.push(5);
		stackMin.push(6);
		stackMin.push(7);
		System.out.println("Min = "+stackMin.getMin()+"pop "+stackMin.pop());
		System.out.println("Min = "+stackMin.getMin()+"pop "+stackMin.pop());

	}


}
