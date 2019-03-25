package interview2018;

public class MagicSquaresInGrid {
	public int numMagicSquaresInside(int[][] grid) {
		if (grid.length < 3 || grid[0].length < 3) return 0;

		int res = 0;
		int row = grid.length, col = grid[0].length;
		for (int i = 0; i <= row - 3; i++) {
			for (int j = 0; j <= col - 3; j++) {
				if (isMagic(grid, i, j)) res++;
			}
		}
		return res;
	}

	private boolean isMagic(int[][] grid, int i, int j) {
		if (grid[i + 1][j + 1] != 5) return false;
		for (int row = i; row < i + 3; row++) {
			if (!sumEqual(grid[row][j], grid[row][j + 1], grid[row][j + 2])) return false;
		}
		for (int col = j; col < j + 3; col++) {
			if (!sumEqual(grid[i][col], grid[i + 1][col], grid[i + 2][col])) return false;
		}
		if (!sumEqual(grid[i][j], grid[i + 1][j + 1], grid[i + 2][j + 2])) return false;
		if (!sumEqual(grid[i + 2][j], grid[i + 1][j + 1], grid[i][j + 2])) return false;
		boolean[] v = new boolean[10];
		for (int k = i; k < i + 3; k++) {
			for (int h = j; h < j + 3; h++) {
				int n = grid[k][h];
				if (n < 1 || n > 9 || v[n]) return false;
				else v[n] = true;
			}
		}
		return true;
	}

	private boolean sumEqual(int v1, int v2, int v3) {
		return v1 + v2 + v3 == 15;
	}
}
