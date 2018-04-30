package interview2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<Integer>();
		if (words.length == 0 || s.length() == 0) return list;

		Map<String, Integer> expected = new HashMap<>();
		for (String e : words) {
			expected.put(e, expected.getOrDefault(e, 0) + 1);
		}

		int step = words[0].length();
		int len = words.length * step;
		int bound = s.length() - step;

		String[] sa = new String[s.length()];
		for (int i = 0; i <= bound; i++) {
			String val = s.substring(i, i + step);
			if (expected.containsKey(val)) sa[i] = val;
		}

		for (int frm = 0; frm < step; frm++) {
			Map<String, Integer> actual = new HashMap<String, Integer>();
			for (int i = frm, left = frm; i <= bound; i += step) {
				if (sa[i] == null) {
					actual.clear();
					left = i + step;
				} else actual.put(sa[i], actual.getOrDefault(sa[i], 0) + 1);

				while (left < i + step - len) {
					if (sa[left] != null) actual.put(sa[left], actual.get(sa[left]) - 1);
					left += step;
				}
				if (left == i + step - len && actual.size() == expected.size()) {
					boolean flag = true;
					for (Map.Entry<String, Integer> e : expected.entrySet()) {
						if (e.getValue() != actual.get(e.getKey())) {
							flag = false;
							break;
						}
					}
					if (flag) list.add(left);
				}
			}
		}

		return list;
	}
}
