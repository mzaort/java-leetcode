package solutionReview;

public class RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix == null) return;

		int n = matrix.length;
		for (int i = 0, rlen = n; i < n / 2; i++, rlen -= 2) {
			for (int j = i; j < i + rlen - 1; j++) {
				int p1 = i, p2 = j, p3 = rlen - 1 + i, p4 = rlen - 1 - j + 2 * i;
				int tmp = matrix[p1][p2];
				matrix[p1][p2] = matrix[p4][p1];
				matrix[p4][p1] = matrix[p3][p4];
				matrix[p3][p4] = matrix[p2][p3];
				matrix[p2][p3] = tmp;
			}
		}
	}
}