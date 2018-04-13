package microsoft;

public class String2Long {
	
	public static void main(String[] args) {
		String s = "-22322";
		String2Long s2l = new String2Long();
		System.out.println(s2l.str2long(s, 0, s.length() - 1));
	}
	
	public long str2long(String s, int cur, int end) {
		if (cur == end) {
			return s.charAt(cur) - '0';
		} else {
			return s.charAt(cur) == '-' ? -(str2long(s, cur + 1, end - 1) * 10
					+ s.charAt(end) - '0') : str2long(s, cur, end - 1) * 10
					+ s.charAt(end) - '0';
		}
	}
}
