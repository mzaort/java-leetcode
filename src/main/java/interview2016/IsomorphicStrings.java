package interview2016;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) return false;
		Map<Character, Character> smap = new HashMap<>();
		Map<Character, Character> tmap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char sch = s.charAt(i);
			char tch = t.charAt(i);
			Character c1 = smap.get(sch);
			Character c2 = tmap.get(tch);
			if(c1 != null && c1.charValue() != tch) return false;
			if(c2 != null && c2.charValue() != sch) return false;
			if(c1 == null) smap.put(sch, tch);
			if(c2 == null) tmap.put(tch, sch);
		}
		return true;
	}
}
