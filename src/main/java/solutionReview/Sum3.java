package solutionReview;

import java.util.*;

public class Sum3 {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int len = num.length;
		if(len < 3) return res;

		Arrays.sort(num);
		for(int i = 0; i <= len - 3 && num[i] <= 0; i = findNext(num, i)){
			int j = i + 1, k = len - 1;
			int want = -num[i];
			while(j < k){
				if(num[j] + num[k] == want){
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[j]);
					list.add(num[k]);
					res.add(list);
					j = findNext(num, j);
					k--;
				}else if(num[j] + num[k] < want){
					j++;
				}else{
					k--;
				}
			}
		}
		return res;
	}

	private int findNext(int[] num, int want){
		int res = want + 1;
		for(; res < num.length && num[res] == num[want]; res++);
		return res;
	}
}