package Chapter2;

import CtCILibrary.LinkedListNode;

public class SumListReverse {
	private static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		while (node != null) {
			value = node.data + value*10;
			node = node.next;
		}
		return value;
	}
	
	private static LinkedListNode intToLinkedList(int sum) {
		LinkedListNode tail = new LinkedListNode(sum%10);
		LinkedListNode head = tail;
		if (sum/10 == 0) {
			return head;
		}
		while (sum/10 != 0) {
			sum = sum/10;
			LinkedListNode node = new LinkedListNode(sum%10);
			node.next = head;
			head = node;
		}
		return head;
	}
	
	public static LinkedListNode sumList(LinkedListNode node1, LinkedListNode node2){
		int sum1 = linkedListToInt(node1);
		int sum2 = linkedListToInt(node2);
		int sum = sum1 + sum2;
		return intToLinkedList(sum);
		
	}

	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(7, null, null);
		LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(9, null, lA2);
		
		LinkedListNode lB1 = new LinkedListNode(1, null, null);
		LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(0, null, lB2);	
		
		LinkedListNode list3 = sumList(lA1, lB1);
		
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
