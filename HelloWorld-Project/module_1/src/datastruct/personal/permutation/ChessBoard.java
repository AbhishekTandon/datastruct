package datastruct.personal.permutation;


/**
 x 0 0 0 0 0 0 0
 0 0 x 0 0 0 0 0
 0 x 0 0 0 0 0 0
 0 0 0 0 0 x 0 0
 0 0 0 0 0 0 0 x
 0 0 0 x 0 0 0 0
 0 0 0 0 0 0 0 0
 0 0 0 0 x 0 0 0
 */
public class ChessBoard {
	static int ROW = 8;
	static int COL = 8;

	public static void main(String[] args) {

		char[][] chess = new char[ROW][COL];

		// initializing the board
		for (int i = 0; i < ROW; i++)
			for (int k = 0; k < COL; k++)
				chess[i][k] = '0';

		for (int r = 0; r < ROW; r++) {
			for (int c = 0; c < COL; c++) {
				if (checkCondition(chess, r, c)) chess[r][c] = 'x';
			}
		}


		for (int r = 0; r < ROW; r++) {
			StringBuilder buffer = new StringBuilder();
			for (int k = 0; k < COL; k++) {
				buffer.append(chess[r][k]);
			}
			System.out.println(buffer);
		}
	}

	public static boolean checkCondition(char[][] chess, int row, int col) {
		// check no entries in the same row
		for (int r = row  ; r >= 0; r--) {
			if (!isEmpty(chess, r, col)) return false;
		}

		// check no entries in the same col
		for (int c = col  ; c >= 0; c--) {
			if (!isEmpty(chess, row, c)) return false;
		}

		//TODO: check another diagnol
		if (row >= col) {
			int c = 0;
			for (int r = row - col; r < ROW; r++) {
				if (!isEmpty(chess, r, c++)) return false;
			}
		} else {
			int r = 0;
			for (int c = col - row; c < COL; c++) {
				if (!isEmpty(chess, r++, c)) return false;
			}
		}

		return true;
	}

	public static boolean isEmpty(char[][] chess, int row, int col) {
		if (chess[row][col] == '0') return true;
		return false;
	}

}
