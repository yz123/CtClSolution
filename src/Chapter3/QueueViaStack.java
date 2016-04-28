package Chapter3;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueViaStack<T> {
	
	private Stack<T> master = new Stack<T>();
	private Stack<T> slave = new Stack<T>();;
	
	public void add(T data) {
		master.push(data);
	}
	
	public T remove() {
		if (master.isEmpty()) throw new NoSuchElementException();
		while (!master.isEmpty()) {
			T temp = master.pop();
			slave.push(temp);
		}
		T data = slave.pop();
		if(!slave.isEmpty()) {
			while(!slave.isEmpty()) {
				T temp = slave.pop();
				master.push(temp);
			}
		}
		return data;
	} 
	
	public T peek() {
		if (master.isEmpty()) throw new NoSuchElementException();
		while (!master.isEmpty()) {
			T temp = master.pop();
			slave.push(temp);
		}
		T data = slave.peek();
		while(!slave.isEmpty()) {
			T temp = slave.pop();
			master.push(temp);
		}
		return data;
	}
	
	public boolean isEmpty() {
		return master.isEmpty();
	}
	
	public static void main(String[] args) {
		QueueViaStack<Integer> queue = new QueueViaStack<Integer>();
		for (int i = 0; i < 7; i++) {
			queue.add(i+1);
		}
		for (int i = 0; i < 7; i++) {
			System.out.println("Dequeue "+queue.remove());
		}
	}

}
