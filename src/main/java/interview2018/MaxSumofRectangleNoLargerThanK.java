package interview2018;

import java.util.TreeSet;

public class MaxSumofRectangleNoLargerThanK {
	// mmnlgn
	public int maxSumSubmatrix(int[][] matrix, int k) {
		if (matrix.length == 0 || matrix[0].length == 0) return 0;

		int max = Integer.MIN_VALUE;
		int row = matrix.length, col = matrix[0].length;
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < row; i++) {
			int[] acc = new int[col];
			for (int i2 = i; i2 < row; i2++) {
				for (int j = 0; j < col; j++)
					acc[j] += matrix[i2][j];
				set.clear();
				set.add(0);
				int v = 0;
				for (int j = 0; j < col; j++) {
					v += acc[j];
					Integer h = set.ceiling(v - k);
					if (h != null) {
						max = Math.max(max, v - h);
					}
					set.add(v);
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 0, 1 }, { 0, -2, 3 } };
		MaxSumofRectangleNoLargerThanK msr = new MaxSumofRectangleNoLargerThanK();
		System.out.println(msr.maxSumSubmatrix(matrix, 2));
	}
}
