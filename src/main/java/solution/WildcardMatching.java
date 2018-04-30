package solution;

public class WildcardMatching {

	public static void main(String[] args) {
		WildcardMatching wm = new WildcardMatching();
		System.out.println(wm.isMatch("a", "*?*"));
		System.out.println(wm.isMatch2("a", "*?*"));
		System.out.println(wm.isMatch4("aaabbaabbaab", "*aabbaa*a*"));
		System.out.println(wm.isMatch4("ab", ".*"));
	}

	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return isMatch(s, 0, p, 0);
	}

	private boolean isMatch(String s, int i, String p, int j) {
		int slen = s.length(), plen = p.length();
		if (i == slen) {
			if (j == plen) {
				return true;
			} else {
				for (int k = j; k < plen; k++) {
					if (p.charAt(k) != '*') { return false; }
				}
				return true;
			}
		} else {
			if (j == plen) {
				return false;
			} else {
				char sch = s.charAt(i), pch = p.charAt(j);
				if (pch == '?') {
					return isMatch(s, i + 1, p, j + 1);
				} else if (pch == '*') {
					for (; j < plen - 1; j++) {
						if (p.charAt(j + 1) != '*') {
							break;
						}
					}
					if (j == plen - 1) {
						return true;
					} else {
						char nch = p.charAt(j + 1);
						if (nch == '?' || nch == sch) {
							return isMatch(s, i + 1, p, j + 2) || isMatch(s, i + 1, p, j);
						} else {
							int index = s.indexOf(nch, i + 1);
							if (index == -1) {
								return false;
							} else {
								return isMatch(s, index + 1, p, j + 2) || isMatch(s, index + 1, p, j);
							}
						}
					}
				} else {
					if (sch == pch) {
						return isMatch(s, i + 1, p, j + 1);
					} else {
						return false;
					}
				}
			}
		}
	}

	public boolean isMatch2(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int slen = s.length(), plen = p.length();

		if (slen == 0) {
			if (plen == 0) {
				return true;
			} else {
				for (int i = 0; i < plen; i++) {
					if (p.charAt(i) != '*') { return false; }
				}
				return true;
			}
		} else {
			if (plen == 0) {
				return false;
			} else {
				boolean[][] flag = new boolean[slen + 1][plen + 1];
				flag[0][0] = true;
				for (int i = 1; i <= slen; i++) {
					flag[i][0] = false;
				}
				boolean f = true;
				for (int j = 1; j <= plen; j++) {
					f = f && (p.charAt(j - 1) == '*');
					flag[0][j] = f;
				}

				for (int i = 1, ich = 0; i <= slen; i++, ich++) {
					for (int j = 1, jch = 0; j <= plen; j++, jch++) {
						char sch = s.charAt(ich);
						char pch = p.charAt(jch);
						if (pch == '?') {
							flag[i][j] = flag[i - 1][j - 1];
						} else if (pch == '*') {
							boolean tmp = false;
							for (int k = 0; k <= i; k++) {
								tmp = tmp || flag[k][j - 1];
							}
							flag[i][j] = tmp;
						} else {
							if (sch == pch) {
								flag[i][j] = flag[i - 1][j - 1];
							} else {
								flag[i][j] = false;
							}
						}
					}
				}
				return flag[slen][plen];
			}
		}
	}

	public boolean isMatch3Wrong(String s, String p) {
		int slen = s.length(), plen = p.length();
		if (slen == 0) {
			if (plen == 0) {
				return true;
			} else {
				for (int i = 0; i < plen; i++) {
					if (p.charAt(i) != '*') { return false; }
				}
				return true;
			}
		} else {
			if (plen == 0) {
				return false;
			} else {
				int star = -1, si = 0, pi = 0;
				while (si < slen && pi < plen) {
					char sch = s.charAt(si), pch = p.charAt(pi);
					if (pch == '?') {
						si++;
						pi++;
					} else if (pch == '*') {
						for (; pi < plen - 1 && p.charAt(pi + 1) == '*'; pi++);
						star = pi;
						if (pi == plen - 1) {
							return true;
						} else {
							char next = p.charAt(pi + 1);
							if (next == '?' || next == sch) {
								si++;
								pi += 2;
							} else {
								si++;
							}
						}
					} else {
						if (sch == pch) {
							si++;
							pi++;
						} else {
							if (star == -1) {
								return false;
							} else {
								pi = star;
							}
						}
					}
					if (pi == plen) {
						if (si == slen) {
							return true;
						} else {
							if (star == -1) {
								return false;
							} else {
								pi = star;
							}
						}
					} else {
						if (si == slen) {
							for (; pi < plen; pi++) {
								if (p.charAt(pi) != '*') { return false; }
							}
							return true;
						}
					}
				}
				return true;
			}
		}
	}

	public boolean isMatch4(String s, String p) {
		int n = s.length();
		int m = p.length();

		int i = 0;
		int j = 0;
		int star = -1;
		int sp = 0;

		while (i < n) {
			// one * and multiple *, same effect
			while (j < m && p.charAt(j) == '*') {
				star = j++; // * match 0 character
				sp = i;
			}

			if (j == m || (p.charAt(j) != s.charAt(i) && p.charAt(j) != '?')) {
				if (star < 0) return false;
				else {
					j = star + 1;
					i = ++sp; // * match 1 character
				}
			} else {
				i++;
				j++;
			}
		}

		while (j < m && p.charAt(j) == '*')
			j++;
		return j == m;
	}
}
