package Chapter3;

public class ThreeInOne {
	// this question aims to create three stacks out of one array
	// however, our solution can be generalized to multiple stacks
	private int stackCapacity;
	private int numOfStacks = 3;
	private int size[];
	private int array[];

	public ThreeInOne(int stackCapacity) {
		this.stackCapacity = stackCapacity;
		this.array = new int[numOfStacks*stackCapacity];
		this.size = new int[numOfStacks];
		
	} 
	// Stack 1
	public void push(int stackNum, int element) throws FullStackException {
		if (isFull(stackNum)) {
			throw new FullStackException();
		}
		size[stackNum]++;
		array[topOfStack(stackNum)] = element;		
	}
	
	public int pop(int stackNum) throws StackEmptyException{
		if (isEmpty(stackNum)) {
			throw new StackEmptyException();
		}
		int element = array[topOfStack(stackNum)];
		size[stackNum]--;
		return element;
	}
	
	public int peek(int stackNum)throws StackEmptyException{
		if (isEmpty(stackNum)) {
			throw new StackEmptyException();
		}
		int element = array[topOfStack(stackNum)];
		return element;
	}
	
	public boolean isFull(int stackNum) {
		if (size[stackNum] == this.stackCapacity) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isEmpty(int stackNum){
		if (size[stackNum] == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int topOfStack(int stackNum) {
		int offset = stackNum*stackCapacity;
		return offset+size[stackNum]-1;
	}

	public static void main(String args[]) throws Exception {
		ThreeInOne stack = new ThreeInOne(60);
		stack.push(0, 5);
		stack.push(0, 6);
		System.out.println(stack.pop(0));
		System.out.println(stack.pop(0));
	}

}
