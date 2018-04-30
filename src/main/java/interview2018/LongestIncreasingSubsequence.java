package interview2018;

import java.util.TreeSet;

public class LongestIncreasingSubsequence {

	public int lengthOfLIS2(int[] nums) {
		if (nums.length == 0) return 0;

		int r = 0;
		int[] f = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int j = findLeft(f, 0, r - 1, nums[i]);
			if (j + 1 == r) f[r++] = nums[i];
			else if (f[j + 1] > nums[i]) f[j + 1] = nums[i];
		}
		return r;
	}

	private int findLeft(int[] f, int i, int j, int value) {
		while (i <= j) {
			int mid = i + ((j - i) >>> 1);
			if (value > f[mid]) i = mid + 1;
			else j = mid - 1;
		}
		return j;
	}

	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) return 0;

		int[] f = new int[nums.length];
		TreeSet<Integer> set = new TreeSet<Integer>((e1, e2) -> nums[e1] - nums[e2]);

		int max = 1;
		for (int i = 0; i < f.length; i++) {
			if (set.contains(i)) set.remove(i); // lol
			f[i] = 1;
			for (int j : set.headSet(i)) {
				f[i] = Math.max(f[i], f[j] + 1);
			}
			max = Math.max(max, f[i]);
			set.add(i);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12 };
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.lengthOfLIS(nums));
	}
}
