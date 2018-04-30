package solution;

public class ClimbingStairs {
	public int climbStairs(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n < 0) {
			return -1;
		} else if (n <= 1) {
			return 1;
		} else {
			int[] f = new int[n + 1];
			f[0] = f[1] = 1;
			for (int i = 2; i <= n; i++) {
				f[i] = f[i - 1] + f[i - 2];
			}
			return f[n];
		}
	}
}
