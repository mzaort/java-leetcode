package solutionReview;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		int len = strs.length;
		if (len == 0) return "";

		int maxLength = Integer.MAX_VALUE;
		for (String s : strs) {
			if (s.length() < maxLength) {
				maxLength = s.length();
			}
		}

		for (int i = 1; i < len; i++) {
			maxLength = longestCommonPrefixOfTwo(strs[0], strs[i], maxLength);
		}

		return strs[0].substring(0, maxLength);
	}

	private int longestCommonPrefixOfTwo(String s1, String s2, int max) {
		int i = 0;
		for (; i < max && s1.charAt(i) == s2.charAt(i); i++);
		return i;
	}

	public String longestCommonPrefix2(String[] strs) {
		int len = strs.length;
		if (len == 0) return "";

		for (int i = 0; i < strs[0].length(); i++) {
			char ch = strs[0].charAt(i);
			for (int j = 1; j < len; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != ch) { return strs[0].substring(0, i); }
			}
		}
		return "";
	}
}