package Chapter4;


public class MinimalTree {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		
		// We needed this code for other files, so check out the code in the library
		myNode root = myNode.creatMinalTree(array);
		System.out.println("Root? " + root.data);
		//System.out.println("Created BST? " + root.isBST());
		System.out.println("Height: " + root.height());
	}

}
