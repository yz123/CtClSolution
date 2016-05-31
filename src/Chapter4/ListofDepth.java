package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListofDepth {
	
	public static ArrayList<LinkedList<myNode>> listOfDepth(myNode root) {
		ArrayList<LinkedList<myNode>> result = new ArrayList<LinkedList<myNode>>();
		LinkedList<myNode> current = new LinkedList<myNode>();
		current.add(root);
		while (!current.isEmpty()){
			result.add(current);
			LinkedList<myNode> parents = current;
			current = new LinkedList<myNode>();
			for (myNode parent: parents) {
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		
		// We needed this code for other files, so check out the code in the library
		myNode root = myNode.creatMinalTree(array);
		ArrayList<LinkedList<myNode>> result;
		result = listOfDepth(root);
		for (LinkedList<myNode> l : result){
			System.out.print("List:");
			for (myNode n : l){
				System.out.print(" "+n.data);
			}
			System.out.println();
		}
		
	}
}
/*
 * Time complexity O(N), space complexity O(N), N is number of nodes in the binar tree
 */