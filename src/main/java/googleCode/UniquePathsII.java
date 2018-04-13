package googleCode;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] grid) {
        assert(grid.length > 0 && grid[0].length > 0);
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = 1 - grid[0][0];
        for(int i = 1; i < m; i++) f[i][0] = (grid[i][0] == 1 || f[i - 1][0] == 0) ? 0 : 1;
        for(int j = 1; j < n; j++) f[0][j] = (grid[0][j] == 1 || f[0][j - 1] == 0) ? 0 : 1;
        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++)
        		f[i][j] = grid[i][j] == 1 ? 0 : f[i - 1][j] + f[i][j - 1];
        }
        return f[m - 1][n - 1];
    }
}
