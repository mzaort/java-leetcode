package solution;

public class Sqrt {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE * 2);
	}

	public int sqrt(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int i = 0;
		int res = 0;
		int diff = x;

		for (i = 0; i <= x; i++) {
			diff = x - i * i;
			if (diff <= 0) {
				res = i;
			}
		}

		int diff2 = x - (res - 1) * (res - 1);
		if (diff2 < diff) {
			return res - 1;
		} else {
			return res;
		}
	}

	public int sqrt2(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int k = 1;

		for (k = 1; k <= x; k++) {
			if (((x / k) * (x / k)) - x <= 0) {
				break;
			}
		}

		if (k == 1) { return x; }

		int i = 0;
		int res = 0;

		int diff = x;

		for (i = x / k; i <= x / (k - 1); i++) {
			diff = x - i * i;
			if (diff <= 0) {
				res = i;
			}
		}

		int diff2 = x - (res - 1) * (res - 1);
		if (diff2 < diff) {
			return res - 1;
		} else {
			return res;
		}
	}

	public int sqrt3(int x) {
		if (x < 0) return -1;
		int left = 0;
		int right = x;
		int mid = 0;
		while (left <= right) {
			mid = (right + left) / 2;
			long temp = (long) mid * mid;
			if (temp == x) return mid;
			else if (temp < x) left = mid + 1;
			else right = mid - 1;
		}
		return right;
	}
}
