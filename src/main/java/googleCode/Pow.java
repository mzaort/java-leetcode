package googleCode;

public class Pow {
	public double pow(double x, int n) {
		assert (n > 0 || x != 0);
		boolean negative = n < 0;
		if (negative) n = -n;

		double res = 1;
		while (n != 0) {
			if ((n & 1) == 1) res *= x;
			n >>>= 1;
			x *= x;
		}

		return negative ? 1 / res : res;
	}

	public double pow2(double x, int n) {
		assert (n > 0 || x != 0);
		boolean negative = n < 0;
		if (negative) n = -n;

		double res = 1;
		for (; n != 0; n >>>= 1, x *= x) {
			if ((n & 1) == 1) res *= x;
		}

		return negative ? 1 / res : res;
	}
}
