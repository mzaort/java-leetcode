package interview2015Summer;

import java.util.Arrays;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		final int L = 9, E = 1, NE = 0;
		assert (board.length == L && board[0].length == L);

		int[] f = new int[L];
		for (int i = 0; i < L; i++) {
			Arrays.fill(f, NE);
			for (int j = 0; j < L; j++) {
				if (board[i][j] == '.') continue;
				if (board[i][j] < '1' || board[i][j] > '9' || f[board[i][j] - '1'] == E) return false;
				f[board[i][j] - '1'] = E;
			}
		}
		for (int j = 0; j < L; j++) {
			Arrays.fill(f, NE);
			for (int i = 0; i < L; i++) {
				if (board[i][j] == '.') continue;
				if (board[i][j] < '1' || board[i][j] > '9' || f[board[i][j] - '1'] == E) return false;
				f[board[i][j] - '1'] = E;
			}
		}
		final int K = 3;
		for (int k1 = 0; k1 < K; k1++) {
			for (int k2 = 0; k2 < K; k2++) {
				Arrays.fill(f, NE);
				for (int ifrm = k1 * K, iend = (k1 + 1) * K, i = ifrm; i < iend; i++) {
					for (int jfrm = k2 * K, jend = (k2 + 1) * K, j = jfrm; j < jend; j++) {
						if (board[i][j] == '.') continue;
						if (board[i][j] < '1' || board[i][j] > '9' || f[board[i][j] - '1'] == E) return false;
						f[board[i][j] - '1'] = E;
					}
				}
			}
		}
		return true;
	}
}
