package interview2015Summer;

import java.util.*;

public class WordLadderII {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> res = new ArrayList<>();

		LinkedList<String> queue = new LinkedList<String>();
		Map<String, Integer> dist = new HashMap<>();
		Map<String, List<String>> pre = new HashMap<>();
		queue.offer(start);
		dist.put(start, 1);
		pre.put(start, new ArrayList<>());

		String fr = null;
		while (null != (fr = queue.poll())) {
			Integer d = dist.get(fr);
			if (fr.equals(end)) {
				generatePath(res, new ArrayList<String>(), pre, start, end);
				return res;
			}
			char[] cstr = fr.toCharArray();
			for (int i = 0; i < cstr.length; i++) {
				char ch = cstr[i];
				for (char c = 'a'; c <= 'z'; c++) {
					if (ch != c) {
						cstr[i] = c;
						String s = new String(cstr);
						if (s.equals(end) || dict.contains(s)) {
							Integer dt = dist.get(s);
							if (dt == null) {
								queue.offer(s);
								dist.put(s, d + 1);
								pre.put(s, new ArrayList<>());
								pre.get(s).add(fr);
							} else if (dt == d + 1) {
								pre.get(s).add(fr);
							}
						}
					}
				}
				cstr[i] = ch;
			}
		}

		return res;
	}

	private void generatePath(List<List<String>> res, List<String> list, Map<String, List<String>> pre, String start,
			String end) {
		if (start.equals(end)) {
			list.add(start);
			Collections.reverse(list);
			res.add(list);
		} else {
			for (String e : pre.get(end)) {
				List<String> lt = new ArrayList<>(list);
				list.add(end);
				generatePath(res, lt, pre, start, e);
			}
		}
	}
}
