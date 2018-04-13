package googleCode;

import java.util.Arrays;

public class Sum3Closet {
    public int threeSumClosest(int[] num, int target) {
    	assert(num.length >= 3);
    	int res = num[0] + num[1] + num[2];
    	
    	Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i = next(num, i)) {
			int j = i + 1, k = num.length - 1;
			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				if (sum == target) {
					res = sum;
					return res;
				} else if(Math.abs(res - target) > Math.abs(sum - target)){
					res = sum;
				}
				//JobInterview
				if (sum < target) {
					j = next(num, j);
				} else {
					k = previous(num, k);
				}
			}
		}
		return res;
    }
    
	private int previous(int[] num, int end) {
		int res = end - 1;
		for (; res >= 0 && num[res] == num[end]; res--)
			;
		return res;
	}

	private int next(int[] num, int frm) {
		int res = frm + 1;
		for (; res < num.length && num[res] == num[frm]; res++)
			;
		return res;
	}
}
