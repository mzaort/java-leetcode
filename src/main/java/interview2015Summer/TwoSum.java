package interview2015Summer;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	
	public static void main(String[] args) {
		int[][] mat = {{1, 3}, {-2, 3}, {-1, 4}};
		Arrays.sort(mat, (o1, o2)->o1[0] - o2[0]);
		System.out.println(Arrays.deepToString(mat));
	}
	public int[] twoSum(int[] A, int target) {
		int[] res = {-1, -1};
		
		class Pair{
			int val;
			int ind;
			public Pair(int val, int ind) {
				super();
				this.val = val;
				this.ind = ind;
			}
		}
		Pair[] p = new Pair[A.length];
		for(int i = 0; i < A.length; i++) p[i] = new Pair(A[i], i + 1);
		
		Arrays.sort(p, (o1, o2) -> o1.val - o2.val);
		for(int i = 0, j = A.length - 1; i < j;){
			int sum = p[i].val + p[j].val;
			if(sum == target){
				res[0] = Math.min(p[i].ind, p[j].ind);
				res[1] = Math.max(p[i].ind, p[j].ind);
				return res;
			}else if(sum < target){
				i++;
			}else{
				j--;
			}
		}
		return res;
	}
	
	public int[] twoSum2(int[] A, int target){
		int[] res = {-1, -1};
		HashMap<Integer, Integer> map = new HashMap<>();
		Integer val = null;
		for(int i = 0; i < A.length; i++){
			if((val = map.get(target - A[i])) != null){
				res[0] = val + 1;
				res[1] = i + 1;
				return res;
			}
			map.put(A[i], i);
		}
		return res;
	}
}
