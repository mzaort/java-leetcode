package classic;

public class KMP {

	public static void main(String[] args) {
		KMP sol = new KMP();
		System.out.println(sol.kmp("aaab", "abb"));
	}

	public boolean kmp(String s, String t) {
		int slen = s.length(), tlen = t.length();
		if (tlen == 0) return true;
		if (slen < tlen) return false;

		int[] P = preProcess(t);

		int j = -1;
		for (int i = 0; i < slen; i++) {
			while (j != -1 && t.charAt(j + 1) != s.charAt(i))
				j = P[j];
			if (t.charAt(j + 1) == s.charAt(i)) j++;
			if (j == tlen - 1) { return true; }
		}
		return false;
	}

	private int[] preProcess(String t) {
		int len = t.length();
		int[] res = new int[len];

		int j = -1;
		res[0] = -1;
		for (int i = 1; i < len; i++) {
			while (j != -1 && t.charAt(j + 1) != t.charAt(i))
				j = res[j];
			if (t.charAt(j + 1) == t.charAt(i)) j++;
			res[i] = j;
		}
		return res;
	}
}
