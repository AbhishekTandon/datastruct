package datastruct.personal.permutation;


/**
	refer NQueens for solution
 */
public class ChessBoard {
	static int ROW = 8;
	static int COL = 8;

	public static void main(String[] args) {

		char[][] chess = new char[ROW][COL];

		for (int r = 0; r < ROW; r++) {
			for (int c = 0; c < COL; c++) {
				if (checkCondition(chess, r, c)) {
					put(chess, r, c );
					continue;
				}
			}
		}
		putboard(chess);
	}

	public static boolean checkCondition(char[][] chess, int row, int col) {
		// check no entries in the same col
		for (int r = 0  ; r < ROW; r++) {
			if (!isEmpty(chess, r, col)) {
				return false;
			}
		}

		// check no entries in the same row
		for (int c = 0  ; c < COL; c++) {
			if (!isEmpty(chess, row, c)) {
				return false;
			}
		}

		for (int r = 0; r < ROW; r++) {
			for (int c = 0; c < COL; c++) {
				if (chess[r][c] == 'x' && ( Math.abs(r - row) == Math.abs(c - col)) ) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean isEmpty(char[][] chess, int row, int col) {
		if (chess[row][col] == 'x') return false;
		return true;
	}

	public static void put(char[][] chess, int row, int col) {
		chess[row][col] = 'x';
	}

	public static void putboard(char[][] chess) {
		System.out.println("Printing the chess board solution...");

		for (int y = 0; y < ROW; y++) {
			for (int x = 0; x < ROW; x++) {
				System.out.print((chess[y][x] == 'x') ? "|Q" : "|_");
			}
			System.out.println("|");
		}
	}
}
