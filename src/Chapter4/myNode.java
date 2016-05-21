package Chapter4;

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
	

}