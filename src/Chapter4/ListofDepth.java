package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListofDepth {
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		
		// We needed this code for other files, so check out the code in the library
		myNode root = myNode.creatMinalTree(array);
		ArrayList<LinkedList<myNode>> result = new ArrayList<LinkedList<myNode>>();
		LinkedList<myNode> currentList = new LinkedList<myNode>();
		currentList.add(root);
		// BFS
		while (!currentList.isEmpty()){
			result.add(currentList);
			LinkedList<myNode> parents = currentList;
			currentList = new LinkedList<myNode>();
			for (myNode parent: parents) {
				//System.out.println(parent.data);
				if (parent.right != null)
					currentList.add(parent.right);
				if (parent.left != null){
					currentList.add(parent.left);
				}
			}
		}
	}
}
