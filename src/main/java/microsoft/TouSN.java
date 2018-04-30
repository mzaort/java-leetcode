package microsoft;

public class TouSN {

	public static void main(String[] args) {
		TouSN tsn = new TouSN();
		tsn.list(10);
	}

	public void list(int n) {
		assert (n > 0);
		int[][] v = new int[6 * n + 1][n + 1];
		for (int i = 1; i <= 6; i++)
			v[i][1] = 1;
		for (int j = 2; j <= n; j++) {
			for (int i = j; i <= 6 * n; i++) {
				int min = Math.min(6, i - j + 1);
				for (int k = 1; k <= min; k++)
					v[i][j] += v[i - k][j - 1];
			}
		}
		for (int i = n; i <= 6 * n; i++)
			System.out.println(v[i][n]);
	}
}
