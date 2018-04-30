package googleCode;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		assert (s1.length() == s2.length() && s1.length() != 0);
		int len = s1.length();
		Boolean[][][][] flag = new Boolean[len][len][len][len];
		return isScramble(flag, s1, 0, len - 1, s2, 0, len - 1);
	}

	private boolean isScramble(Boolean[][][][] flag, String s1, int i1, int j1, String s2, int i2, int j2) {
		if (flag[i1][j1][i2][j2] == null) {
			if (i1 == j1) {
				flag[i1][j1][i2][j2] = s1.charAt(i1) == s2.charAt(i2);
			} else {
				int i = i1;
				for (; i < j1 && !((isScramble(flag, s1, i1, i, s2, i2, i2 + i - i1)
						&& isScramble(flag, s1, i + 1, j1, s2, i2 + i - i1 + 1, j2))
						|| (isScramble(flag, s1, i1, i, s2, j2 - i + i1, j2)
								&& isScramble(flag, s1, i + 1, j1, s2, i2, j2 - i + i1 - 1))); i++);
				flag[i1][j1][i2][j2] = i != j1;
			}
		}
		return flag[i1][j1][i2][j2];
	}

	public boolean isScramble2(String s1, String s2) {
		assert (s1.length() == s2.length());
		int len = s1.length() + 1;
		return f(new Boolean[len][len][len], 0, 0, len - 1, s1, s2);
	}

	private boolean f(Boolean[][][] v, int i, int j, int len, String s1, String s2) {
		if (v[i][j][len] == null) {
			if (len == 0) v[i][j][len] = true;
			else if (len == 1) v[i][j][len] = s1.charAt(i) == s2.charAt(j);
			else {
				int k = 1;
				for (; k < len && !((f(v, i, j, k, s1, s2) && f(v, i + k, j + k, len - k, s1, s2))
						|| (f(v, i, j + len - k, k, s1, s2) && f(v, i + k, j, len - k, s1, s2))); k++);
				v[i][j][len] = k < len;
			}
		}
		return v[i][j][len];
	}
}
