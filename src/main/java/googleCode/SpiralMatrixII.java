package googleCode;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		assert (n >= 0);

		int[][] res = new int[n][n];
		int[] num = { n, n - 1 };
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int k = 1;
		int x = 0, y = -1;
		while (true) {
			for (int i = 0; i < 4; i++) {
				int f = i & 1;
				if (num[f] == 0) return res;
				for (int j = 0; j < num[f]; j++) {
					x += dir[i][0];
					y += dir[i][1];
					res[x][y] = k++;
				}
				num[f]--;
			}
		}
	}
}
