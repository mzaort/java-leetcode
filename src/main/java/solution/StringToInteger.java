package solution;

public class StringToInteger {

	public static void main(String[] args) {
		StringToInteger sti = new StringToInteger();
		System.out.println(sti.atoi("  + 2323	fdsfs	\t\n "));
	}

	public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (str == null || str.length() == 0) { return 0; }

		int res = 0;
		char minDigit = '0', maxDigit = '9';

		int cur = 0;
		char ch = 0xff;

		for (; cur < str.length(); cur++) {
			ch = str.charAt(cur);
			if (ch == ' ' || ch == '\t' || ch == '\n') {
				continue;
			}
			if (ch == '+' || ch == '-' || (ch >= minDigit && ch <= maxDigit)) {
				break;
			} else {
				return 0;
			}
		}

		char sign = ch;
		if (sign != '+' && sign != '-') {
			res = sign - '0';
		}

		boolean flag = true;

		for (cur++; cur < str.length(); cur++) {
			ch = str.charAt(cur);
			if (ch >= minDigit && ch <= maxDigit) {
				long next = res * 10l + ch - '0';
				res = (int) next;
				if (next != res) {
					flag = false;
					break;
				}
			} else {
				break;
			}
		}

		if (flag) {
			if (sign == '-') {
				res = -res;
			}
			return res;
		} else {
			if (sign == '-') {
				return Integer.MIN_VALUE;
			} else {
				return Integer.MAX_VALUE;
			}
		}
	}

	public int atoi2(String str) {
		int len = str.length();
		if (len == 0) return 0;

		int cur = 0;
		for (; cur < len && Character.isSpaceChar(str.charAt(cur)); cur++);

		int sign = 1;
		int res = 0;

		if (cur < len) {
			char ch = str.charAt(cur);
			if (ch == '-') {
				sign = -1;
				cur++;
			} else if (ch == '+') {
				sign = 1;
				cur++;
			} else {
				sign = 1;
			}
		}

		for (; cur < len; cur++) {
			char ch = str.charAt(cur);
			if (Character.isDigit(ch)) {
				int digit = ch - '0';
				if ((Integer.MAX_VALUE - digit) / 10 < res) {
					return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				} else {
					res = res * 10 + digit;
				}
			} else {
				break;
			}
		}

		return sign == -1 ? -res : res;
	}
}
