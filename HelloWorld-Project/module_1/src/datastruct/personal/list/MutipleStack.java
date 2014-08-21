package datastruct.personal.list;

public class MutipleStack {

	String[][] list;
	int size;
	int stack;
	int top;

	public MutipleStack(int n) {
		size = n;
		stack = 1;
		top = -1;
		list = new String[stack][size];
	}

	public MutipleStack() {
		this(10);
	}

	public void push(String in) {
		if (top == size -1 ) addCapacity();
		list[stack - 1][++top] = in;
	}

	public String pop() {
		if (top < 0) reduceCapacity();
		return list[stack  - 1][top--];
	}


	private void addCapacity() {
		System.out.println("adding capacity");
		int y = stack + 1;
		String[][] tmp = new String[y][size];

		// copy content from smaller array to bigger one
		for (int i = 0; i < stack; i++)
			for (int k = 0; k < size; k++)
				tmp[i][k] = list[i][k];

		// point storage to bigger array
		list = tmp;
		// increase stack pointer
		++stack;

		// point top to starting point
		top  = -1;
	}

	public void reduceCapacity() {
		System.out.println("removing capacity");
		int y = stack - 1;
		String[][] tmp = new String[y][size];

		// copy content from smaller array to bigger one
		for (int i = 0; i < y; i++)
			for (int k = 0; k < size; k++)
				tmp[i][k] = list[i][k];

		// point storage to bigger array
		list = tmp;
		// increase stack pointer
		--stack;

		// point top to starting point
		top  = size -1;
	}


	public static void main(String[] args) {
		MutipleStack stack = new MutipleStack(4);
		int size = 10;
		for (int i = 0; i < size; i++) {
			stack.push("some string " + i);
		}



		for (int i = 0; i < size; i++) {
			String ret = stack.pop();
			System.out.println("outputting the response >>" + ret);
		}

		System.out.println("Stop point");
	}

}
