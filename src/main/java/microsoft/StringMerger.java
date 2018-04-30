package microsoft;

public class StringMerger {
	public int maxLength(String[] str) {
		int L = str.length;
		if (L == 0) return -1;

		int[][] mat = new int[L][L];
		for (int i = 0; i < L; i++) {
			String prefix = str[i].substring(1);
			for (int j = 0; j < L; j++) {
				if (str[j].startsWith(prefix)) mat[i][j] = 1;
			}
		}
		floyd(mat);
		for (int i = 0; i < L; i++)
			if (mat[i][i] != 0) return -1;
		int ans = 0;
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				ans = Math.max(ans, mat[i][j]);
			}
		}
		return ans + str[0].length();
	}

	private void floyd(int[][] mat) {
		for (int k = 0; k < mat.length; k++) {
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat.length; j++) {
					mat[i][j] = Math.max(mat[i][j], mat[i][k] + mat[k][j]);
				}
			}
		}
	}
}
