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
		System.out.println("empty");
		return true;
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Is BST? " + isBST(root));
		
		// Could be balanced, actually, but it's very unlikely...
		TreeNode unbalanced = new TreeNode(10);
		for (int i = 0; i < 10; i++) {
			unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
		}
		System.out.println("Root? " + unbalanced.data);
		System.out.println("Is BST? " + isBST(unbalanced));
	}
}
