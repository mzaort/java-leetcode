package solution;

public class SetMatrixZeroes {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1 }, { 0, 1, 2 } };
		new SetMatrixZeroes().setZeroes2(matrix);
		int mx = matrix.length;
		int my = matrix[0].length;
		for (int i = 0; i < mx; i++) {
			for (int j = 0; j < my; j++) {
				System.out.println(matrix[i][j]);
			}
		}
	}

	public void setZeroes(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
		int mx = matrix.length;
		int my = matrix[0].length;

		boolean[] xset = new boolean[mx];
		for (int i = 0; i < mx; i++)
			xset[0] = false;

		boolean[] yset = new boolean[my];
		for (int i = 0; i < my; i++)
			yset[0] = false;

		for (int i = 0; i < mx; i++) {
			for (int j = 0; j < my; j++) {
				if (matrix[i][j] == 0) {
					xset[i] = true;
					yset[j] = true;
				}
			}
		}

		for (int i = 0; i < mx; i++) {
			if (xset[i]) {
				for (int j = 0; j < my; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 0; j < my; j++) {
			if (yset[j]) {
				for (int i = 0; i < mx; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public void setZeroes2(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
		int mx = matrix.length;
		int my = matrix[0].length;
		boolean line = false, column = false;
		for (int i = 0; i < mx; i++) {
			line = line || matrix[i][0] == 0;
		}
		for (int j = 0; j < my; j++) {
			column = column || matrix[0][j] == 0;
		}
		for (int i = 1; i < mx; i++) {
			for (int j = 1; j < my; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < mx; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < my; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int j = 1; j < my; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < mx; i++)
					matrix[i][j] = 0;
			}
		}
		if (line) {
			for (int i = 0; i < mx; i++)
				matrix[i][0] = 0;
		}
		if (column) {
			for (int j = 0; j < my; j++)
				matrix[0][j] = 0;
		}

	}
}
