package interview2016;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int left = -1, i = 0, sum = 0;
		int res = Integer.MAX_VALUE;
		for (; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s + nums[left + 1]) { // && left < i
				sum -= nums[++left];
			}
			if (sum >= s) {
				res = Math.min(res, i - left);
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
