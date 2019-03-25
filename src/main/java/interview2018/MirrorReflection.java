package interview2018;

public class MirrorReflection {
	/**
	 * n * 2q = m * p -> 2 <br>
	 * (2n + 1) * q = m * p; ->m odd 1, even 0;
	 */
	public int mirrorReflection(int p, int q) {
		int N = p * q / gcd(p, q);
		return ((N / q) & 1) == 0 ? 2 : ((N / p) & 1);
	}

	private int gcd(int m, int n) {
		while (n > 0) {
			int r = m % n;
			m = n;
			n = r;
		}
		return m;
	}
}
