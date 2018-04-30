package solution;

public class PalindromeNumber {
	public static void main(String[] args) {
		PalindromeNumber pn = new PalindromeNumber();
		System.out.println(pn.isPalindrome(8));
	}

	public boolean isPalindrome(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x < 0) { return false; }

		int length = 0;
		int curx = x;

		while (curx != 0) {
			length++;
			curx /= 10;
		}

		int shift = length;
		for (int i = 0; i < length / 2; i++) {
			int tmp = x % 10;
			x /= 10;
			shift -= 2;
			x -= tmp * Math.pow(10, shift);
		}
		if (length % 2 == 0) {
			return x == 0;
		} else {
			return (x >= 0 && x <= 9);
		}
	}

	public boolean isPalindrome2(int x) {
		String str = "" + x;
		int n = str.length();
		for (int i = 0; i < n / 2; i++) {
			if (str.charAt(i) != str.charAt(n - 1 - i)) { return false; }
		}
		return true;
	}

	public boolean isPalindrome3(int x) {
		if (x < 0) return false;

		int len = 0;
		int tmp = x;

		while (tmp != 0) {
			len++;
			tmp /= 10;
		}

		for (int i = 0, si = 1, sj = (int) Math.pow(10, len - 1); i < len / 2; i++, si *= 10, sj /= 10) {
			if ((x / si % 10) != (x / sj % 10)) { return false; }
		}

		return true;
	}
}
