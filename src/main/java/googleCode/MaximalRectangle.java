package googleCode;

public class MaximalRectangle {
	public int maximalRectangle(char[][] A) {
		if (A.length == 0 || A[0].length == 0) return 0;
		int row = A.length, col = A[0].length;
		int[][] r = new int[row][col];
		for (int i = 0; i < row; i++)
			r[i][col - 1] = A[i][col - 1] == '0' ? 0 : 1;
		for (int i = 0; i < row; i++) {
			for (int j = col - 2; j >= 0; j--)
				r[i][j] = A[i][j] == '0' ? 0 : r[i][j + 1] + 1;
		}
		boolean[][] flag = new boolean[row][col];
		int ans = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (A[i][j] == '1' && !flag[i][j]) {
					int width = Integer.MAX_VALUE;
					for (int k = i, h = 1; k < row && A[i][j] == '1'; k++, h++) {
						if (r[i][j] <= width) {
							width = r[i][j];
							flag[i][j] = true;
						}
						ans = Math.max(ans, h * width);
					}
				}
			}
		}
		return ans;
	}
}
