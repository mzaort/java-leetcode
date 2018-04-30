package googleCode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		Combinations c = new Combinations();
		System.out.println(c.combine(3, 2));
	}

	public List<List<Integer>> combine(int n, int k) {
		assert (k >= 0 && k <= n);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int[] comb = new int[k];
		for (int i = 0; i < k; i++)
			comb[i] = i + 1;
		while (true) {
			List<Integer> tmp = new ArrayList<Integer>();
			for (int e : comb)
				tmp.add(e);
			res.add(tmp);
			int i = k - 1;
			for (; i >= 0 && comb[i] == n - k + i + 1; i--);
			if (i == -1) return res;
			for (int val = comb[i]; i < k; i++)
				comb[i] = ++val;
		}
	}
}
