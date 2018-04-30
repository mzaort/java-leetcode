package googleCode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<Integer>();
		for (int e : num)
			set.add(e);

		int res = 0;
		for (int e : num) {
			if (set.contains(e)) {
				int cnt = 1;
				set.remove(e);

				int val = e + 1;
				while (set.contains(val)) {
					set.remove(val);
					cnt++;
					val++;
				}
				val = e - 1;
				while (set.contains(val)) {
					set.remove(val);
					cnt++;
					val--;
				}
				if (res < cnt) res = cnt;
			}
		}
		return res;
	}
}
