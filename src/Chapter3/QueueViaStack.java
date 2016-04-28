package Chapter3;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueViaStack<T> {
	// A efficient implementation
	private Stack<T> master;
	private Stack<T> slave;
	
	public QueueViaStack() {
		master = new Stack<T>();
		slave = new Stack<T>();
	}
	
	public void add(T data) {
		master.push(data);
	}
	
	public T remove() {
		if (size() == 0) throw new NoSuchElementException();
		if (slave.size() == 0) {
			while (!master.isEmpty()) {
				T temp = master.pop();
				slave.push(temp);
			}
		}
		return slave.pop();
	} 
	
	public T peek() {
		if (size() == 0) throw new NoSuchElementException();
		if (slave.size() == 0) {
			while (!master.isEmpty()) {
				T temp = master.pop();
				slave.push(temp);
			}
		}
		return slave.peek();

	}
	
	public boolean isEmpty() {
		return master.isEmpty();
	}
	
	public int size() {
		return master.size()+slave.size();
	}
	
	public static void main(String[] args) {
		QueueViaStack<Integer> queue = new QueueViaStack<Integer>();
		for (int i = 0; i < 3; i++) {
			queue.add(i+1);
		}
		for (int i = 0; i < 2; i++) {
			System.out.println("Dequeue "+queue.remove());
		}
		for (int i = 0; i < 4; i++) {
			queue.add(i+1);
		}
		for (int i = 0; i < 5; i++) {
			System.out.println("Dequeue "+queue.remove());
		}
	}
}