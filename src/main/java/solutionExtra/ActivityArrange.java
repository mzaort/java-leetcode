package solutionExtra;

import java.util.Arrays;
import java.util.Comparator;

public class ActivityArrange {

	public static void main(String[] args) {
		// int len = 5;
		// Activity[] act = new Activity[len];
		// for(int i = 0; i < len; i++){
		// int num1 = (int) (Math.random() * 10);
		// int num2 = (int) (Math.random() * 10);
		// if(num1 > num2){
		// int tmp = num1;
		// num1 = num2;
		// num2 = tmp;
		// }
		// act[i] = new Activity(num1, num2);
		// }
		// for(Activity a:act){
		// System.out.println(a.start + "\t" + a.end);
		// }
		// System.out.println(new ActivityArrange().arrangeQuantity(act));

		int len = 5;
		Activity[] act = new Activity[len];
		for (int i = 0; i < len; i++) {
			int num1 = (int) (Math.random() * 10);
			int num2 = (int) (Math.random() * 10);
			int num3 = (int) (Math.random() * 5);
			if (num1 > num2) {
				int tmp = num1;
				num1 = num2;
				num2 = tmp;
			}
			act[i] = new Activity(num1, num2, num3);
		}
		for (Activity a : act) {
			System.out.println(a.start + "\t" + a.end + "\t" + a.value);
		}
		System.out.println(new ActivityArrange().arrangeValue(act));
	}

	public int arrangeQuantity(Activity[] activities) {
		int len = activities.length;
		if (len <= 1) return len;
		Arrays.sort(activities, new ActivityEndComparator());
		int res = 1;
		int frm = activities[0].end;
		for (int i = 1; i < len; i++) {
			if (activities[i].start >= frm) {
				res++;
				frm = activities[i].end;
			}
		}
		return res;
	}

	public int arrangeValue(Activity[] activities) {
		int len = activities.length;
		if (len == 0) return 0;
		Arrays.sort(activities, new ActivityStartComparator());
		return arrangeValue(activities, 0);
	}

	private int arrangeValue(Activity[] activities, int frm) {
		if (frm == activities.length) return 0;
		int notSelect = arrangeValue(activities, frm + 1);
		int next = frm + 1;
		for (; next < activities.length; next++) {
			if (activities[next].start >= activities[frm].end) {
				break;
			}
		}
		int select = activities[frm].value + arrangeValue(activities, next);
		return notSelect > select ? notSelect : select;
	}
}

class ActivityEndComparator implements Comparator<Activity> {
	@Override
	public int compare(Activity o1, Activity o2) {
		if (o1.end > o2.end) {
			return 1;
		} else if (o1.end == o2.end) {
			return 0;
		} else {
			return -1;
		}
	}
}

class ActivityStartComparator implements Comparator<Activity> {
	@Override
	public int compare(Activity o1, Activity o2) {
		if (o1.start > o2.start) {
			return 1;
		} else if (o1.start == o2.start) {
			return 0;
		} else {
			return -1;
		}
	}
}