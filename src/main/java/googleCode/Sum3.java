package googleCode;

import java.util.*;

public class Sum3 {
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < num.length - 2; i = next(num, i)) {
			int j = i + 1, k = num.length - 1;
			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				if (sum == 0) {
					List<Integer> e = new ArrayList<Integer>(3);
					e.add(num[i]);
					e.add(num[j]);
					e.add(num[k]);
					res.add(e);
					j = next(num, j);
					k = previous(num, k);
				} else if (sum < 0) {
					j = next(num, j);
				} else {
					k = previous(num, k);
				}
			}
		}
		return res;
	}
	
	public List<List<Integer>> threeSum2(int[] num) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i = next(num, i)) {
			int j = i + 1, k = num.length - 1;
			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				if (sum == 0) {
					res.add(Arrays.asList(num[i], num[j], num[k]));
					j = next(num, j);
					k = previous(num, k);
				} else if (sum < 0) {
					j = next(num, j);
				} else {
					k = previous(num, k);
				}
			}
		}
		return res;
	}

	private int previous(int[] num, int end) {
		int res = end - 1;
		for (; res >= 0 && num[res] == num[end]; res--)
			;
		return res;
	}

	private int next(int[] num, int frm) {
		int res = frm + 1;
		for (; res < num.length && num[res] == num[frm]; res++)
			;
		return res;
	}
}
