package googleCode;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome2("abcdcbad"));
	}

	public String longestPalindrome(String s) {
		if (s == null || s.length() < 2) return s;

		boolean[][] f = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++)
			f[i][i] = true;
		for (int i = 0, j = 1; j < s.length(); i++, j++)
			f[i][j] = s.charAt(i) == s.charAt(j);
		for (int gap = 2; gap < s.length(); gap++) {
			for (int i = 0, j = i + gap; j < s.length(); i++, j++)
				f[i][j] = f[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
		}
		for (int gap = s.length() - 1; gap >= 0; gap--) {
			for (int i = 0, j = i + gap; j < s.length(); i++, j++) {
				if (f[i][j]) return s.substring(i, j + 1);
			}
		}
		return s;
	}

	public String longestPalindrome2(String s) {
		if (s == null || s.length() < 2) return s;
		String str = preprocess(s);

		int center = -1, right = -1;
		int[] f = new int[str.length()];
		for (int i = 1; i < str.length() - 1; i++) {
			// if(center == -1){
			// f[i] = 0;
			// }else{
			// f[i] = f[2 * center - i] > right - i ? right - i : f[2 * center -
			// i];
			// }
			if (i <= right) f[i] = f[2 * center - i] > right - i ? right - i : f[2 * center - i];
			else f[i] = 0;
			while (str.charAt(i + f[i] + 1) == str.charAt(i - f[i] - 1))
				f[i]++;
			if (i + f[i] > right) {
				right = i + f[i];
				center = i;
			}
		}

		int imax = 1;
		for (int i = 1; i < f.length - 1; i++)
			if (f[imax] < f[i]) {
				imax = i;
			}
		int start = imax - f[imax];
		int starti = (start - 1) / 2;
		return s.substring(starti, starti + f[imax]);
	}

	private String preprocess(String s) {
		StringBuilder sb = new StringBuilder("^#");
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i)).append('#');
		}
		sb.append('$');
		return new String(sb);
	}
}
