package solution;

public class SurroundedRegions {
	public void solve(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (board == null || board.length == 0 || board[0].length == 0) { return; }
		int xlen = board.length, ylen = board[0].length;
		for (int i = 0; i < xlen; i++) {
			if (board[i][0] == 'O') {
				deepToZ(board, i, 0);
			}
			if (board[i][ylen - 1] == 'O') {
				deepToZ(board, i, ylen - 1);
			}
		}
		for (int j = 1; j < ylen - 1; j++) {
			if (board[0][j] == 'O') {
				deepToZ(board, 0, j);
			}
			if (board[xlen - 1][j] == 'O') {
				deepToZ(board, xlen - 1, j);
			}
		}
		for (int i = 0; i < xlen; i++) {
			for (int j = 0; j < ylen; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == 'Z') {
					board[i][j] = 'O';
				}
			}
		}
	}

	private void deepToZ(char[][] board, int i, int j) {
		board[i][j] = 'Z';
		if (i - 1 >= 0 && board[i - 1][j] == 'O') {
			deepToZ(board, i - 1, j);
		}
		if (j + 1 < board[0].length && board[i][j + 1] == 'O') {
			deepToZ(board, i, j + 1);
		}
		if (i + 1 < board.length && board[i + 1][j] == 'O') {
			deepToZ(board, i + 1, j);
		}
		if (j - 1 >= 0 && board[i][j - 1] == 'O') {
			deepToZ(board, i, j - 1);
		}
	}

	public void solve2(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (board == null || board.length == 0 || board[0].length == 0) { return; }
		int xlen = board.length, ylen = board[0].length;
		for (int i = 0; i < xlen; i++) {
			if (board[i][0] == 'O') {
				board[i][0] = 'Z';
			}
			if (board[i][ylen - 1] == 'O') {
				board[i][ylen - 1] = 'Z';
			}
		}
		for (int j = 1; j < ylen - 1; j++) {
			if (board[0][j] == 'O') {
				board[0][j] = 'Z';
			}
			if (board[xlen - 1][j] == 'O') {
				board[xlen - 1][j] = 'Z';
			}
		}
		for (int i = 1; i < xlen - 1; i++) {
			for (int j = 1; j < ylen - 1; j++) {
				if (board[i][j] == 'O' && (board[i - 1][j] == 'Z' || board[i][j - 1] == 'Z')) {
					board[i][j] = 'Z';
				}
			}
		}
		for (int i = 1; i < xlen - 1; i++) {
			for (int j = ylen - 2; j > 0; j--) {
				if (board[i][j] == 'O' && (board[i - 1][j] == 'Z' || board[i][j + 1] == 'Z')) {
					board[i][j] = 'Z';
				}
			}
		}
		for (int i = xlen - 2; i > 0; i--) {
			for (int j = ylen - 2; j > 0; j--) {
				if (board[i][j] == 'O' && (board[i + 1][j] == 'Z' || board[i][j + 1] == 'Z')) {
					board[i][j] = 'Z';
				}
			}
		}
		for (int i = xlen - 2; i > 0; i--) {
			for (int j = 1; j < ylen - 1; j++) {
				if (board[i][j] == 'O' && (board[i + 1][j] == 'Z' || board[i][j - 1] == 'Z')) {
					board[i][j] = 'Z';
				}
			}
		}
		for (int i = 0; i < xlen; i++) {
			for (int j = 0; j < ylen; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == 'Z') {
					board[i][j] = 'O';
				}
			}
		}
	}
}
