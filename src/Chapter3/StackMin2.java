package Chapter3;

import java.util.Stack;

public class StackMin2 extends Stack<Integer>{
	Stack<Integer> minTracker;
	public StackMin2() {
		minTracker = new Stack<Integer>();
	}
	
	public void push(int data){
		if(data < min()) {
			minTracker.push(data);
		}
		super.push(data);
	}
	
	public Integer pop(){
		if (super.peek() == min()) {
			minTracker.pop();
		}
		return super.pop();
	}
	
	public Integer min() {
		if (minTracker.empty()) {
			return Integer.MAX_VALUE;
		}
		return minTracker.peek();
	}
	
	public static void main(String args[]) {
		StackMin2 stackMin = new StackMin2();
		stackMin.push(3);
		stackMin.push(4);
		stackMin.push(5);
		stackMin.push(1);
		System.out.println("Stack min = "+ stackMin.min()+" pop: "+stackMin.pop());
		System.out.println("Stack min = "+ stackMin.min()+" pop: "+stackMin.pop());
		System.out.println("Stack min = "+ stackMin.min()+" pop: "+stackMin.pop());
		System.out.println("Stack min = "+ stackMin.min()+" pop: "+stackMin.pop());
	}
}
/*
 * this implementation may be more efficiency than the first one, in condition that the precedent elements 
 * that added contain the minimal value
 */