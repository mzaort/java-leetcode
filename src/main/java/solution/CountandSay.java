package solution;

public class CountandSay {
	public static void main(String[] args) {
		CountandSay cs = new CountandSay();
		System.out.println(cs.countAndSay(2));
	}

	public String countAndSay(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 0) return "";

		StringBuilder sb = new StringBuilder("1");
		for (int i = 0; i < n - 1; i++) {
			StringBuilder buffer = new StringBuilder();
			char previous = sb.charAt(0);
			int cnt = 1;
			for (int cur = 1; cur < sb.length(); cur++) {
				if (sb.charAt(cur) == previous) {
					cnt++;
				} else {
					buffer.append(cnt).append(previous);
					previous = sb.charAt(cur);
					cnt = 1;
				}
			}
			buffer.append(cnt).append(previous);
			sb = buffer;
		}
		return new String(sb);
	}
}
