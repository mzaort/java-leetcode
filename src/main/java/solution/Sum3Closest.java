package solution;

import java.util.Arrays;

public class Sum3Closest {
	public static void main(String[] args) {
		Sum3Closest s3c = new Sum3Closest();
		System.out.println(s3c.threeSumClosest(new int[] { 1, 1, 1, 0 }, 100));
	}

	public int threeSumClosest(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num == null || num.length < 3) return 0;

		Arrays.sort(num);
		int res = num[0] + num[1] + num[2];
		int diff = res - target;
		int len = num.length;
		for (int a = 0; a < len - 2;) {
			for (int b = a + 1, c = len - 1; b < c;) {
				int res2 = num[a] + num[b] + num[c];
				int diff2 = res2 - target;
				if (Math.abs(diff2) < Math.abs(diff)) {
					res = res2;
					diff = diff2;
				}
				if (diff2 < 0) {
					b++;
				} else if (diff2 > 0) {
					c--;
				} else {
					return res;
				}
			}
			int i;
			for (i = a + 1; i < len - 2 && num[i] == num[a]; i++);
			a = i;
		}
		return res;
	}
}
