package googleCode;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
    	assert(m > 0 && n > 0);
    	int[][] mat = new int[m][n];
    	return f(mat, m - 1, n - 1);
    }

	private int f(int[][] mat, int i, int j) {
		if(mat[i][j] == 0){
			if(i == 0 || j == 0) mat[i][j] = 1;
			else mat[i][j] = f(mat, i - 1, j) + f(mat, i, j - 1);
		}
		return mat[i][j];
	}
}
