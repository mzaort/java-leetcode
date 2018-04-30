package googleCode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		assert (rowIndex >= 0);
		List<Integer> res = new ArrayList<Integer>();
		int[] f = new int[rowIndex + 1];
		f[0] = 1;
		for (int i = 1; i <= rowIndex; i++) {
			int prev = 1;
			for (int j = 1; j < i; j++) {
				int val = prev + f[j];
				prev = f[j];
				f[j] = val;
			}
			f[i] = 1;
		}
		for (int e : f)
			res.add(e);
		return res;
	}
}
