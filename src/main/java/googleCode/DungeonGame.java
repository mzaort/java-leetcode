package googleCode;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
		assert (dungeon.length != 0 && dungeon[0].length != 0);

		int m = dungeon.length, n = dungeon[0].length;
		int[][] f = new int[m][n];
		f[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
		for (int i = m - 2; i >= 0; i--)
			f[i][n - 1] = Math.max(1, f[i + 1][n - 1] - dungeon[i][n - 1]);
		for (int j = n - 2; j >= 0; j--)
			f[m - 1][j] = Math.max(1, f[m - 1][j + 1] - dungeon[m - 1][j]);
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--)
				f[i][j] = Math.max(1, Math.min(f[i + 1][j], f[i][j + 1]) - dungeon[i][j]);
		}
		return f[0][0];
	}
}
