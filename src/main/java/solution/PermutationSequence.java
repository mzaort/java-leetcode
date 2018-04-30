package solution;

import java.util.Arrays;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n < 1 || n > 9 || k < 1) return "";
		int[] fact = new int[n];
		fact[0] = 1;
		for (int i = 1; i < n; i++) {
			fact[i] = fact[i - 1] * i;
		}
		if (k > fact[n - 1] * n) return "";
		k--;

		int[] inter = new int[n];
		Arrays.fill(inter, 0);

		for (int i = n - 1; i >= 0 && k > 0; i--) {
			inter[i] = k / fact[i];
			k = k % fact[i];
		}

		StringBuilder sb = new StringBuilder();
		int[] has = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			int tmp = inter[i] + 1;
			int loc = i + 1;
			for (; loc < n; loc++) {
				if (has[loc] <= tmp) {
					tmp++;
					has[loc - 1] = has[loc];
				} else {
					break;
				}
			}
			has[loc - 1] = tmp;
			sb.append(tmp);
		}
		return new String(sb);
	}
}
