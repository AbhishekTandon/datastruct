package datastruct.personal.permutation;

public class ChessBoard {

	private static int LENGTH = 4;
	private static int[] board = new int[LENGTH];

	public static void main(String[] args) {
		populate_board(board, 0);

	}

	static boolean populate_board(int[] board, int col) {

		if (col == LENGTH) {
			StringBuilder buffer = new StringBuilder();
			for (int i = 0;  i < LENGTH; i++) buffer.append(board[i]).append(" ");
			System.out.println("rows of chess board >> " + buffer.toString());

			for (int y = 0; y < LENGTH; y++) {
				for (int x = 0; x < LENGTH; x++) {
					System.out.print((board[y] == x) ? "|Q" : "|_");
				}
				System.out.println("|");
			}
			System.out.println("++++++++++++++++++++++++++++++++++++++++++ \n\n" );
		}

		for (int row = 0; row < LENGTH; row++) {
			if (is_safe(board, col, row)) {
				board[col] = row;
				populate_board(board, col + 1);
			} else {
				continue;
			}
		}

		return false;
	}

	static boolean is_safe(int[] board, int col, int row) {
		boolean flag = true;

		// check for diagonal element
		for (int i = 0; i < col; i++) if (Math.abs(row - board[i]) == col - i) return false;
		// check whether in the same row
		for (int i = 0; i < col; i++) if (row == board[i]) return false;

		// Need not check for the same row because of the assumption in underlying data-structure

		return flag;
	}

}