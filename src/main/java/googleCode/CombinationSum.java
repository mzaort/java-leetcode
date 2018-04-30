package googleCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (target <= 0 || candidates.length == 0) return new ArrayList<List<Integer>>(0);
		Arrays.sort(candidates);
		return combinationSum(candidates, candidates.length - 1, target);
	}

	private List<List<Integer>> combinationSum(int[] candidates, int cur, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (target == 0) {
			res.add(new ArrayList<Integer>());
		} else if (cur == -1) {

		} else {
			int curp = cur - 1;
			for (; curp >= 0 && candidates[curp] == candidates[cur]; curp--);
			int n = target / candidates[cur];
			for (int i = 0; i <= n; i++) {
				for (List<Integer> e : combinationSum(candidates, curp, target - i * candidates[cur])) {
					List<Integer> list = new ArrayList<Integer>(e);
					for (int j = 0; j < i; j++)
						list.add(candidates[cur]);
					res.add(list);
				}
			}
		}
		return res;
	}
}
