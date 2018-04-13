package googleCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] num) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	Arrays.sort(num);
    	while(true){
    		List<Integer> list = new ArrayList<Integer>();
    		for(int e : num) list.add(e);
    		res.add(list);
    		int i = num.length - 2;
    		for(; i >= 0 && num[i] >= num[i + 1]; i--);
    		if(i == -1) return res;
    		for(int j = i + 1, k = num.length - 1; j < k; j++, k--) swap(num, j, k);
    		swap(num, i, insertRight(num, i + 1, num.length - 1, num[i]));
    	}   	
    }
    
    public List<List<Integer>> permute2(int[] num){
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	permute2(res, num, 0);
    	return res;
    }

	private void permute2(List<List<Integer>> res, int[] num, int cur) {
		if(cur >= num.length - 1){
			List<Integer> list = new ArrayList<Integer>();
			for(int e : num) list.add(e);
			res.add(list);
		}else{
			for(int i = cur; i < num.length; i++){
				swap(num, i, cur);
				permute2(res, num, cur + 1);
				swap(num, i, cur);
			}
		}
	}

	private int insertRight(int[] A, int i, int j, int target) {
		while(i <= j){
			int mid = i + ((j - i) >>> 1);
			if(A[mid] <= target) i = mid + 1;
			else j = mid - 1;
		}
		return i;
	}

	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
