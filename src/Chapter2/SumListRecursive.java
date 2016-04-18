package Chapter2;

import CtCILibrary.LinkedListNode;

public class SumListRecursive {
	private static int linkedListToInt(LinkedListNode node) {
		if (node.next == null) {
			return node.data;
		}
		return linkedListToInt(node.next) * 10 + node.data;
	}
	
	public static LinkedListNode sumList(LinkedListNode node1, LinkedListNode node2, int carry){
		if ((node1 == null)&&(node2 == null)&&(carry == 0)) {
			return null;
		}
		int value = carry;
		LinkedListNode result = new LinkedListNode();
		if (node1 != null) {
			value += node1.data;
		}
		if (node2 != null) {
			value += node2.data;
		}
		result.data = value % 10;
		if ((node1 != null)||(node2 != null)) {
			LinkedListNode more = sumList(
					node1 == null ? null:node1.next,
					node2 == null ? null:node2.next,
					value >= 10? 1:0);
					
			result.setNext(more);
		}
		return result;
		
		
	}

	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(9, null, null);
		LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(9, null, lA2);
		
		LinkedListNode lB1 = new LinkedListNode(1, null, null);
		LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(0, null, lB2);	
		
		LinkedListNode list3 = sumList(lA1, lB1,0);
		
		System.out.println("  " + lA1.printForward());		
		System.out.println("+ " + lB1.printForward());			
		System.out.println("= " + list3.printForward());	
		
		int l1 = linkedListToInt(lA1);
		int l2 = linkedListToInt(lB1);
		int l3 = linkedListToInt(list3);
		
		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));		
	}
}
/*
 * Space Complexity O(N) where N is the number of elements in the linked list
 * Time Complexity O(N) where N is the number of elements in the linked list
 * 
*/

