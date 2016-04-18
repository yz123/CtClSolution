package Chapter2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class ReturnKthToLastRecursive {
	public static class Index {
		int value;
	}
	
	public static LinkedListNode returnKthToLastRecursive(LinkedListNode head, int k) {
		Index index = new Index();
		return returnKthToLastRecursive(head, k, index);
	}
	public static LinkedListNode returnKthToLastRecursive(LinkedListNode head, int k, Index index){
		if (head == null) {
			return null;
		} else {
			LinkedListNode node = returnKthToLastRecursive(head.next, k, index);
			index.value ++;
			if (index.value == k )
				return head;
			return node;
		}

	}
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 4, 5, 6};
		LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
		for (int i = 0; i <= array.length + 1; i++) {
			LinkedListNode node = returnKthToLastRecursive(head, i);
			String nodeValue = node == null ? "null" : "" + node.data;
			System.out.println(i + ": " + nodeValue);
		}
	}
}
/*
 * Space Complexity O(N) 
 * Time Complexity O(N) where N is the number of elements in the linked list
 * 
*/