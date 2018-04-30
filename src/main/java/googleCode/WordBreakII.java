package googleCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> dict) {
		List<String> res = new ArrayList<String>();
		wordBreak(res, new ArrayList<String>(), s, 0, dict);
		return res;
	}

	private void wordBreak(List<String> res, ArrayList<String> list, String s, int i, Set<String> dict) {
		if (i == s.length()) {
			StringBuilder sb = new StringBuilder();
			for (String e : list)
				sb.append(e).append(" ");
			res.add(sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1));
		} else {
			for (int j = i + 1; j <= s.length(); j++) {
				String word = s.substring(i, j);
				if (dict.contains(word)) {
					list.add(word);
					wordBreak(res, list, s, j, dict);
					list.remove(list.size() - 1);
				}
			}
		}
	}

	public List<String> wordBreak2(String s, Set<String> dict) {
		int max = 0;
		for (String e : dict)
			if (max < e.length()) max = e.length();

		List<List<String>> loc = new ArrayList<List<String>>(s.length());
		for (int i = 0; i < s.length(); i++) {
			List<String> list = new ArrayList<String>();
			int min = Math.min(i + max, s.length());
			for (int j = i + 1; j <= min; j++) {
				String word = s.substring(i, j);
				if (dict.contains(word)) {
					list.add(word);
				}
			}
			loc.add(list);
		}

		List<String> res = new ArrayList<String>();
		wordBreak2(res, new ArrayList<String>(), loc, s, 0);
		return res;
	}

	private void wordBreak2(List<String> res, ArrayList<String> list, List<List<String>> loc, String s, int i) {
		if (i == s.length()) {
			StringBuilder sb = new StringBuilder();
			for (String e : list)
				sb.append(e).append(" ");
			res.add(sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1));
		} else {
			for (String e : loc.get(i)) {
				list.add(e);
				wordBreak2(res, list, loc, s, i + e.length());
				list.remove(list.size() - 1);
			}
		}
	}

	public List<String> wordBreak3(String s, Set<String> dict) {
		int max = 0;
		for (String e : dict)
			if (max < e.length()) max = e.length();

		List<List<String>> loc = new ArrayList<List<String>>(s.length());
		for (int i = 0; i < s.length(); i++) {
			List<String> list = new ArrayList<String>();
			int min = Math.min(i + max, s.length());
			for (int j = i + 1; j <= min; j++) {
				String word = s.substring(i, j);
				if (dict.contains(word)) {
					list.add(word);
				}
			}
			loc.add(list);
		}
		List<List<String>> f = new ArrayList<List<String>>(s.length() + 1);
		for (int i = 0; i < s.length() + 1; i++)
			f.add(null);
		return wordBreak3(f, loc, s, 0);
	}

	private List<String> wordBreak3(List<List<String>> f, List<List<String>> loc, String s, int i) {
		if (f.get(i) == null) {
			if (i == s.length()) {
				List<String> list = new ArrayList<String>();
				list.add("");
				f.set(i, list);
			} else {
				List<String> list = new ArrayList<String>();
				for (String e : loc.get(i)) {
					for (String t : wordBreak3(f, loc, s, i + e.length())) {
						list.add(e + (t.length() == 0 ? "" : " " + t));
					}
				}
				f.set(i, list);
			}
		}
		return f.get(i);
	}
}
