package Chapter2;

import java.util.HashSet;
import CtCILibrary.LinkedListNode;

public class LoopDetection {
	public static LinkedListNode isLoop(LinkedListNode head){
		if (head.next == head) {
			return null;
		}
		HashSet<LinkedListNode> loop = new HashSet<LinkedListNode>();
		while (head != null) {
			if (loop.contains(head)) {
				return head;
			}
			loop.add(head);
			head = head.next;
		}
		return null;
		
	}
	public static void main(String[] args) {
		int list_length = 100;
		int k = 10;
		
		// Create linked list
		LinkedListNode[] nodes = new LinkedListNode[list_length];
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}
		
		// Create loop;
		nodes[list_length - 1].next = nodes[list_length - k];
		
		LinkedListNode loop = isLoop(nodes[0]);

		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop.data);
		}
	}
}
/*
 * Space Complexity O(N), where N is the length of the linked list
 * Time Complexity O(N), where N is the length of the linked list
 * 
*/