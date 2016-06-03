package Chapter4;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

public class ValidateBST {
	public static int maxBST(TreeNode root) {
		if (root == null)
			return 0;
		int middle = root.data;
		int left = 0;
		int right = 0;
		if (root.left != null) {
			left = root.left.data;
			if (left > middle)
				return Integer.MAX_VALUE;
		}
		if (root.right != null) {
			right = root.right.data;
			if (right < middle)
				return Integer.MAX_VALUE;
		}
		return Math.max(maxBST(root.left), maxBST(root.right));
	}
	public static boolean isBST(TreeNode root) {
		if (maxBST(root) == Integer.MAX_VALUE)
			return false;
		else
			return true;
	}
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Is balanced? " + isBST(root));
		
		// Could be balanced, actually, but it's very unlikely...
		TreeNode unbalanced = new TreeNode(10);
		for (int i = 0; i < 10; i++) {
			unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
		}
		System.out.println("Root? " + unbalanced.data);
		System.out.println("Is balanced? " + isBST(unbalanced));
	}
}
