package interview2018;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		isSolvable(board, find(board, 0, 0));
	}

	private boolean isSolvable(char[][] board, int[] point) {
		if (point == null) return true;

		int i = point[0], j = point[1];
		for (char ch = '1'; ch <= '9'; ch++) {
			board[i][j] = ch;
			if (!isCollide(board, i, j) && isSolvable(board, find(board, i, j))) return true;
			board[i][j] = '.';
		}
		return false;
	}

	private boolean isCollide(char[][] board, int i, int j) {
		for (int k = 0; k < 9; k++)
			if ((k != j && board[i][k] == board[i][j]) || (k != i && board[k][j] == board[i][j])) return true;
		for (int k1 = i / 3 * 3; k1 < i / 3 * 3 + 3; k1++) {
			for (int k2 = j / 3 * 3; k2 < j / 3 * 3 + 3; k2++) {
				if ((!(k1 == i && k2 == j)) && board[k1][k2] == board[i][j]) return true;
			}
		}
		return false;
	}

	private int[] find(char[][] board, int i, int j) {
		for (; j < 9 && board[i][j] != '.'; j++);
		if (j < 9) return new int[] { i, j };
		for (; i < 9; i++) {
			for (j = 0; j < 9; j++)
				if (board[i][j] == '.') return new int[] { i, j };
		}
		return null;
	}

	public static void main(String[] args) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		SudokuSolver ss = new SudokuSolver();
		ss.solveSudoku(board);
		for (int i = 0; i < board.length; i++) {
			System.out.println(board[i]);
		}
	}
}
