package solutionReview;

import java.util.*;

public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> res = new ArrayList<String>();
		int len = strs.length;
		if (len == 0) return res;

		char[][] cstr = new char[len][];
		for (int i = 0; i < len; i++) {
			char[] tmp = strs[i].toCharArray();
			Arrays.sort(tmp);
			cstr[i] = tmp;
		}

		boolean[] flag = new boolean[len];
		for (int i = 0; i < len; i++)
			flag[i] = false;
		for (int i = 0; i < len; i++) {
			if (!flag[i]) {
				for (int j = i + 1; j < len; j++) {
					if (!flag[j] && isEqual(cstr[i], cstr[j])) {
						flag[j] = true;
						flag[i] = true;
						res.add(strs[j]);
					}
				}
				if (flag[i]) {
					res.add(strs[i]);
				}
			}
		}
		return res;
	}

	private boolean isEqual(char[] cs, char[] cs2) {
		int len1 = cs.length;
		if (len1 != cs2.length) return false;
		for (int i = 0; i < len1; i++) {
			if (cs[i] != cs2[i]) { return false; }
		}
		return true;
	}

	public ArrayList<String> anagrams2(String[] strs) {
		ArrayList<String> res = new ArrayList<String>();
		int len = strs.length;
		if (len == 0) return res;

		boolean[] flag = new boolean[len];
		for (int i = 0; i < len; i++)
			flag[i] = false;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < len; i++) {
			char[] tmp = strs[i].toCharArray();
			Arrays.sort(tmp);
			String s = new String(tmp);
			if (map.containsKey(s)) {
				int key = map.get(s);
				if (!flag[key]) {
					res.add(strs[key]);
					flag[key] = true;
				}
				res.add(strs[i]);
				flag[i] = true;
			} else {
				map.put(s, i);
			}
		}
		return res;
	}

	public ArrayList<String> anagrams3(String[] strs) {
		ArrayList<String> res = new ArrayList<String>();
		int len = strs.length;
		if (len == 0) return res;

		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < len; i++) {
			char[] tmp = strs[i].toCharArray();
			Arrays.sort(tmp);
			String s = new String(tmp);
			if (!map.containsKey(s)) {
				map.put(s, new ArrayList<Integer>());
			}
			map.get(s).add(i);
		}
		for (Map.Entry<String, ArrayList<Integer>> e : map.entrySet()) {
			if (e.getValue().size() > 1) {
				for (Integer i : e.getValue()) {
					res.add(strs[i]);
				}
			}
		}
		return res;
	}
}