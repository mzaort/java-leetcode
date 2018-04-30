package interview2015Summer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
		LinkedList<String> queue = new LinkedList<String>();
		Map<String, Integer> map = new HashMap<>();
		queue.offer(start);
		map.put(start, 1);

		String fr = null;
		while (null != (fr = queue.poll())) {
			Integer d = map.get(fr);
			if (fr.equals(end)) return d;
			char[] cstr = fr.toCharArray();
			for (int i = 0; i < cstr.length; i++) {
				char ch = cstr[i];
				for (char c = 'a'; c <= 'z'; c++) {
					if (ch != c) {
						cstr[i] = c;
						String s = new String(cstr);
						if ((s.equals(end) || dict.contains(s)) && !map.containsKey(s)) {
							queue.offer(s);
							map.put(s, d + 1);
						}
					}
				}
				cstr[i] = ch;
			}
		}
		return 0;
	}
}
