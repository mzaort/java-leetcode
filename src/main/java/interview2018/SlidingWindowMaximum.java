package interview2018;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.TreeSet;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || k == 0) return new int[0];
		int[] res = new int[nums.length - k + 1];
		TreeSet<Integer> set = new TreeSet<>((e1, e2) -> {
			if (e1 == e2) return 0;
			if (nums[e1] == nums[e2]) return e1 - e2;
			else return nums[e1] - nums[e2];
		});
		for (int i = 0; i < k - 1; i++) {
			set.add(i);
		}
		for (int i = k - 1, j = 0; i < nums.length; i++, j++) {
			set.add(i);
			res[j] = nums[set.last()];
			set.remove(j);
		}
		return res;
	}

	public int[] maxSlidingWindow2(int[] nums, int k) {
		if (nums.length == 0 || k == 0) return new int[0];
		int[] res = new int[nums.length - k + 1];

		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) deque.pollFirst();
			while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
				deque.pollLast();
			deque.addLast(i);
			if (i - k + 1 >= 0) res[i - k + 1] = nums[deque.peekFirst()];
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		SlidingWindowMaximum swm = new SlidingWindowMaximum();
		Arrays.stream(swm.maxSlidingWindow2(nums, 3)).forEach(System.out::println);
	}
}
