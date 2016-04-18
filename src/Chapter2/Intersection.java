package Chapter2;

import java.util.HashSet;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Intersection {
	public static LinkedListNode findIntersection (LinkedListNode list1, LinkedListNode list2) {
		HashSet<LinkedListNode> container = new HashSet<LinkedListNode>();
		while (list2 != null) {
			container.add(list2);
			list2 = list2.next;
		}
		while (list1 != null) {
			if (container.contains(list1)) {
				return list1;
			}
			list1 = list1.next;
		}
		return null;
		
	}
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
		LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);
		
		int[] vals2 = {12, 14, 15};
		LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);
		
		list2.next.next = list1.next.next.next.next;
		
		System.out.println(list1.printForward());
		System.out.println(list2.printForward());
		
		
		LinkedListNode intersection = findIntersection(list1, list2);
		
		System.out.println(intersection.printForward());
	}
}
/*
 * Space Complexity O(N2) where N2 is the number of elements in the second linked list
 * Time Complexity O(N1) where N1 is the number of elements in the first linked list, this
 * is because the method contain of HashSet runs on O(1) time complexity
 * 
*/
