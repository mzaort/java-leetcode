package interview2015Summer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueensII {
	public int totalNQueens(int n) {
		assert (n > 0);
		return dfs(new int[n], 0);
	}

	private int dfs(int[] Q, int cur) {
		if (cur == Q.length) return 1;
		int res = 0;
		for (int j = 0; j < Q.length; j++) {
			if (!isCollide(Q, cur, j)) {
				Q[cur] = j;
				res += dfs(Q, cur + 1);
			}
		}
		return res;
	}

	private boolean isCollide(int[] Q, int i, int j) {
		for (int k = 0; k < i; k++) {
			if (j == Q[k] || j - i == Q[k] - k || j + i == Q[k] + k) return true;
		}
		return false;
	}

	public int totalNQueens2(int n) {
		assert (n > 0);
		int res = 0;
		LinkedList<List<Integer>> queue = new LinkedList<>();
		queue.add(new ArrayList<>());
		List<Integer> front = null;
		while (null != (front = queue.poll())) {
			if (front.size() == n) res++;
			else {
				for (int j = 0; j < n; j++) {
					if (!isCollide(front, front.size(), j)) {
						List<Integer> list = new ArrayList<>(front);
						list.add(j);
						queue.add(list);
					}
				}
			}
		}
		return res;
	}

	private boolean isCollide(List<Integer> Q, int i, int j) {
		for (int k = 0; k < i; k++) {
			int kt = Q.get(k);
			if (j == kt || j - i == kt - k || j + i == kt + k) return true;
		}
		return false;
	}
}
