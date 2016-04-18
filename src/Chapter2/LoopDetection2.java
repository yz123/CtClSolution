package Chapter2;

import CtCILibrary.LinkedListNode;

public class LoopDetection2 {
	// use the classic runner and current method
	public static LinkedListNode isLoop(LinkedListNode head){
		LinkedListNode runner = head;
		LinkedListNode current = head;
		/*
		 * If non-loop linked list size if N, when runner
		 * arrive at N-th node, current will point at 2N-th
		 * node, which is N-th node in the loop.
		 * If we define the loop size as LOOP_SIZE, when
		 * the runner arrive at N-th node, the two pointers have
		 * a difference of LOOP_SIZE-N.
		 */
		while (current != null && current.next != null) {
			current = current.next.next;
			runner = runner.next;
			if (current == runner) {
				runner = head;
				break;
			}
		}
		if (current == null || current.next == null) {
			return null;
		}
		while (runner != current) {
			runner = runner.next;
			current = current.next;
		}
		return runner;
		
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
 * Space Complexity O(1)
 * Time Complexity O(N), where N is the length of the linked list
 * 
*/