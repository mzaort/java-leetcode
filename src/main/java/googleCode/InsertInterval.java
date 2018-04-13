package googleCode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public static void main(String[] args) {
		List<Interval> v = new ArrayList<Interval>();
		v.add(new Interval(1, 2));
		v.add(new Interval(3, 5));
		v.add(new Interval(6, 7));
		v.add(new Interval(8, 10));
		v.add(new Interval(12, 16));
		System.out.println(new InsertInterval().insert(v, new Interval(17, 19)));
	}
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        int cur;
        for(cur = 0; cur < intervals.size() && intervals.get(cur).end < newInterval.start; cur++) res.add(intervals.get(cur));
        int frm = cur;
        for(; cur < intervals.size() && intervals.get(cur).start <= newInterval.end; cur++);
        if(cur - 1 < frm){
        	res.add(newInterval);
        }else{
			Interval tmp = new Interval();
			Interval i1 = intervals.get(frm), i2 = intervals.get(cur - 1);
			tmp.start = i1.start > newInterval.start ? newInterval.start : i1.start;
			tmp.end = i2.end > newInterval.end ? i2.end : newInterval.end;
			res.add(tmp);
        }
        for (; cur < intervals.size(); cur++)
        	res.add(intervals.get(cur));
        return res;
    }
}
