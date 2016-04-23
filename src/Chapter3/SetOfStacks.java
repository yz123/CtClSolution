package Chapter3;

import java.util.ArrayList;
import java.util.EmptyStackException;


public class SetOfStacks<T> {
	public static class SetNode<T> {
		private T data;
		private SetNode<T> next;
		public SetNode(T data) {
			this.data = data;
		}
		public T getData(){
			return this.data;
		}
	}
	
	public ArrayList<SetNode<T>> setOfTop;
	public int sizeOfStacks;
	public int currentSize;
	
	public SetOfStacks(int sizeOfStacks){
		setOfTop = new ArrayList<SetNode<T>>();
		this.sizeOfStacks = sizeOfStacks;
		this.currentSize = 0;
	}
	
	public int currentNumStack() {
		return (currentSize-1)/sizeOfStacks + 1;
	}
	
	public int reallNumStack() {
		return setOfTop.size();
	}
	
	public void push(T item) { 
		currentSize ++;
		SetNode<T> node = new SetNode<T>(item);
		if (currentNumStack() > reallNumStack()) {
			setOfTop.add(node);
			if (currentNumStack()>1) {
				node.next = setOfTop.get(currentNumStack()-2);
			}
		} else {
			SetNode<T> top = setOfTop.get(currentNumStack()-1);
			node.next = top;
			setOfTop.set(currentNumStack()-1, node);
		}
		//System.out.println("currentSize "+currentSize);
		//System.out.println("Current Num of Stack"+(currentNumStack()-1)+" Top is "+setOfTop.get(currentNumStack()-1).getData());
	}
	
	public T pop (){
		SetNode<T> top = setOfTop.get(currentNumStack()-1);
		//System.out.println("top "+top.getData());
		//System.out.println("size top "+setOfTop.size());
		if (top == null) throw new EmptyStackException();
		currentSize --;
		if (currentNumStack() < reallNumStack()) {
			T data = top.getData();
			setOfTop.remove(top);
			return data;
		} else {
			T data = top.getData();
			setOfTop.set(currentNumStack()-1, top.next);
			return data;
		}
	}
	
	public T peek(){
		SetNode<T> top = setOfTop.get(currentNumStack()-1);
		T data = top.getData();
		return data;
	}
	
	public boolean isEmpty() {
		if (reallNumStack() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String args[]) {
		SetOfStacks<Integer> setOfStacks = new SetOfStacks<Integer>(3);
		setOfStacks.push(1);
		setOfStacks.push(2);
		setOfStacks.push(3);
		setOfStacks.push(4);
		setOfStacks.push(5);
		setOfStacks.push(6);
		setOfStacks.push(7);
		System.out.println(setOfStacks.pop());
		System.out.println(setOfStacks.pop());
		System.out.println(setOfStacks.pop());
		System.out.println(setOfStacks.pop());
		System.out.println(setOfStacks.pop());
		System.out.println(setOfStacks.pop());
		System.out.println(setOfStacks.pop());
	}
}
