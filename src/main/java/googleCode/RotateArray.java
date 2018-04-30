package googleCode;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		int L = nums.length, shift = 0;
		if (k < 0) k = L - k;
		if (L == 0 || L == 1 || 0 == (shift = k % L)) return;

		for (int i = 0, j = L - shift - 1; i < j; i++, j--)
			swap(nums, i, j);
		for (int i = L - shift, j = L - 1; i < j; i++, j--)
			swap(nums, i, j);
		for (int i = 0, j = L - 1; i < j; i++, j--)
			swap(nums, i, j);
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public void rotate2(int[] nums, int k) {
		int L = nums.length;
		if (k < 0) k = L - k;
		if (L == 0 || L == 1 || 0 == (k = k % L)) return;

		int circle = gcd(k, L - k);
		for (int i = 0; i < circle; i++) {
			int j = i < L - k ? i + k : i - (L - k), val = nums[i];
			while (j != i) {
				int tmp = nums[j];
				nums[j] = val;
				j = j < L - k ? j + k : j - (L - k);
				val = tmp;
			}
			nums[i] = val;
		}
	}

	private int gcd(int m, int n) {
		if (m > n) return gcd(n, m);
		return n % m == 0 ? m : gcd(n % m, m);
	}
}
