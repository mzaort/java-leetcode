package solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets2 {
	public static void main(String[] args) {
		Subsets2 s2 = new Subsets2();
		System.out.println(s2.subsetsWithDup(new int[] { 2, 2, 2 }));
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num == null) return null;
		Arrays.sort(num);
		return subsetsWithDup(num, num.length - 1);
	}

	private ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num, int i) {
		ArrayList<ArrayList<Integer>> res;
		if (i == -1) {
			res = new ArrayList<ArrayList<Integer>>(1);
			res.add(new ArrayList<Integer>());
			return res;
		}

		int cnt = 1;
		for (int j = i - 1; j >= 0 && num[j] == num[i]; j--, cnt++);
		ArrayList<ArrayList<Integer>> tmp = subsetsWithDup(num, i - cnt);
		res = new ArrayList<ArrayList<Integer>>((1 << (i - cnt + 1)) * (cnt + 1));
		res.addAll(tmp);
		for (int k = 1; k <= cnt; k++) {
			for (ArrayList<Integer> e : tmp) {
				ArrayList<Integer> ex = new ArrayList<Integer>();
				for (Integer t : e) {
					ex.add(t);
				}
				for (int j = 0; j < k; j++) {
					ex.add(num[i]);
				}
				res.add(ex);
			}
		}

		return res;
	}

	private ArrayList<ArrayList<Integer>> subsetsWithDup2(int[] num, int i) {
		ArrayList<ArrayList<Integer>> res;
		if (i == -1) {
			res = new ArrayList<ArrayList<Integer>>(1);
			res.add(new ArrayList<Integer>());
			return res;
		}

		int cnt = 1;
		for (int j = i - 1; j >= 0 && num[j] == num[i]; j--, cnt++);
		ArrayList<ArrayList<Integer>> tmp = subsetsWithDup(num, i - cnt);
		res = new ArrayList<ArrayList<Integer>>((1 << (i - cnt + 1)) * (cnt + 1));
		res.addAll(tmp);
		for (int k = 1; k <= cnt; k++) {
			for (ArrayList<Integer> e : tmp) {
				ArrayList<Integer> ex = (ArrayList<Integer>) e.clone();
				for (int j = 0; j < k; j++) {
					ex.add(num[i]);
				}
				res.add(ex);
			}
		}

		return res;
	}
}
