package interview2015Summer;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		isSolved(board);
	}

	private boolean isSolved(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						board[i][j] = c;
						if (isAllowed(board, i, j) && isSolved(board)) return true;
					}
					board[i][j] = '.'; // Have to;
					return false;
				}
			}
		}
		return true;
	}

	private boolean isAllowed(char[][] board, int i, int j) {
		for (int k = 0; k < 9; k++)
			if (board[i][k] == board[i][j] && k != j) return false;
		for (int k = 0; k < 9; k++)
			if (board[k][j] == board[i][j] && k != i) return false;
		for (int ifrm = i / 3 * 3, iend = ifrm + 3, k1 = ifrm; k1 < iend; k1++) {
			for (int jfrm = j / 3 * 3, jend = jfrm + 3, k2 = jfrm; k2 < jend; k2++) {
				if (board[i][j] == board[k1][k2] && !(k1 == i && k2 == j)) return false;
			}
		}
		return true;
	}
}
