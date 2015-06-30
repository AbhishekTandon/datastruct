package com.tandon.datastruct.personal.list;

class TwoStack {
	int[] arr;
	int size;
	int top1, top2;

	public TwoStack(int n) {
		size = n;
		arr = new int[n];
		top1 = -1;
		top2 = size;
	}

	// Method to push an element x to stack1
	public void push1(int x) {
		// There is at least one empty space for new element
		if (top1 < top2 - 1) {
			arr[++top1] = x;
		} else {
			throw new ArrayIndexOutOfBoundsException("Increase the size of the Stack to insert >> " + x);
		}
	}

	// Method to push an element x to stack2
	void push2(int x) {
		// There is at least one empty space for new element
		if (top1 < top2 - 1) {
			arr[--top2] = x;
		} else {
			throw new ArrayIndexOutOfBoundsException("Increase the size of the Stack to insert >> " + x);
		}
	}

	// Method to pop an element from first stack
	int pop1() {
		if (top1 >= 0) {
			int x = arr[top1--];
			return x;
		} else {
			throw new ArrayIndexOutOfBoundsException("No more element inside the stack");
		}
	}

	// Method to pop an element from second stack
	int pop2() {
		if (top2 < size) {
			int x = arr[top2];
			top2++;
			return x;
		} else {
			throw new ArrayIndexOutOfBoundsException("No more element inside the stack");
		}
	}

	public static void main(String[] args) {
		TwoStack stack = new TwoStack(5);
		stack.push1(5);
		stack.push2(10);
		stack.push2(15);
		stack.push1(11);
		stack.push2(7);
		System.out.println("Popped element from stack1 is >>  " + stack.pop1());
		stack.push2(40);
		System.out.println("Popped element from stack2 is >>" + stack.pop2());

		System.out.println("response of the divided integer>>" + 9/2); // lower rounding of the integer
	}

}