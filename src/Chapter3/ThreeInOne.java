package Chapter3;

public class ThreeInOne {
	// the container of stacks
	private int array[];
	private static int low1;
	private static int low2;
	private static int low3;
	private static int up1;
	private static int up2;
	private static int up3;
	private static int index1;
	private static int index2;
	private static int index3;
	private static boolean full1;
	private static boolean full2;
	private static boolean full3;
	// constructor of the class
	public ThreeInOne(int array[]) {
		if (array.length < 3 ) {
			System.out.println("Exception: array length not enough");
		}
		this.array = array;
		
		ThreeInOne.low1 = 0;
		ThreeInOne.up1 = array.length/3-1;
		ThreeInOne.index1 = ThreeInOne.low1-1;
		ThreeInOne.full1 = false;
		
		ThreeInOne.low2 = array.length/3;
		ThreeInOne.up2 = array.length*2/3-1;
		ThreeInOne.index2 = ThreeInOne.low2-1;
		ThreeInOne.full2 = false;
		
		ThreeInOne.low3 = array.length*2/3;
		ThreeInOne.up3 = array.length-1;
		ThreeInOne.index3 = ThreeInOne.low3-1;
		ThreeInOne.full3 = false;
		
	} 
	// Stack 1
	public void push1(int i) throws Exception {
		if (index1 < ThreeInOne.up1) {
			index1 ++;
			this.array[index1] = i;
		} else if (index1 == ThreeInOne.up1) {
			index1 ++;
			this.array[index1] = i;
			ThreeInOne.full1 = true;
		} else {
			throw new Exception();
		}
	}
	public boolean isEmpty1(){
		if (index1<low1) {
			return true;
		} else {
			return false;
		}
	}
	
	public int pop1() throws Exception{
		if (isEmpty1()) {
			throw new Exception();
		} else {
			int i = this.array[index1];
			index1 --;
			return i; 
		}
	}
	
	public int peek1() throws Exception {
		if (isEmpty1()) {
			throw new Exception();
		} else {
			int i = this.array[index1];
			return i; 
		}
	}
	
	// Stack2
	
	// Stack3

	public static void main(String args[]) throws Exception {
		System.out.println("hello world");
		int array[] = new int[120];
		ThreeInOne three = new ThreeInOne(array);
		three.push1(4);
		three.push1(5);
		System.out.println(three.pop1());
		System.out.println(three.pop1());
		System.out.println(three.isEmpty1());
	}

}
