package googleCode;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		return s1.length() + s2.length() == s3.length()
				&& isInterleave(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0);
	}

	private boolean isInterleave(char[] s1, int i, char[] s2, int j, char[] s3, int k) {
		if (i == s1.length) {
			for (; j < s2.length && s2[j] == s3[k]; j++, k++);
			return j == s2.length;
		}
		if (j == s2.length) {
			for (; i < s1.length && s1[i] == s3[k]; i++, k++);
			return i == s1.length;
		}
		if (s1[i] == s3[k]) {
			if (s2[j] == s3[k]) {
				return isInterleave(s1, i + 1, s2, j, s3, k + 1) || isInterleave(s1, i, s2, j + 1, s3, k + 1);
			} else {
				return isInterleave(s1, i + 1, s2, j, s3, k + 1);
			}
		} else {
			if (s2[j] == s3[k]) {
				return isInterleave(s1, i, s2, j + 1, s3, k + 1);
			} else {
				return false;
			}
		}
	}

	public boolean isInterleave2(String s1, String s2, String s3) {
		int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
		if (len1 + len2 != len3) return false;
		boolean[][] f = new boolean[len1 + 1][len2 + 1];
		f[0][0] = true;
		for (int i = 1; i <= len1; i++)
			f[i][0] = f[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
		for (int j = 1; j <= len2; j++)
			f[0][j] = f[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				char c1 = s1.charAt(i - 1), c2 = s2.charAt(j - 1), c3 = s3.charAt(i + j - 1);
				// f[i][j] = (c1 == c3 && f[i - 1][j]) || (c2 == c3 && f[i][j -
				// 1]);
				if (c1 == c3) {
					if (c2 == c3) {
						f[i][j] = f[i - 1][j] || f[i][j - 1];
					} else {
						f[i][j] = f[i - 1][j];
					}
				} else {
					if (c2 == c3) {
						f[i][j] = f[i][j - 1];
					} else {
						f[i][j] = false;
					}
				}
			}
		}
		return f[len1][len2];
	}
}
