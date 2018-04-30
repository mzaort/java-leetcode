package googleCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class WordLadder {
	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		Set<String> dict = new HashSet<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
		System.out.println(wl.ladderLength("hit", "cog", dict));
	}

	public int ladderLength(String start, String end, Set<String> dict) {
		LinkedList<String> queue = new LinkedList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		queue.add(start);
		map.put(start, 1);
		String front = null;
		while ((front = queue.poll()) != null) {
			int distance = map.get(front);
			if (front.equals(end)) return distance;

			char[] chs = front.toCharArray();
			for (int i = 0; i < chs.length; i++) {
				char ch = chs[i];
				for (char c = 'a'; c <= 'z'; c++) {
					if (c != ch) {
						chs[i] = c;
						String s = new String(chs);
						if ((s.equals(end) || dict.contains(s)) && !map.containsKey(s)) {
							queue.add(s);
							map.put(s, distance + 1);
						}
					}
				}
				chs[i] = ch;
			}
		}
		return 0;
	}
}
