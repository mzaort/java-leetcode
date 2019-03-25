package interview2018;

public class JumpGameII {
	public int jump(int[] nums) {
		int step = 0;
		int limit = 0, right = 0;
		for (int i = 0; i <= limit && right < nums.length - 1;) {
			step++;
			for (; i <= limit; i++)
				right = Math.max(right, nums[i] + i);
			if (right == limit) return -1;
			limit = right;
		}
		return right >= nums.length - 1 ? step : -1;
	}

	public static void main(String[] args) {
		JumpGameII jg2 = new JumpGameII();
		System.out.println(jg2.jump(new int[] { 2, 3, 1, 1, 4 }));
	}
}
