package interview2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		assert (n > 0);
		List<List<String>> res = new ArrayList<>();

		int[] loc = new int[n];
		Arrays.fill(loc, -1);
		LinkedList<Integer> stack = new LinkedList<>();
		stack.push(0);

		Integer i = null;
		while ((i = stack.poll()) != null) {
			if (i == n) {
				char[] chrs = new char[n];
				Arrays.fill(chrs, '.');
				List<String> list = new ArrayList<>(n);
				for (int k = 0; k < n; k++) {
					chrs[loc[k]] = 'Q';
					list.add(new String(chrs));
					chrs[loc[k]] = '.';
				}
				res.add(list);
			} else {
				int j = loc[i] + 1;
				for (; j < n && isCollided(loc, i, j); j++);
				if (j < n) {
					loc[i] = j;
					stack.push(i);
					if (i + 1 < n) loc[i + 1] = -1;
					stack.push(i + 1);
				}
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

	public static void main(String[] args) {
		NQueens nq = new NQueens();
		List<List<String>> res = nq.solveNQueens(8);
		for (List<String> list : res) {
			System.out.println(list);
		}
	}
}
