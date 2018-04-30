package googleCode;

import java.util.*;
import java.util.Arrays;

public class Sum4 {

	public List<List<Integer>> fourSum(int[] num, int target) {
		// assert(num.length >= 4);��ʾ���� �Ķ���һ��Ҫ����4
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = num.length;

		Arrays.sort(num);
		for (int i = 0; i < len - 3 && num[i] <= target / 4; i = findNext(num, i)) {
			for (int j = i + 1; j < len - 2 && num[j] <= (target - num[i]) / 3; j = findNext(num, j)) {
				int want = target - num[i] - num[j];
				int k = j + 1, h = len - 1;
				while (k < h) {
					int sum = num[k] + num[h] - want;
					if (sum == 0) {
						ArrayList<Integer> list = new ArrayList<Integer>(4);
						list.add(num[i]);
						list.add(num[j]);
						list.add(num[k]);
						list.add(num[h]);
						res.add(list);
						k = findNext(num, k);
						h = findPrevious(num, h);
					} else if (sum < 0) {
						k = findNext(num, k);
					} else {
						h = findPrevious(num, h);
					}
				}
			}
		}
		return res;
	}

	private int findNext(int[] num, int frm) {
		int cur = frm + 1;
		for (; cur < num.length && num[cur] == num[frm]; cur++);
		return cur;
	}

	private int findPrevious(int[] num, int end) {
		int cur = end - 1;
		for (; cur >= 0 && num[cur] == num[end]; cur--);
		return cur;
	}

}
