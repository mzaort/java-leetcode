package microsoft;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {

	public static void main(String[] args) {
		CombinationSumII cs2 = new CombinationSumII();
		int[] num = { 10, 1, 2, 7, 6, 1, 5 };
		System.out.println(cs2.combinationSum2(num, 8));
	}

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		int len = num.length;
		if (len == 0) return new ArrayList<ArrayList<Integer>>(0);
		Arrays.sort(num);
		return combinationSum2(num, target, len - 1);
	}

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target, int cur) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (cur == -1) {
			return res;
		} else {
			int end = cur - 1;
			for (; end >= 0 && num[end] == num[cur]; end--);
			int cnt = cur - end;

			int n = target / num[cur];
			if (target % num[cur] == 0) n--;

			int min = cnt > n ? n : cnt;
			for (int i = 0; i <= min; i++) {
				ArrayList<ArrayList<Integer>> tmp = combinationSum2(num, target - i * num[cur], end);
				for (ArrayList<Integer> e : tmp) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.addAll(e);
					for (int j = 0; j < i; j++) {
						list.add(num[cur]);
					}
					res.add(list);
				}
			}

			if (target % num[cur] == 0 && target / num[cur] <= cnt) {
				ArrayList<Integer> list = new ArrayList<Integer>(1);
				for (int i = 0; i < target / num[cur]; i++) {
					list.add(num[cur]);
				}
				res.add(list);
			}

			return res;
		}
	}
}