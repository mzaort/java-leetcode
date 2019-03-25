package interview2018;

import java.util.Iterator;
import java.util.TreeSet;

public class ExamRoom {

	TreeSet<Integer> set;
	int n;

	public ExamRoom(int N) {
		set = new TreeSet<Integer>();
		n = N;
	}

	public int seat() {
		int res = 0;
		if (!set.isEmpty()) {
			int dis = -1;
			Iterator<Integer> iterator = set.iterator();
			int previous = iterator.next();
			while (iterator.hasNext()) {
				int next = iterator.next();
				int mid = (previous + ((next - previous) >>> 1));
				if (mid - previous > dis) {
					res = mid;
					dis = mid - previous;
				}
				previous = next;
			}
			int first = set.first();
			if (dis <= first && first != 0) {
				dis = first;
				res = 0;
			}
			int last = set.last();
			if (dis < n - 1 - last && last != n - 1) {
				res = n - 1;
			}
		}
		set.add(res);
		return res;
	}

	public void leave(int p) {
		set.remove(p);
	}
}
