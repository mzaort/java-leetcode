package googleCode;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) return false;
		String str = "" + x;
		int len = str.length();
		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - 1 - i)) return false;
		}
		return true;
	}

	public boolean isPalindrome2(int x) {
		if (x < 0) return false;
		int len = 0;
		for (int tmp = x; tmp != 0; len++, tmp /= 10);
		for (int i = 0, n1 = (int) Math.pow(10, len - 1), n2 = 1; i < len / 2; i++, n1 /= 10, n2 *= 10) {
			if ((x / n1) % 10 != (x / n2) % 10) return false;
		}
		return true;
	}

}
