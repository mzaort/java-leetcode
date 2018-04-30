package googleCode;

public class FactorialTrailingZeroes {
	public static void main(String[] args) {
		FactorialTrailingZeroes ftz = new FactorialTrailingZeroes();
		System.out.println(ftz.trailingZeroes(1808548329) == ftz.trailingZeroes2(1808548329));
		for (int i = Integer.MAX_VALUE; i > Integer.MAX_VALUE - 1000000; i -= 1000) {
			if (i * 10000 > 0) System.out.println("Oops");
		}
	}

	// wrong reason is m * 5 may bound out;
	public int trailingZeroes(int n) {
		assert (n >= 0);
		int i5 = 0;
		for (int m = 5; m > 0 && m <= n; m *= 5)
			i5 += n / m;
		return i5;
	}

	public int trailingZeroes2(int n) {
		assert (n >= 0);
		int i5 = 0;
		for (int val = n; val != 0; val = val / 5)
			i5 += val / 5;
		return i5;
	}
}
