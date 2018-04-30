package googleCode;

public class DivideTwoIntegers {
	public static void main(String[] args) {
		System.out.println(false ^ false);
	}

	public int divide(int dividend, int divisor) {
		assert (divisor != 0);
		boolean positive = (dividend >= 0 && divisor > 0) || (dividend <= 0 && divisor < 0);
		long x = dividend, y = divisor;
		if (x < 0) x = -x;
		if (y < 0) y = -y;
		int val = 0;
		for (int i = Integer.SIZE - 1; i >= 0; i--) {
			val <<= 1;
			if (x - (y << i) >= 0) {
				val++;
				x -= y << i;
			}
		}
		// x = Min_value, y = -1?
		return positive ? val : -val;
	}
}