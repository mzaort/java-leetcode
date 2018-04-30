package interview2018;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	private List<Interval> ranges = null;

	public SummaryRanges() {
		ranges = new ArrayList<>();
	}

	public void addNum(int val) {
		int i = 0;
		for (; i < ranges.size() && val > ranges.get(i).end; i++);
		if (i >= ranges.size() && (i == 0 || ranges.get(i - 1).end + 1 < val)) ranges.add(new Interval(val, val));
		else if (i >= ranges.size() && i > 0 && ranges.get(i - 1).end + 1 == val) ranges.get(i - 1).end++;
		else if (val >= ranges.get(i).start) return;
		else if (val == ranges.get(i).start - 1 && (i == 0 || ranges.get(i - 1).end + 1 < val)) ranges.get(i).start--;
		else if (val == ranges.get(i).start - 1 && i > 0 && ranges.get(i - 1).end + 1 == val) {
			ranges.get(i).start = ranges.get(i - 1).start;
			ranges.remove(i - 1);
		} else if (i == 0 || ranges.get(i - 1).end + 1 < val) ranges.add(i, new Interval(val, val));
		else ranges.get(i - 1).end++;
	}

	public void addNum2(int val) {
		int i = find(val);
		if (i >= ranges.size() && (i == 0 || ranges.get(i - 1).end + 1 < val)) ranges.add(new Interval(val, val));
		else if (i >= ranges.size() && i > 0 && ranges.get(i - 1).end + 1 == val) ranges.get(i - 1).end++;
		else if (val >= ranges.get(i).start) return;
		else if (val == ranges.get(i).start - 1 && (i == 0 || ranges.get(i - 1).end + 1 < val)) ranges.get(i).start--;
		else if (val == ranges.get(i).start - 1 && i > 0 && ranges.get(i - 1).end + 1 == val) {
			ranges.get(i).start = ranges.get(i - 1).start;
			ranges.remove(i - 1);
		} else if (i == 0 || ranges.get(i - 1).end + 1 < val) ranges.add(i, new Interval(val, val));
		else ranges.get(i - 1).end++;
	}

	private int find(int val) {
		int left = 0, right = ranges.size() - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			int pivot = ranges.get(mid).end;
			if (val > pivot) left = mid + 1;
			else if (val == pivot) return mid;
			else right = mid - 1;
		}
		return left;
	}

	public List<Interval> getIntervals() {
		return ranges;
	}
}
