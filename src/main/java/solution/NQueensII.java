package solution;

public class NQueensII {
	public int totalNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 0) return 0;
		int[] loc = new int[n];
		return dfsQueues(loc, 0);
	}

	private int dfsQueues(int[] loc, int cur) {
		if (cur == loc.length) {
			return 1;
		} else {
			int res = 0;
			for (int i = 0; i < loc.length; i++) {
				if (!isCollide(loc, cur, i)) {
					loc[cur] = i;
					res += dfsQueues(loc, cur + 1);
				}
			}
			return res;
		}
	}

	private boolean isCollide(int[] loc, int cur, int i) {
		for (int j = 0; j < cur; j++) {
			if (loc[j] == i) return true;
			if (loc[j] + j == cur + i) return true;
			if (loc[j] - j == i - cur) return true;
		}
		return false;
	}
}
