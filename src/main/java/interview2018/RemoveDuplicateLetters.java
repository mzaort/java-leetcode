package interview2018;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLetters {

	public String removeDuplicateLetters2(String s) {
		if (s == null || s.length() == 0) return s;
		int[] freq = new int[256];
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i)]++;
		}
		ArrayDeque<Character> stack = new ArrayDeque<>();
		boolean[] inStack = new boolean[256];
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			freq[ch]--;
			if (inStack[ch]) continue;
			while (!stack.isEmpty() && stack.peek() > ch && freq[stack.peek()] > 0) {
				inStack[stack.pop()] = false;
			}
			stack.push(ch);
			inStack[ch] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (char e : stack) {
			sb.append(e);
		}
		return sb.reverse().toString();
	}

	public String removeDuplicateLetters(String s) {
		StringBuilder sb = new StringBuilder();

		int remove = 0;
		char[] chrs = s.toCharArray();
		for (int i = 0; i < chrs.length - remove; i++) {
			char ch = chrs[i];
			int k = chrs.length - remove - 1;
			for (; k > i && chrs[k] != ch; k--);
			if (k <= i) {
				sb.append(ch);
			} else {
				int j = i + 1;
				for (; j < k && chrs[j] >= ch; j++);
				if (j < k && deletable(chrs, i + 1, j - 1, j + 1, chrs.length - remove - 1)) {
					i = j - 1;
				} else {
					sb.append(String.valueOf(ch));
					int count = 0;
					for (int h = i + 1; h <= chrs.length - remove - 1; h++) {
						if (chrs[h] == ch) count++;
						else chrs[h - count] = chrs[h];
					}
					remove += count;
				}
			}
		}
		return sb.toString();
	}

	private boolean deletable(char[] chrs, int i, int j, int k, int l) {
		Set<Character> left = new HashSet<>();
		Set<Character> right = new HashSet<>();
		for (; i <= j; i++)
			left.add(chrs[i]);
		for (; k <= l; k++)
			right.add(chrs[k]);
		return right.containsAll(left);
	}

	public static void main(String[] args) {
		RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
		System.out.println(rdl.removeDuplicateLetters("baab"));
		System.out.println(rdl.removeDuplicateLetters2("cbacdcbc"));
	}
}
