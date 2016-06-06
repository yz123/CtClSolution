package Chapter4;

import CtCILibrary.TreeNode;

public class ValidateBST_recursion {
	static Integer lastPrint;
	public static boolean isBST(TreeNode n) {
		// LEFT <= CURRENT < RIGHT 
		if (n == null)
			return true;
		// LEFT
		if(!isBST(n.left))
			return false;
		// CURRENT
		if (lastPrint != null && lastPrint >= n.data )
			return false;
		lastPrint = n.data;
		// RIGHT
		if(!isBST(n.right))
			return false;
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