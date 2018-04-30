package googleCode;

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		assert (n >= 0);
		if (n < 2) return 1;

		int[] f = new int[n + 1];
		f[0] = f[1] = 1;
		for (int i = 2; i <= n; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				sum += f[j] * f[i - 1 - j];
			}
			f[i] = sum;
		}
		return f[n];
	}
}
