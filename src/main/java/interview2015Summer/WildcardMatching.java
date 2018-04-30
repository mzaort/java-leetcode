package interview2015Summer;

public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		return isMatch(s, 0, p, 0);
	}

	private boolean isMatch(String s, int i, String p, int j) {
		if (i == s.length()) {
			for (; j < p.length() && p.charAt(j) == '*'; j++);
			return j == p.length();
		}
		if (j == p.length()) return false;
		char sch = s.charAt(i), pch = p.charAt(j);
		if (pch == '*') {
			for (j++; j < p.length() && p.charAt(j) == '*'; j++);
			for (; i < s.length() && !isMatch(s, i, p, j); i++);
			return i < s.length();
		}
		return (pch == '?' || pch == sch) && isMatch(s, i + 1, p, j + 1);
	}

	public boolean isMatch2(String s, String p) {
		return f(new Boolean[s.length() + 1][p.length() + 1], s.length(), p.length(), s, p);
	}

	private boolean f(Boolean[][] v, int i, int j, String s, String p) {
		if (v[i][j] == null) {
			if (i == 0) {
				int k = j;
				for (; k > 0 && p.charAt(k - 1) == '*'; k--);
				v[i][j] = k == 0;
			} else if (j == 0) {
				v[i][j] = false;
			} else {
				char sch = s.charAt(i - 1), pch = p.charAt(j - 1);
				if (pch == '*') {
					int jt = j, it = i;
					for (; jt > 0 && p.charAt(jt - 1) == '*'; jt--);
					for (; it >= 0 && !f(v, it, jt, s, p); it--);
					v[i][j] = it >= 0;
				} else {
					v[i][j] = (pch == '?' || pch == sch) && f(v, i - 1, j - 1, s, p);
				}
			}
		}
		return v[i][j];
	}

	public boolean isMatch3(String s, String p) {
		int mark = -1, loc = -1;
		int i = 0, j = 0;
		while (i < s.length()) {
			while (j < p.length() && p.charAt(j) == '*') {
				mark = j;
				loc = i;
			}
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(j))) {
				i++;
				j++;
			} else {
				if (mark == -1) return false;
				j = mark + 1;
				i = ++loc;
			}
		}
		for (; j < p.length() && p.charAt(j) == '*'; j++);
		return j == p.length();
	}
}
