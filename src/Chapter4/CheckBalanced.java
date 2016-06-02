package Chapter4;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

public class CheckBalanced {
	// height of tree: 1,2,3,4...
	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return (1+Math.max(getHeight(root.left), getHeight(root.right)));
	}
	
	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int heightDiff = Math.abs(getHeight(root.left) - getHeight(root.right));
		if (heightDiff > 1) {
			return false;
		}
		return (isBalanced(root.left) && isBalanced(root.right));
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
* Time complexity O(Nlog(N)), N is the number of nodes in the tree
*/