package Chapter2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class ReturnKthToLast {
	public static LinkedListNode returnKthToLast(LinkedListNode head, int k){
		LinkedListNode end = head;
		LinkedListNode kth = head;
		for (int i = 0; i < k; i++) {
			if (end == null) return null;
			end = end.next;
		}
		while (end != null) {
			end = end.next;
			kth = kth.next;
		}
		return kth;

	}
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 4, 5, 6};
		LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
		for (int i = 0; i <= array.length + 1; i++) {
			LinkedListNode node = returnKthToLast(head, i);
			String nodeValue = node == null ? "null" : "" + node.data;
			System.out.println(i + ": " + nodeValue);
		}
	}
}
/*
 * Space Complexity O(1) 
 * Time Complexity O(N) where N is the number of elements in the linked list
 * 
*/