package microsoft;

import java.util.ArrayList;

public class SumNM {
	public static void main(String[] args) {
		SumNM snm = new SumNM();
		for (int i = 1; i < 10; i++) {
			System.out.println(snm.numOfNM(i, i));
			System.out.println(snm.listOfNM(i, i));
		}
	}

	public int numOfNM(int n, int m) {
		assert (n >= 1 && m >= 1);
		return numOfNM(n, m, n);
	}

	public int numOfNM(int n, int m, int k) {
		if (m == 0) return 1;
		if (k == 0) return 0;
		if (n > m) n = m;
		if (k > n) k = n;
		return numOfNM(n, m - k, k - 1) + numOfNM(n, m, k - 1);
	}

	public ArrayList<ArrayList<Integer>> listOfNM(int n, int m) {
		assert (n >= 1 && m >= 1);
		return listOfNM(n, m, n);
	}

	private ArrayList<ArrayList<Integer>> listOfNM(int n, int m, int k) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (m == 0) {
			res.add(null);
			return res;
		}
		if (k == 0) { return res; }
		if (n > m) n = m;
		if (k > n) k = n;
		res.addAll(listOfNM(n, m, k - 1));

		ArrayList<ArrayList<Integer>> tmp = listOfNM(n, m - k, k - 1);
		for (ArrayList<Integer> e : tmp) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			if (e != null) list.addAll(e);
			list.add(k);
			res.add(list);
		}
		return res;
	}
}