package microsoft;

import java.util.Arrays;

public class Pearl {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 0, 1, 1, 2, 1 };
		Pearl pearl = new Pearl();
		System.out.println(pearl.lengthOfAllColors(arr, 3));
	}

	public int lengthOfAllColors(int[] arr, int n) {
		assert (isValid(arr, n));

		if (n == 1){
			return 1;
		}

		int len = arr.length;
		int[] f = new int[len];
		f[0] = minExpand(arr, 0, n);

		int res = (len - f[0] + 1) % len;
		for (int i = 1; i < len; i++) {
			if (arr[i] == arr[i - 1]) {
				f[i] = f[i - 1];
			} else if (arr[i] != arr[f[i - 1]]) {
				f[i] = f[i - 1];
			} else {
				f[i] = minExpand(arr, i, n);
				int tmp = (i - f[i] + len + 1) % len;
				if (tmp < res)
					res = tmp;
			}
		}
		return res;
	}

	private boolean isValid(int[] arr, int n) {
		int len = arr.length;
		if (!(n > 0 && len >= n))
			return false;
		boolean[] mask = new boolean[n];
		Arrays.fill(mask, false);
		int num = 0;
		for (int i = 0; i < len; i++) {
			if (arr[i] >= 0 && arr[i] < n) {
				if (mask[arr[i]] == false) {
					mask[arr[i]] = true;
					num++;
				}
			} else {
				return false;
			}
		}
		return num == n;
	}

	/*
	 * all elements in arr must be less than n and greater than -1; n > 1
	 */
	private int minExpand(int[] arr, int loc, int n) {
		boolean[] mask = new boolean[n];
		Arrays.fill(mask, false);

		int i = loc, num = 0;
		for (;; i = (i - 1 + arr.length) % arr.length) {
			if (mask[arr[i]] == false) {
				mask[arr[i]] = true;
				num++;
				if (num == n) {
					break;
				}
			}
		}
		return i;
	}
	
	public int lengthOfAllColors2(int[] A, int n){
		int L = A.length;
		int last = -1, match = n, min = L;
		int[] f = new int[n];
		for(int i = 0, j = 0; j < 2 * L - 1; j++, i = (i + 1) % L){
			f[A[i]]++;
			if(f[A[i]] == 1) match--;
			while(last < L - 1 && f[A[last + 1]] > 1){
				f[A[last + 1]]--;
				last++;
			}
			if(match == 0) min = Math.min(min, (i - last + L) % L);
			if(last == L - 1) break;
		}
		return min;
	}
}