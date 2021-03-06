package interview2018;

public class RomantoInteger {
	public int romanToInt(String s) {
		int res = 0;
		int pre = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int v = char2int(s.charAt(i));
			res += (v >= pre) ? v : -v;
			pre = v;
		}
		return res;
	}

	private int char2int(char ch) {
		switch (ch) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}
}
