package interview2018;

import java.util.HashSet;
import java.util.Set;

public class BuddyStrings {
	public boolean buddyStrings(String A, String B) {
		if (A.length() != B.length() || A.length() < 2) return false;
		int i = 0, j = A.length() - 1;
		for (; i <= j && A.charAt(i) == B.charAt(i); i++);
		for (; i <= j && A.charAt(j) == B.charAt(j); j--);
		if (i < j) {
			return A.charAt(i) == B.charAt(j) && A.charAt(j) == B.charAt(i)
					&& A.substring(i + 1, j).equals(B.substring(i + 1, j));
		} else {
			Set<Character> set = new HashSet<>();
			for (i = 0; i < A.length(); i++) {
				char ch = A.charAt(i);
				if (set.contains(ch)) return true;
				set.add(ch);
			}
			return false;
		}
	}
}
