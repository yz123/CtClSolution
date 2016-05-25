package Chapter4;

import java.util.LinkedList;
import java.util.Queue;

import CtCILibrary.TreeNode;

public class myNode {
	public myNode right;
	public myNode left;
	public myNode parent;
	public int data;
	
	public myNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public void addRight(myNode r) {
		this.right = r;
		if (r != null)
			r.parent = this;
	}
	
	public void addLeft(myNode l) {
		this.left = l;
		if (l != null)
			l.parent = this;
	}
	
	public static myNode creatMinalTree(int array[], int start, int end) {
		if (end < start)
			return null;
		int mid = (end + start)/2;
		myNode node = new myNode(array[mid]);
		node.addRight(creatMinalTree(array, start, mid - 1 ));
		node.addLeft(creatMinalTree(array, mid + 1 , end));
		return node;
	}
	
	public static myNode creatMinalTree(int array[]) {
		int start = 0;
		int end = array.length -1;
		return creatMinalTree(array, start, end);
	}
	
	public int height() {
		int leftHeight = this.left == null ? 0: this.left.height() ;
		int rightHeight = this.right == null ? 0:this.right.height();
		return  1 + Math.max(leftHeight, rightHeight);
	}
	
	public static void inOrderTraversal(myNode node, Queue q) {
		if (node != null) {
			inOrderTraversal(node.left, q);
			q.add(node);
			inOrderTraversal(node.right, q);
		}
	} 
	
	public boolean isBST() {
		Queue<myNode> q = new LinkedList<myNode>();
		inOrderTraversal(this, q);
		myNode n = q.peek();
		while(!q.isEmpty()) {
			//System.out.println(" "+q.peek().data);
			if (n.data < q.poll().data)
				break;
		}
		if (q.isEmpty())
			return true;
		else
			return false;
	}
}
