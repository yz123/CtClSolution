package Chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class ListofDepth {
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		
		// We needed this code for other files, so check out the code in the library
		myNode root = myNode.creatMinalTree(array);
		Queue<myNode> q = new LinkedList<myNode>();
		q.add(root);
		while (q != null) {
			myNode current = q.poll();
			if (current != null){
				System.out.println(current.data);
				if (current.right != null)
					q.add(current.right);
				if (current.left != null)
					q.add(current.left);
				}
		}
		
	}

}
