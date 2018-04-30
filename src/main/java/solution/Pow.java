package solution;

public class Pow {
	public double pow(double x, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x == 0) {
			if (n <= 0) {
				return Double.NaN;
			} else {
				return 0;
			}
		}

		int abs = n > 0 ? n : -n;

		double res = 1, tmp = x;
		while (abs > 0) {
			if ((abs & 1) == 1) res *= tmp;
			tmp = tmp * tmp;
			abs >>= 1;
		}

		return n > 0 ? res : 1 / res;
	}
}
