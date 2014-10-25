package datastruct.permutation;

public class ParenthesesCombination {

	static final int MAX_SIZE = 100;
	static char[] str = new char[MAX_SIZE];

	/* Wrapper over printParenthesis()*/
	static void printParenthesis(int n) {
		if (n > 0) printParenthesis(0, n, 0, 0);
		return;
	}

	static void printParenthesis(int pos, int n, int open, int close) {

		if (close == n) {
			StringBuilder buffer = new StringBuilder();
			for (int i = 0; i < str.length; ++i) {
				buffer.append(str[i]);
			}
			System.out.println(String.format("%s \n", buffer.toString()));
			return;
		} else {
			if (open > close) {
				str[pos] = '}';
				printParenthesis(pos + 1, n, open, close + 1);
			}
			if (open < n) {
				str[pos] = '{';
				printParenthesis(pos + 1, n, open + 1, close);
			}
		}
	}

	/* driver program to test above functions */
	public static void main(String[] main) {
		int n = 4;
		printParenthesis(n);
	}

}
