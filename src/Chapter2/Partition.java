package Chapter2;

import CtCILibrary.LinkedListNode;

public class Partition {
	public static LinkedListNode addFrist(LinkedListNode node, int data) {
		LinkedListNode head = new LinkedListNode(data);
		head.next = node;
		node.prev = head;
		return head;
	}
	public static LinkedListNode partition (LinkedListNode head, int i){
		LinkedListNode n = head;
		LinkedListNode previous = null;
		while (n != null) {
			if ((n.data < i) && (n != head)) {
				// delete original head
				int data = n.data;
				previous.next = n.next;
				// add element to head
				head = addFrist(head, data);
			} else {
				previous = n;
			}
			n = n.next;
		}
		return head;
		
	}
	public static void main(String[] args) {
		int length = 20;
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
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		
		LinkedListNode h = partition(head, 7);
		System.out.println(h.printForward());
		}
}
/*
 * Space Complexity O(1) 
 * Time Complexity O(N) where N is the number of elements in the linked list
 * 
*/