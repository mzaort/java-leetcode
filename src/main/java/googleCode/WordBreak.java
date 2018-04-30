package googleCode;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		int max = 0;
		for (String e : dict)
			if (max < e.length()) max = e.length();

		Boolean[] f = new Boolean[s.length() + 1];
		f[s.length()] = true;

		return isBreakable(f, s, 0, dict, max);
	}

	private boolean isBreakable(Boolean[] f, String s, int i, Set<String> dict, int max) {
		if (f[i] == null) {
			int j = i + 1, maxcur = Math.min(i + max, s.length());
			for (; j <= maxcur && !(dict.contains(s.substring(i, j)) && isBreakable(f, s, j, dict, max)); j++);
			f[i] = j <= maxcur;
		}
		return f[i];
	}
}
