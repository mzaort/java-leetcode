package solutionReview;

import java.util.*;


public class CombinationSumII {
	public static void main(String[] args) {
		int[] cand = { 2, 2, 2};
		CombinationSumII cs = new CombinationSumII();
		System.out.println(cs.combinationSum2(cand, 4));
	}

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates,
			int target) {
		assert (target > 0);
		for (int e : candidates)
			assert (e > 0);
		Arrays.sort(candidates);
		return combinationSum2(candidates, target, candidates.length - 1);
	}

	private ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates,
			int target, int cur) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (cur == -1) {
			return res;
		} else if (target == candidates[cur]) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(candidates[cur]);
			res.add(list);
			int i = cur - 1;
			for(; i >= 0 && candidates[i] == candidates[cur]; i--);
			res.addAll(combinationSum2(candidates, target, i));
			return res;
		} else {
			int i = cur - 1;
			for(; i >= 0 && candidates[i] == candidates[cur]; i--);
			ArrayList<ArrayList<Integer>> tmp = combinationSum2(candidates,
					target, i);
			res.addAll(tmp);
			if (target >= candidates[cur]) {
				tmp = combinationSum2(candidates, target - candidates[cur],
						cur - 1);
				for (ArrayList<Integer> e : tmp) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.addAll(e);
					list.add(candidates[cur]);
					res.add(list);
				}
			}
			return res;
		}
	}
	
	private ArrayList<ArrayList<Integer>> combinationSum3(int[] candidates,
			int target, int cur) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (cur == -1) {
			return res;
		} else if (cur == 0) {
			if(candidates[cur] == target){
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(candidates[cur]);
				res.add(list);
			}
			return res;
		} else {
			int i = cur - 1;
			for(; i >= 0 && candidates[i] == candidates[cur]; i--);
			ArrayList<ArrayList<Integer>> tmp = combinationSum3(candidates,
					target, i);
			res.addAll(tmp);
			if (target >= candidates[cur]) {
				tmp = combinationSum3(candidates, target - candidates[cur],
						cur - 1);
				for (ArrayList<Integer> e : tmp) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.addAll(e);
					list.add(candidates[cur]);
					res.add(list);
				}
			}
			return res;
		}
	}
}