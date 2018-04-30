package solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Sum4 {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int len = num.length;
		if (len < 4) { return res; }

		Arrays.sort(num);
		for (int i = 0; i <= len - 4; i = findNext(num, i)) {
			for (int j = i + 1; j <= len - 3 && num[j] <= (target - num[i]) / 3; j = findNext(num, j)) {
				int k = j + 1, h = len - 1;
				int tmp = target - num[i] - num[j];
				while (k < h) {
					if (num[k] + num[h] == tmp) {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(num[i]);
						list.add(num[j]);
						list.add(num[k]);
						list.add(num[h]);
						res.add(list);
						k = findNext(num, k);
						h--;
					} else if (num[k] + num[h] < tmp) {
						k++;
					} else {
						h--;
					}
				}
			}
		}
		return res;
	}

	public int findNext(int[] num, int n) {
		int res = n + 1;
		for (; res < num.length && num[n] == num[res]; res++);
		return res;
	}
}
