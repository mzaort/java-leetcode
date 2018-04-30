package interview2018;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		if (pattern == null) return str == null;
		if (str == null) return false;

		String[] strs = str.split(" ");
		if (pattern.length() != strs.length) return false;

		Map<Character, String> cmap = new HashMap<>();
		Map<String, Character> smap = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			Character c = pattern.charAt(i);
			String s = strs[i];
			Character cm = smap.get(s);
			String sm = cmap.get(c);
			if (cm == null && sm == null) {
				smap.put(s, c);
				cmap.put(c, s);
			} else if (!(s.equals(sm) && c.equals(cm))) { return false; }
		}
		return true;
	}
}
