package solutionReview;

import java.util.*;

public class CombinationSum {
	public static void main(String[] args) {
		int[] cand = { 6, 7, 7, 7, 7 };
		CombinationSum cs = new CombinationSum();
		System.out.println(cs.combinationSum(cand, 7));
	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		assert (target > 0);
		for (int e : candidates)
			assert (e > 0);
		Arrays.sort(candidates);
		return combinationSum(candidates, target, candidates.length - 1);
	}

	private ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target, int cur) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(cur == -1){
			return res;
		}else if(cur == 0){
			if(target % candidates[cur] == 0){
				ArrayList<Integer> list = new ArrayList<Integer>();
				for(int i = 0; i < target / candidates[cur]; i++){
					list.add(candidates[cur]);
				}
				res.add(list);
			}
			return res;
		}else{
			for(int i = 0; i <= target / candidates[cur]; i++){
				ArrayList<ArrayList<Integer>> tmp = combinationSum(candidates, target - i * candidates[cur], cur - 1);
				for(ArrayList<Integer> e : tmp){
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.addAll(e);
					for(int j = 0; j < i; j++){
						list.add(candidates[cur]);
					}
					res.add(list);
				}
			}
			return res;
		}
	}

	public int combinationSum2(int[] candidates, int target) {
		assert (target > 0);
		for (int e : candidates)
			assert (e > 0);
		Arrays.sort(candidates);
		return combinationSum2(candidates, target, candidates.length - 1);
	}

	public int combinationSum2(int[] cand, int target, int cur) {
		if (cur == -1) {
			return target == 0 ? 1 : 0;
		}

		int res = combinationSum2(cand, target, cur - 1);
		for (int i = 1; i <= target / cand[cur]; i++) {
			res += combinationSum2(cand, target - i * cand[cur], cur - 1);
		}
		return res;
	}
}