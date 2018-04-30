package googleCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
		List<String> res = new ArrayList<String>();
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String s : strs) {
			char[] ctrs = s.toCharArray();
			Arrays.sort(ctrs);
			String original = new String(ctrs);
			if (map.get(original) == null) {
				map.put(original, new ArrayList<String>());
			}
			map.get(original).add(s);
		}
		for (ArrayList<String> e : map.values()) {
			if (e.size() >= 2) {
				for (String t : e) {
					res.add(t);
				}
			}
		}
		return res;
	}
}
