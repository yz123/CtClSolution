package Chapter2;


import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Intersection2 {
	//assume intersection is that two list have nodes in common from i-th and j-th node 
	//separately, but till the end of the two list
	public static class Result{
		public LinkedListNode tail;
		public int length;
		public Result(LinkedListNode tail, int length) {
			this.tail = tail;
			this.length = length;
		}
	}
	public static Result findEndNode(LinkedListNode tail) {
		int length = 1;
		while (tail.next != null) {
			length++;
			tail = tail.next;
		}
		return new Result(tail,length);
	}
	public static LinkedListNode moveNode(LinkedListNode list, int i) {
		while (i > 0) {
			list = list.next;
			i--;
		}
		return list;
	}
	
	public static LinkedListNode findIntersection (LinkedListNode list1, LinkedListNode list2) {
		//find end nodes of the two lists
		Result re1 = findEndNode(list1); 
		Result re2 = findEndNode(list2);
		int length1 = re1.length ;
		int length2 = re2.length;
		LinkedListNode tail1 = re1.tail;
		LinkedListNode tail2 = re2.tail;
		// align two lists
		if (tail1 != tail2) {
			return null;			
		}
		int offset = length1 - length2;
		if (offset >= 0) {
			list1 = moveNode(list1,offset);
		} else {
			list2 = moveNode(list2,-offset);
		}
		// return the first intersection node
		while (list1 != list2) {
			list1 = list1.next;
			list2 = list2.next;
		}
		return list1;		
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
 * Space Complexity O(1) 
 * Time Complexity O(A+B) where A and B are the lengths of the two linked lists
 * 
*/
