package microsoft;

import java.util.*;

public class CombinationSum {

	public static void main(String[] args) {
		int[] candidates = { 8, 7, 4, 3 };
		CombinationSum cs = new CombinationSum();
		System.out.println(cs.combinationSum(candidates, 11));
	}

	public int combinationSum2(int[] candidates, int target) {
		int len = candidates.length;
		if (len == 0) return 0;
		Arrays.sort(candidates);
		return combinationSum2(candidates, target, len - 1);
	}

	public int combinationSum2(int[] candidates, int target, int cur) {
		if (cur == 0) {
			return target % candidates[0] == 0 ? 1 : 0;
		} else {
			int res = 0;
			int num = target / candidates[cur];
			if (target % candidates[cur] == 0) {
				res++;
				num--;
			}
			for (int i = num; i >= 0; i--) {
				res += combinationSum2(candidates, target - i * candidates[cur], cur - 1);
			}
			return res;
		}
	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		int len = candidates.length;
		if (len == 0) return new ArrayList<ArrayList<Integer>>(0);
		Arrays.sort(candidates);
		return combinationSum(candidates, target, len - 1);
	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target, int cur) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (cur == 0) {
			if (target % candidates[0] == 0) {
				int cnt = target / candidates[0];
				ArrayList<Integer> list = new ArrayList<Integer>(cnt);
				for (int i = 0; i < cnt; i++) {
					list.add(candidates[0]);
				}
				res.add(list);
			}
			return res;
		} else {
			int num = target / candidates[cur];
			if (target % candidates[cur] == 0) {
				num--;
			}
			for (int i = 0; i <= num; i++) {
				ArrayList<ArrayList<Integer>> tmp = combinationSum(candidates, target - i * candidates[cur], cur - 1);
				for (ArrayList<Integer> e : tmp) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.addAll(e);
					for (int j = 0; j < i; j++) {
						list.add(candidates[cur]);
					}
					res.add(list);
				}
			}
			if (target % candidates[cur] == 0) {
				num = target / candidates[cur];
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i = 0; i < num; i++) {
					list.add(candidates[cur]);
				}
				res.add(list);
			}
			return res;
		}
	}
}