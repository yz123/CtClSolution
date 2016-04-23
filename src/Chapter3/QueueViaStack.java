package Chapter3;

import java.util.NoSuchElementException;

public class QueueViaStack<T> {
	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;
		
		public QueueNode(T data) {
			this.data = data;
		}		
	}
	
	private QueueNode<T> bottom;
	private QueueNode<T> top;
	
	public void add(T data) {
		QueueNode<T> n = new QueueNode<T>(data);
		if (top == null && bottom == null) {
			top = n;
			bottom = top;
		}
		top.next = n;
		top = n;
	}
	
	public T remove() {
		if (isEmpty()) throw new NoSuchElementException();
		T data = bottom.data;
		bottom = bottom.next;
		if (bottom == null) {
			top = null;
		}
		return data;
	} 
	
	public T peek() {
		if (bottom == null) throw new NoSuchElementException();
		T data = bottom.data;
		return data;
	}
	
	public boolean isEmpty() {
		return bottom == null;
	}
	
	public static void main(String[] args) {
		QueueViaStack<Integer> queue = new QueueViaStack<Integer>();
		for (int i = 0; i < 7; i++) {
			queue.add(i+1);
		}
		for (int i = 0; i <7; i++) {
			System.out.println("Dequeue "+queue.remove());
		}
	}

}
