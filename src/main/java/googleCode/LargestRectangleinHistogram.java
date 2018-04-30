package googleCode;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class LargestRectangleinHistogram {

	// wrong 2, 1, 2
	public int largestRectangleArea(int[] height) {
		int ans = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i <= height.length;) {
			int val = i < height.length ? height[i] : 0;
			if (stack.isEmpty() || height[stack.peek()] <= val) {
				stack.push(i++);
			} else {
				int j = stack.poll();
				ans = Math.max(ans, (i - j) * height[j]);
			}
		}
		return ans;

	}

	public int largestRectangleArea2(int[] height) {
		int res = 0;
		ArrayDeque<Integer> hstack = new ArrayDeque<Integer>(height.length + 1);
		ArrayDeque<Integer> pstack = new ArrayDeque<Integer>(height.length + 1);
		for (int i = 0; i <= height.length; i++) {
			int h = i == height.length ? 0 : height[i];
			Integer top = null;
			if ((top = hstack.peek()) == null || top <= h) {
				hstack.push(h);
				pstack.push(i);
			} else {
				int left = 0;
				while ((top = hstack.peek()) != null && top > h) {
					hstack.pop();
					left = pstack.pop();
					res = Math.max(res, (i - left) * top);
				}
				hstack.push(h);
				pstack.push(left);
			}
		}
		return res;
	}
}
