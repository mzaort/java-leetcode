package googleCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
    	if(target <= 0 || num.length == 0) return new ArrayList<List<Integer>>(0);
    	Arrays.sort(num);
    	return combinationSum2(num, num.length - 1, target);
    }

	private List<List<Integer>> combinationSum2(int[] num, int cur, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(target == 0){
			res.add(new ArrayList<Integer>());
		}else if(cur == -1){
			
		}else{
			int curp = cur - 1;
			for(; curp >= 0 && num[curp] == num[cur]; curp--);
			int n = Math.min(cur - curp, target / num[cur]);
			for(int i = 0; i <= n; i++){
				List<List<Integer>> tmp = combinationSum2(num, curp, target - i * num[cur]);
				for(List<Integer> e : tmp){
					for(int j = 0; j < i; j++) e.add(num[cur]);
				}
				res.addAll(tmp);
			}
		}
		return res;
	}
}
