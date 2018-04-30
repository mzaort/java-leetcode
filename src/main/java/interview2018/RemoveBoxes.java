package interview2018;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/remove-boxes/discuss/101310/java-top-down-and-bottom-up-dp-solutions
public class RemoveBoxes {

	public int removeBoxes(int[] boxes) {
		int[] res = { 0 };
		dfs(boxes, new boolean[boxes.length], 0, res);
		return res[0];
	}

	private void dfs(int[] boxes, boolean[] flag, int curMax, int[] max) {
		PriorityQueue<int[]> queue = find(boxes, flag);
		if (queue.isEmpty()) {
			max[0] = Math.max(max[0], curMax);
		} else {
			int c = count(flag);
			if (curMax + c * c <= max[0]) return;
			int[] e = null;

			while ((e = queue.poll()) != null) {
				List<Integer> list = markFlag(flag, e);
				dfs(boxes, flag, curMax + e[1] * e[1], max);
				unmarkFlag(flag, list);
			}
		}
	}

	private int count(boolean[] flag) {
		int res = 0;
		for (int i = 0; i < flag.length; i++)
			res += flag[i] ? 0 : 1;
		return res;
	}

	private void unmarkFlag(boolean[] flag, List<Integer> list) {
		list.stream().forEach(e -> flag[e] = false);
	}

	private List<Integer> markFlag(boolean[] flag, int[] e) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = e[0], count = e[1]; count > 0; i++) {
			if (!flag[i]) {
				flag[i] = true;
				count--;
				res.add(i);
			}
		}
		return res;
	}

	private PriorityQueue<int[]> find(int[] boxes, boolean[] flag) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> e2[1] - e1[1]);
		int count = 0, previous = -1, start = -1;
		for (int i = 0; i < flag.length; i++) {
			if (!flag[i]) {
				if (count == 0 || previous != boxes[i]) {
					if (count > 0) queue.add(new int[] { start, count });
					previous = boxes[i];
					start = i;
					count = 1;
				} else count++;
			}
		}
		if (count > 0) queue.add(new int[] { start, count });
		return queue;
	}

	public int removeBoxes2(int[] boxes) {
		int n = boxes.length;
		int[][][] fv = new int[n][n][n];
		return f(fv, 0, n - 1, 0, boxes);
	}

	private int f(int[][][] fv, int i, int j, int k, int[] boxes) {
		if (fv[i][j][k] == 0) {
			if (i > j) fv[i][j][k] = 0;
			else if (i == j) fv[i][j][k] = (k + 1) * (k + 1);
			else {
				int max = f(fv, i, j - 1, 0, boxes) + (k + 1) * (k + 1);
				for (int h = i; h < j; h++) {
					if (boxes[h] == boxes[j]) {
						max = Math.max(max, f(fv, i, h, k + 1, boxes) + f(fv, h + 1, j - 1, 0, boxes));
					}
				}
				fv[i][j][k] = max;
			}
		}
		return fv[i][j][k];
	}

	public static void main(String[] args) {
		// int[] val = { 1, 3, 2, 2, 2, 3, 4, 3, 1 };
		int[] val = { 1, 3, 2, 2, 2, 3, 4, 3, 1 };
		RemoveBoxes rb = new RemoveBoxes();
		System.out.println(rb.removeBoxes2(val));
	}
}
