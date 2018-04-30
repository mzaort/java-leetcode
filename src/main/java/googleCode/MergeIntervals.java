package googleCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();
		if (intervals.size() != 0) {
			Collections.sort(intervals, new Comparator<Interval>() {
				@Override
				public int compare(Interval o1, Interval o2) {
					if (o1.start < o2.start) return -1;
					else if (o1.start == o2.start) return 0;
					else return 1;
				}
			});
			Interval prev = intervals.get(0);
			for (int i = 1; i < intervals.size(); i++) {
				Interval tmp = intervals.get(i);
				if (tmp.start > prev.end) {
					res.add(prev);
					prev = tmp;
				} else {
					if (prev.end < tmp.end) prev.end = tmp.end;
				}
			}
			res.add(prev);
		}
		return res;
	}
}
