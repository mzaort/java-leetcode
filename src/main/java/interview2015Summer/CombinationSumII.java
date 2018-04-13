package interview2015Summer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum(int[] num, int target){
		//num. > 0, target > 0
		Arrays.sort(num);
		return combinationSum(num, num.length - 1, target);
	}

	private List<List<Integer>> combinationSum(int[] num, int cur, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if(target == 0){
			res.add(new ArrayList<Integer>());
		}else if(cur < 0){
			
		}else{
			int curp = cur - 1;
			for(; curp >= 0 && num[curp] == num[cur]; curp--);
			int n = Math.min(cur - curp, target / num[cur]);
			for(int i = 0; i <= n; i++){
				for(List<Integer> e : combinationSum(num, curp, target - i * num[cur])){
					List<Integer> list = new ArrayList<>(e);
					for(int j = 0; j < i; j++) list.add(num[cur]);
					res.add(list);
				}
			}
		}
		return res;
	}
	
	public List<List<Integer>> combinationSum2(int[] num, int target){
		//num. > 0, target > 0
		Arrays.sort(num);
		List<List<Integer>> res = new ArrayList<>();
		combinationSum2(res, new ArrayList<Integer>(), num, num.length - 1, target);
		return res;
	}

	private void combinationSum2(List<List<Integer>> res,
			List<Integer> list, int[] num, int cur, int target) {
		if(target == 0) res.add(list);
		else if(cur < 0) ;
		else{
			int curp = cur - 1;
			for(; curp >= 0 && num[curp] == num[cur]; curp--);
			int n = Math.min(cur - curp, target / num[cur]);
			for(int i = 0; i <= n; i++){
				List<Integer> tmp = new ArrayList<>(Collections.nCopies(i, num[cur]));
				combinationSum2(res, tmp, num, curp, target - i * num[cur]);
			}
		}
	}
}
