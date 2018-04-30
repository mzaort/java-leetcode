package interview2016;

public class NumberofIslands {
	public int numIslands(char[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					res++;
					dfs(grid, i, j);
				}
			}
		}
		return res;
	}

	private void dfs(char[][] grid, int i, int j) {
		grid[i][j] = '2';
		if (i + 1 < grid.length && grid[i + 1][j] == '1') {
			dfs(grid, i + 1, j);
		}
		if (i - 1 >= 0 && grid[i - 1][j] == '1') {
			dfs(grid, i - 1, j);
		}
		if (j + 1 < grid[i].length && grid[i][j + 1] == '1') {
			dfs(grid, i, j + 1);
		}
		if (j - 1 >= 0 && grid[i][j - 1] == '1') {
			dfs(grid, i, j - 1);
		}
	}

	private static int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	private void dfs2(char[][] grid, int i, int j) {
		grid[i][j] = '2';
		for (int h = 0; h < direction.length; h++) {
			i += direction[h][0];
			j += direction[h][1];
			if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1') {
				dfs2(grid, i, j);
			}
		}
	}
}
