package interview2018;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) return false;
		return f(new Boolean[s1.length() + 1][s2.length() + 1], s1.length(), s2.length(), s1, s2, s3);
	}

	private boolean f(Boolean[][] v, int i, int j, String s1, String s2, String s3) {
		if (v[i][j] == null) {
			boolean r = i + j == 0;
			if (!r && i != 0) r |= s1.charAt(i - 1) == s3.charAt(i + j - 1) && f(v, i - 1, j, s1, s2, s3);
			if (!r && j != 0) r |= s2.charAt(j - 1) == s3.charAt(i + j - 1) && f(v, i, j - 1, s1, s2, s3);
			v[i][j] = r;
		}
		return v[i][j];
	}
}
