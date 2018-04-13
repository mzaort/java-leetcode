package solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

	public static void main(String[] args) {
		Permutations p = new Permutations();
		p.permute(new int[] { 1, 2, 3 });
	}

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int len = num.length;
		if (len == 0) {
			res.add(new ArrayList<Integer>());
			return res;
		}

		int[] index = new int[len];
		for (int i = 0; i < len; i++) {
			index[i] = i;
		}

		while (true) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < len; i++) {
				list.add(num[index[i]]);
			}
			res.add(list);

			int dest = len - 2;
			for (; dest >= 0 && index[dest] > index[dest + 1]; dest--)
				;
			if (dest == -1) {
				break;
			} else {
				Arrays.sort(index, dest + 1, len);
				swap(index, dest,
						findInsertion(index, index[dest], dest + 1, len - 1));
			}
		}
		return res;
	}

	private void swap(int[] index, int dest, int src) {
		int tmp = index[dest];
		index[dest] = index[src];
		index[src] = tmp;
	}

	private int findInsertion(int[] index, int target, int i, int j) {
		while (i <= j) {
			int mid = (i + j) >>> 1;
			if (index[mid] > target) {
				j = mid - 1;
			} else if (index[mid] < target) {
				i = mid + 1;
			} else {
				return mid;
			}
		}
		return i;
	}
}
