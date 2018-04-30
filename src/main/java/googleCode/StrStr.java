package googleCode;

public class StrStr {
	public String strStr(String haystack, String needle) {
		int hlen = haystack.length(), nlen = needle.length();
		for (int i = 0; i <= hlen - nlen; i++) {
			int k = 0;
			for (int j = i; k < nlen && haystack.charAt(j) == needle.charAt(k); j++, k++);
			if (k == nlen) return haystack.substring(i, i + nlen);
		}
		return null;
	}

	public String strStr2(String A, String B) {
		if (B.length() == 0) return A;
		int[] f = preprocess(B);
		for (int i = 0, j = -1; i < A.length(); i++) {
			while (j != -1 && B.charAt(j + 1) != A.charAt(i))
				j = f[j];
			if (B.charAt(j + 1) == A.charAt(i)) j++;
			if (j == B.length() - 1) return A.substring(i + 1 - B.length());
		}
		return null;
	}

	private int[] preprocess(String A) {
		int[] f = new int[A.length()];
		for (int i = 0, j = -1; i < A.length(); i++) {
			while (j != -1 && A.charAt(j + 1) != A.charAt(i))
				j = f[j];
			f[i] = A.charAt(j + 1) == A.charAt(i) && j + 1 != i ? j + 1 : -1;
			j = f[i];
		}
		return f;
	}
}
