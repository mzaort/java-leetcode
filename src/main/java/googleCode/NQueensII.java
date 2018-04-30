package googleCode;

public class NQueensII {
	public int totalNQueens(int n) {
		assert (n > 0);
		return dfs(new int[n], 0);
	}

	private int dfs(int[] board, int cur) {
		if (cur == board.length) return 1;

		int res = 0;
		for (int i = 0; i < board.length; i++) {
			if (!isCollided(board, cur, i)) {
				board[cur] = i;
				res += dfs(board, cur + 1);
			}
		}
		return res;
	}

	private boolean isCollided(int[] board, int i, int j) {
		for (int k = 0; k < i; k++) {
			if (board[k] == j || j - i == board[k] - k || j + i == board[k] + k) { return true; }
		}
		return false;
	}
}
