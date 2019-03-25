package interview2018;

public class LargestSumofAverages {
	public double largestSumOfAverages(int[] A, int K) {
		int M = A.length;
		if (M < K || K == 0) return Double.NaN;
		double[][] f = new double[M + 1][K + 1];

		double s = 0;
		for (int i = 0; i < M; i++) {
			s += A[i];
			if (i < K) f[i + 1][i + 1] = s;
			f[i + 1][1] = s / (i + 1);
		}

		for (int i = 3; i <= M; i++) {
			for (int k = 2, lim = Math.min(K, i); k <= lim; k++) {
				double max = Double.MIN_VALUE;
				double sum = 0, average = 0;
				for (int h = i - 1, c = 1; h >= k - 1; h--, c++) {
					sum += A[h];
					average = sum / c;
					max = Math.max(f[h][k - 1] + average, max);
				}
				f[i][k] = max;
			}

		}
		return f[M][K];
	}

	public static void main(String[] args) {
		int[] A = { 9, 1, 2, 3, 9, 6 };
		LargestSumofAverages lsa = new LargestSumofAverages();
		System.out.println(lsa.largestSumOfAverages(A, 1));
	}
}
