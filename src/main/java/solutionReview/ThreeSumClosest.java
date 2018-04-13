package solutionReview;

import java.util.Arrays;

public class ThreeSumClosest{
	public int threeSumClosest(int[] num, int target){
		int len = num.length;
		if(len < 3) return 0;
		
		int res = num[0] + num[1] + num[2];
		int min = res > target ? res - target : target - res;

		Arrays.sort(num);
		for(int i = 0; i <= len - 3; i = findNext(num, i)){
			int j = i + 1, k = len - 1;
			int want = target -num[i];
			while(j < k){
				int tmp = num[j] + num[k];
				if(tmp == want){
					return target;
				}else if(tmp < want){
					int mintmp = want - tmp;
					if(mintmp < min){
						min = mintmp;
						res = num[i] + num[j] + num[k];
					}
					j++;
				}else{
					int mintmp = tmp - want;
					if(mintmp < min){
						min = mintmp;
						res = num[i] + num[j] + num[k];
					}
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