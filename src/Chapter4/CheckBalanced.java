package Chapter4;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

public class CheckBalanced {
	// height of tree: 0,1,2,3,4...
	public static int getHeight(TreeNode root) {
		if (root == null) {
			return -1;
		}
		int leftHeight = getHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;// Pass error up
		
		int rightHeight = getHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;// Pass error up
		
		int diffHeight = Math.abs(leftHeight - rightHeight);
		if (diffHeight > 1)
			return Integer.MIN_VALUE;
		return 1+Math.max(leftHeight, rightHeight);
	}
	
	public static boolean isBalanced(TreeNode root) {
		int height = getHeight(root);
		if (height == Integer.MIN_VALUE)
			return false;
		return true;
	}
		
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Is balanced? " + isBalanced(root));
		
		// Could be balanced, actually, but it's very unlikely...
		TreeNode unbalanced = new TreeNode(10);
		for (int i = 0; i < 10; i++) {
			unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
		}
		System.out.println("Root? " + unbalanced.data);
		System.out.println("Is balanced? " + isBalanced(unbalanced));
	}
}
/*
* Time complexity O(N), Space complexity O(N) while N is the number of nodes in the tree
*/