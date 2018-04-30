package googleCode;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		isSolved(board);
	}

	private boolean isSolved(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (int k = 1; k <= 9; k++) {
						board[i][j] = (char) ('0' + k);
						if (!isCollide(board, i, j) && isSolved(board)) return true;
						board[i][j] = '.'; // Have to;
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean isCollide(char[][] board, int i, int j) {
		for (int k = 0; k < 9; k++)
			if (board[i][k] == board[i][j] && k != j) return true;
		for (int k = 0; k < 9; k++)
			if (board[k][j] == board[i][j] && k != i) return true;
		for (int k1 = i / 3 * 3; k1 < i / 3 * 3 + 3; k1++) {
			for (int k2 = j / 3 * 3; k2 < j / 3 * 3 + 3; k2++) {
				if (board[k1][k2] == board[i][j] && !(k1 == i && k2 == j)) return true;
			}
		}
		return false;
	}
}
