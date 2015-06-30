package com.tandon.datastruct.personal.permutation;

public class KnightTour {

	private static int LENGTH = 8;
	private static int[][] board = new int[LENGTH][LENGTH];

	public static void main(String[] args) {
		boolean flag  = traverse_board(board, 0, 0, 1);

		for (int row = 0; row < LENGTH; row++) {
			StringBuilder buffer = new StringBuilder();
			for (int col = 0; col < LENGTH; col++) {
				buffer.append(board[row][col]).append(" ");
			}
			System.out.println(String.format("row[%s] >> %s", row, buffer.toString()));
		}
	}

	static boolean traverse_board(int[][] board, int row, int col, int move) {

		board[row][col]  = 1;
		if (is_allowed(board, row + 2, col +1)) {
			System.out.println(String.format("from (%s, %s) --> to (%s, %s) ", row, col, row+2, col+1));
			row = row + 2; col = col +1;
			traverse_board(board, row, col, ++move);
		}

		if (is_allowed(board, row + 2, col -1)) {
			System.out.println(String.format("from (%s, %s) --> to (%s, %s) ", row, col, row+2, col-1));
			row = row + 2; col = col - 1;
			traverse_board(board, row, col, ++move);
		}

		if (is_allowed(board, row + 1 , col - 2)) {
			System.out.println(String.format("from (%s, %s) --> to (%s, %s) ", row, col, row+1, col-2));
			row = row + 1; col = col - 2;
			traverse_board(board, row, col, ++move);
		}

		if (is_allowed(board, row - 1 , col - 2)) {
			System.out.println(String.format("from (%s, %s) --> to (%s, %s) ", row, col, row-1, col-2));
			row = row - 1; col = col - 2;
			traverse_board(board, row, col, ++move);
		}

		if (is_allowed(board, row - 2 , col - 1)) {
			System.out.println(String.format("from (%s, %s) --> to (%s, %s) ", row, col, row-2, col-1));
			row = row - 2; col = col - 1;
			traverse_board(board, row, col,  ++move);
		}

		if (is_allowed(board, row - 2 , col + 1)) {
			System.out.println(String.format("from (%s, %s) --> to (%s, %s) ", row, col, row-2, col+1));
			row = row - 2; col = col + 1;
			traverse_board(board, row, col,  ++move);
		}

		if (is_allowed(board, row - 1, col + 2)) {
			System.out.println(String.format("from (%s, %s) --> to (%s, %s) ", row, col, row-1, col+2));
			row = row - 1; col = col + 2;
			traverse_board(board, row, col,  ++move);
		}

		if (is_allowed(board, row + 1 , col + 2)) {
			System.out.println(String.format("from (%s, %s) --> to (%s, %s) ", row, col, row+1, col+2));
			row = row + 1; col = col + 2;
			traverse_board(board, row, col,  ++move);
		}

		if (move == LENGTH * LENGTH) return true;
		else return false;
	}




	static boolean is_allowed(int[][] board, int row, int col) {
		if (row >= 0 && row < LENGTH && col >= 0 && col < LENGTH && (board[row][col] == 0) ) return true;
		else  return false;
	}

}