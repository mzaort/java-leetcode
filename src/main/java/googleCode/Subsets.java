package googleCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
    	Arrays.sort(S);
    	List<List<Integer>> res = new ArrayList<List<Integer>>(1 << S.length);
    	for(int i = 0; i < (1 << S.length); i++){
    		List<Integer> list = new ArrayList<Integer>();
    		for(int j = 0, val = i; j < S.length && val != 0; val >>>= 1, j++){
    			if((val & 1) == 1) list.add(S[j]);
    		}
    		res.add(list);
    	}
    	return res;
    }
    
    public List<List<Integer>> subsets2(int[] S){
    	Arrays.sort(S);
    	return subSets2(S, S.length);
    }

	private List<List<Integer>> subSets2(int[] S, int len) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(len == 0){
			res.add(new ArrayList<Integer>());
		}else{
			List<List<Integer>> tmp = subSets2(S, len - 1);
			res.addAll(tmp);
			for(List<Integer> e : tmp){
				List<Integer> list = new ArrayList<Integer>(e);
				list.add(S[len - 1]);
				res.add(list);
			}
		}
		return res;
	}
}
