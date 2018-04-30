package interview2018;

import java.util.Arrays;

public class PerfectSquares {

	public int numSquares3(int n) {
		while (n % 4 == 0) {
			n /= 4;
		}
		if (n % 8 == 7) return 4;
		for (int a = 0; a * a <= n; ++a) {
			int b = (int) Math.sqrt(n - a * a);
			if (a * a + b * b == n) { return (a == 0 ? 0 : 1) + (b == 0 ? 0 : 1); }
		}
		return 3;
	}

	public int numSquares2(int n) {
		if (n <= 0) return 0;

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 0, j = i * i; j <= n; i++, j = i * i) {
			dp[j] = 1;
		}
		for (int i = 0; i <= n; i++) {
			for (int j = 0, h = j * j; i + h <= n; j++, h = j * j) {
				dp[i + h] = Math.min(dp[i] + 1, dp[i + h]);
			}
		}
		return dp[n];
	}

	public int numSquares(int n) {
		if (n <= 0) return 0;

		int mMax = (int) (Math.sqrt(n));
		int[][] map = new int[n + 1][mMax + 1];
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], -1);
		}
		return f(n, mMax, map);
	}

	private int f(int n, int mMax, int[][] map) {
		if (map[n][mMax] == -1) {
			if (n == 0 || mMax == 0) map[n][mMax] = 0;
			else if (mMax == 1) map[n][mMax] = n;
			else {
				int min = n;
				for (int step = mMax * mMax, i = n / step; i >= 0; i--) {
					min = Math.min(min, i + f(n - i * step, mMax - 1, map));
				}
				map[n][mMax] = min;
			}
		}

		return map[n][mMax];
	}

	public static void main(String[] args) {
		PerfectSquares ps = new PerfectSquares();
		ps.numSquares(6);
	}
}
