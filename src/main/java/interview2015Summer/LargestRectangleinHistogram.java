package interview2015Summer;

import java.util.LinkedList;

public class LargestRectangleinHistogram {
	// wrong
	public int largestRectangleArea(int[] height) {
		int res = 0;
		LinkedList<int[]> stack = new LinkedList<>();
		for (int i = 0; i < height.length + 1; i++) {
			int h = i < height.length ? height[i] : -1;
			int[] top = null;
			int left = i;
			while (null != (top = stack.peek()) && top[0] >= h) {
				res = Math.max(res, top[0] * (i - top[1]));
				stack.poll();
				i = top[1];
			}
			stack.push(new int[] { h, left });
		}
		return res;
	}
}
