package Chapter2;

import java.util.Stack;

import CtCILibrary.LinkedListNode;

public class Palindrome {
	/*assume input linked list is a single linked list*/
	public static boolean isPalindrome (LinkedListNode head) {
		LinkedListNode current = head;
		LinkedListNode runner = head;
		Stack<Integer> count = new Stack<Integer>();
		while (current != null && current.next != null) {
			current = current.next.next;
			count.push(runner.data);
			runner = runner.next;
		}
		if (current != null) {//in case of length is odd
			runner = runner.next;
		}
		current = head;
		while (runner != null) {
			if (count.pop() != runner.data ) {
				return false;
			}
			runner = runner.next;
		}
		return true;
	}
	public static void main(String[] args) {
		int length = 9;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}
		
		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		//nodes[length - 2].data = 9; // Uncomment to ruin palindrome
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		System.out.println(isPalindrome(head));
	}
}
/*
 * Space Complexity O(1) 
 * Time Complexity O(N) where N is the number of elements in the linked list
 * 
*/