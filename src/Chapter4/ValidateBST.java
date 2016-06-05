package Chapter4;

import java.util.LinkedList;
import java.util.Queue;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

public class ValidateBST {

	public static void inOrder(TreeNode root, Queue<Integer> q) {
		if (root !=null) {
			inOrder(root.left, q);
			q.add(root.data);
			inOrder(root.right, q);
		}
	}
	
	public static boolean isBST(TreeNode root) {
		Queue<Integer> q = new LinkedList<Integer>();
		inOrder(root, q);
		int data = 0;
		if (!q.isEmpty())
			data = q.poll();
		else 
		{
			return true;
		}
		while(!q.isEmpty()) {
			if (data > q.peek())
				return false;
			data = q.poll();
		}
		//System.out.println("empty");
		return true;
	}
	
	public static void main(String[] args) {
		int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
		TreeNode node = TreeNode.createMinimalBST(array);
		//node.left.data = 5;
		//node.left.right.data = 3;
		System.out.println(isBST(node));

		test();
	}

	public static void test() {
		TreeNode node;
		boolean condition;
		System.out.println("test cases for equals condition.");

		/* Expect true: for left child: node.data <= last_printed.
   2
  / \
 /   \
 2   3
      \
      4
		*/
		int[] array2 = {1, 2, 3, 4};
		node = TreeNode.createMinimalBST(array2);
		node.left.data = 2;
		node.print();
		//last_printed = null;
		condition = isBST(node);
		System.out.println("should be true: " + condition);

		/* Expect false: for right child: node.data <= last_printed.
   2
  / \
 /   \
 1   2
      \
      4
		 */
		int[] array3 = {1, 2, 3, 4};
		node = TreeNode.createMinimalBST(array3);
		node.right.data = 2;
		node.print();
		//last_printed = null;
		condition = isBST(node);
		System.out.println("should be false: " + condition);
	}
}

/*
 * performance: time complexity O(n), space complexity O(n)
 * weakness: need extra space, cannot handle duplicate values
 * to do: build off property that LEFT <= CURRENT < RIGHT 
 */