package googleCode;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		int[] cht = new int[256];
		int[] chs = new int[256];
		for (int i = 0; i < T.length(); i++)
			cht[T.charAt(i)]++;

		int nomatch = T.length();
		int last = 0;
		String res = S;
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			chs[ch]++;
			if (chs[ch] <= cht[ch]) nomatch--;
			while (last < S.length() && chs[S.charAt(last)] > cht[S.charAt(last)]) {
				chs[S.charAt(last)]--;
				last++;
			}
			if (nomatch == 0 && i - last + 1 < res.length()) res = S.substring(last, i + 1);
		}
		return nomatch == 0 ? res : "";
	}
}
