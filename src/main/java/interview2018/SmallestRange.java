package interview2018;

import java.util.List;
import java.util.TreeSet;

public class SmallestRange {
	public int[] smallestRange(List<List<Integer>> nums) {
		int[] res = { Integer.MIN_VALUE, Integer.MAX_VALUE };
		long dis = Long.valueOf(res[1]) - Long.valueOf(res[0]);
		int[] index = new int[nums.size()];
		TreeSet<Integer> set = new TreeSet<>((e1, e2) -> {
			if (e1 == e2) return 0;
			int v1 = nums.get(e1).get(index[e1]);
			int v2 = nums.get(e2).get(index[e2]);
			return v1 == v2 ? e1 - e2 : v1 - v2;
		});
		for (int i = 0; i < index.length; i++) {
			List<Integer> list = nums.get(i);
			if (list == null || list.size() == 0) return res;
			set.add(i);
		}
		while (true) {
			int first = set.first();
			int last = set.last();
			int min = nums.get(first).get(index[first]);
			int max = nums.get(last).get(index[last]);
			long diff = Long.valueOf(max) - Long.valueOf(min);
			if (diff < dis) {
				dis = diff;
				res[0] = min;
				res[1] = max;
			}
			set.remove(first);
			index[first]++;
			if (index[first] == nums.get(first).size()) break;
			set.add(first);
		}
		return res;
	}
}
