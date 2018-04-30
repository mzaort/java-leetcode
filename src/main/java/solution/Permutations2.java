package solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations2 {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int len = num.length;
		if (len == 0) return res;

		int[] start = new int[len];
		for (int i = 0; i < len; i++) {
			start[i] = num[i];
		}
		while (true) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < len; i++) {
				list.add(num[i]);
			}
			res.add(list);
			nextPermutation(num);
			if (isSame(num, start)) {
				break;
			}
		}
		return res;
	}

	private boolean isSame(int[] num, int[] start) {
		for (int i = 0; i < num.length; i++) {
			if (num[i] != start[i]) return false;
		}
		return true;
	}

	public void nextPermutation(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = num.length;
		if (len != 0) {
			int dest = len - 2;
			for (; dest >= 0 && num[dest] >= num[dest + 1]; dest--);
			if (dest == -1) {
				Arrays.sort(num);
			} else {
				Arrays.sort(num, dest + 1, len);
				int i;
				for (i = dest + 1; i < len && num[i] <= num[dest]; i++);
				swap(num, dest, i);
			}
		}
	}

	private void swap(int[] index, int dest, int src) {
		int tmp = index[dest];
		index[dest] = index[src];
		index[src] = tmp;
	}
}
