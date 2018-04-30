package googleCode;

import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		assert (n > 0);
		int[] f = new int[n];
		f[0] = triangle.get(0).get(0);
		for (int i = 1; i < n; i++) {
			List<Integer> list = triangle.get(i);
			int prev = f[0] + 1;
			f[i] = f[i - 1] + 1;
			for (int j = 0; j <= i; j++) {
				int val = prev > f[j] ? f[j] : prev;
				prev = f[j];
				f[j] = val + list.get(j);
			}
		}
		int min = f[0];
		for (int i = 1; i < n; i++)
			if (min > f[i]) min = f[i];
		return min;
	}
}
