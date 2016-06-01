package Chapter4;

import java.util.LinkedList;
import java.util.Queue;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

public class CheckBalanced {
	
	public static boolean isBalanced(TreeNode root) {
		int left = 0;
		int right = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode current = q.poll();
			if (current.right != null) {
				right = current.right.height();
				q.add(current.right);
			}
			if (current.left != null) {
				right = current.left.height();
				q.add(current.left);
			}
			if (right - left > 1)
				return false;
		}
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
