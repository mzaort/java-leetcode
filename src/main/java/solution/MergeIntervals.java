package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
	public static void main(String[] args) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		res.add(new Interval(1, 4));
		res.add(new Interval(2, 5));
		System.out.println(new MergeIntervals().Wrongmerge2(res));
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (intervals == null || intervals.size() == 0) return intervals;
		Collections.sort(intervals, new IntervalComparator());
		ArrayList<Interval> res = new ArrayList<Interval>();

		Interval tmp = intervals.get(0);
		Interval previous = new Interval(tmp.start, tmp.end);

		for (int i = 1; i < intervals.size(); i++) {
			tmp = intervals.get(i);
			if (tmp.start > previous.end) {
				res.add(previous);
				previous = new Interval(tmp.start, tmp.end);
			} else {
				previous.end = previous.end > tmp.end ? previous.end : tmp.end;
			}
		}
		res.add(previous);
		return res;
	}

	public ArrayList<Interval> Wrongmerge2(ArrayList<Interval> intervals) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (intervals == null || intervals.size() == 0) return intervals;

		int max = -1;
		for (Interval e : intervals) {
			if (max < e.end) {
				max = e.end;
			}
		}

		int[] bitmask = new int[max + 1];
		for (int i = 0; i < bitmask.length; i++)
			bitmask[i] = 0;

		for (Interval e : intervals) {
			for (int i = e.start; i <= e.end; i++)
				bitmask[i] = 1;
		}

		ArrayList<Interval> res = new ArrayList<Interval>();

		boolean flag = false;
		Interval it = null;
		for (int i = 0; i < bitmask.length; i++) {
			if (flag) {
				if (bitmask[i] == 0) {
					it.end = i - 1;
					res.add(it);
					flag = false;
				} else {

				}
			} else {
				if (bitmask[i] == 0) {

				} else {
					it = new Interval();
					it.start = i;
					flag = true;
				}
			}
		}

		if (bitmask[max] == 1) {
			it.end = max;
			res.add(it);
		}

		return res;
	}
}

class IntervalComparator implements Comparator<Interval> {

	@Override
	public int compare(Interval o1, Interval o2) {
		if (o1.start > o2.start) {
			return 1;
		} else if (o1.start == o2.start) {
			return 0;
		} else {
			return -1;
		}
	}

}
