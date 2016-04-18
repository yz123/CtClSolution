package Chapter2;


import CtCILibrary.LinkedListNode;

public class RemoveDups {
	public static void removeDups(LinkedListNode node) {
		//HashSet<Integer> dups = new HashSet<Integer>();
		LinkedListNode slow = node;
		while (slow != null) {
			LinkedListNode fast = slow;
			//LinkedListNode prev = null;
			while (fast.next != null) {
				if (fast.next.data == slow.data) {
					fast.next = fast.next.next;
				} else {
					fast = fast.next;
				}
			}
			slow = slow.next;
		}
	}
	
	public static void main(String[] args) {	
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 15; i++) {
			second = new LinkedListNode(i % 4, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		removeDups(head);
		System.out.println(head.printForward());
	}
}
/*
 * Space Complexity O(1) 
 * Time Complexity O(N^2) where N is the number of elements in the linked list
 * 
*/