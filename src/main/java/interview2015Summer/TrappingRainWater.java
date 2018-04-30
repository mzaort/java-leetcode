package interview2015Summer;

import java.util.LinkedList;

public class TrappingRainWater {
	public int trap(int[] A) {
		int res = 0;

		class Pair {
			int height;
			int pos;

			public Pair(int height, int pos) {
				super();
				this.height = height;
				this.pos = pos;
			}
		}

		LinkedList<Pair> stack = new LinkedList<>();
		for (int i = 0; i < A.length; i++) {
			Pair top = null;
			int height = 0;
			while ((top = stack.peek()) != null && top.height >= A[i]) {
				res += (i - top.pos - 1) * (top.height - height);
				height = top.height;
				stack.poll();
			}
			if ((top = stack.peek()) != null) res += (i - top.pos - 1) * (A[i] - height);
			stack.push(new Pair(A[i], i));
		}
		return res;
	}

	public int trap2(int[] A) {
		int res = 0;
		LinkedList<int[]> stack = new LinkedList<>();
		for (int i = 0; i < A.length; i++) {
			int[] top = null;
			int height = 0;
			while ((top = stack.peek()) != null && top[0] >= A[i]) {
				res += (i - top[1] - 1) * (top[0] - height);
				height = top[0];
				stack.poll();
			}
			if ((top = stack.peek()) != null) res += (i - top[1] - 1) * (A[i] - height);
			stack.push(new int[] { A[i], i });
		}
		return res;
	}
}
