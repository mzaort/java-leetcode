package googleCode;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		assert (digits.length > 0);
		int cur = digits.length - 1;
		for (; cur >= 0 && digits[cur] == 9; cur--);
		if (cur == -1) {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			return res;
		} else {
			int[] res = digits.clone();
			res[cur]++;
			for (int i = cur + 1; i < res.length; i++)
				res[i] = 0;
			return res;
		}
	}
}
