package solution;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = A.length;
		if (len == 0) return 0;
		int res = A[0], pres = A[0];
		for (int i = 1; i < len; i++) {
			if (pres > 0) {
				pres += A[i];
			} else {
				pres = A[i];
			}
			if (res < pres) {
				res = pres;
			}
		}
		return res;
	}
}
