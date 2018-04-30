package solution;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int length = digits.length;
		int[] res = null;

		if (length == 0) {
			res = new int[1];
			res[0] = 1;
			return res;
		}

		int surplus;
		int tmp;
		res = new int[length];
		System.arraycopy(digits, 0, res, 0, length);

		tmp = digits[length - 1] + 1;
		res[length - 1] = tmp % 10;
		surplus = tmp / 10;

		for (int i = length - 2; surplus != 0 && i >= 0; i--) {
			tmp = digits[i] + surplus;
			res[i] = tmp % 10;
			surplus = tmp / 10;
		}

		if (surplus != 0) {
			int[] res2 = new int[length + 1];
			System.arraycopy(res, 0, res2, 1, length);
			res2[0] = surplus;
			return res2;
		} else {
			return res;
		}
	}
}
