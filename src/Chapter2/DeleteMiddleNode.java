package Chapter2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class DeleteMiddleNode {
	//given only access to that node
	public static boolean deleteMiddleNode(LinkedListNode node) {
		if (node == null || node.next == null ) {
			return false;
		} 
		LinkedListNode next = node.next;
		node.data = next.data;
		node.next = next.next;
		return true;	
	}
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		deleteMiddleNode(head.next.next.next.next); // delete node 4
		System.out.println(head.printForward());
	}
}
/*
 * Space Complexity O(1) 
 * Time Complexity O(N) where N is the number of elements in the linked list
 * 
*/