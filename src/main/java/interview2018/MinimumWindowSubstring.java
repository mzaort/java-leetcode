package interview2018;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";

		Map<Character, Integer> expect = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			expect.put(ch, expect.getOrDefault(ch, 0) + 1);
		}

		int left = -1, matched = 0;
		int minLeft = -1, len = Integer.MAX_VALUE;

		Map<Character, Integer> actual = new HashMap<>();
		for (int i = next(expect, s, -1); i < s.length(); i = next(expect, s, i)) {
			char ch = s.charAt(i);
			actual.put(ch, actual.getOrDefault(ch, 0) + 1);
			if (actual.get(ch) <= expect.get(ch)) matched++;
			if (matched == t.length()) {
				for (left = next(expect, s, left); left <= i; left = next(expect, s, left)) {
					ch = s.charAt(left);
					if (actual.getOrDefault(ch, 0) <= expect.getOrDefault(ch, 0)) break;
					actual.put(ch, actual.getOrDefault(ch, 0) - 1);
				}
				left = left - 1;
				if (len > i - left) {
					minLeft = left;
					len = i - left;
				}
			}
		}
		return len > s.length() ? "" : s.substring(minLeft + 1, minLeft + len + 1);
	}

	private int next(Map<Character, Integer> expect, String s, int i) {
		int j = i + 1;
		for (; j < s.length() && !expect.containsKey(s.charAt(j)); j++);
		return j;
	}

	public static void main(String[] args) {
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		System.out.println(mws.minWindow("acbbaca", "aba"));
	}
}
