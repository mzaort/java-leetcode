package googleCode;

public class ReverseInteger {
	public int reverse(int x) {
		boolean negative = false;
		if (x < 0) {
			x = -x;
			negative = true;
		}

		int res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x /= 10;
		}

		return negative ? -res : res;
	}

}
