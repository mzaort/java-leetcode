package googleCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		while (true) {
			List<Integer> list = new ArrayList<Integer>();
			for (int e : num)
				list.add(e);
			res.add(list);
			int i = num.length - 2;
			for (; i >= 0 && num[i] >= num[i + 1]; i--);
			if (i == -1) return res;
			for (int j = i + 1, k = num.length - 1; j < k; j++, k--)
				swap(num, j, k);
			swap(num, i, insertRight(num, i + 1, num.length - 1, num[i]));
		}
	}

	private int insertRight(int[] A, int i, int j, int target) {
		while (i <= j) {
			int mid = i + ((j - i) >>> 1);
			if (A[mid] <= target) i = mid + 1;
			else j = mid - 1;
		}
		return i;
	}

	public List<List<Integer>> permuteUnique2(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		permuteUnique2(res, num, 0);
		return res;
	}

	private void permuteUnique2(List<List<Integer>> res, int[] num, int cur) {
		if (cur >= num.length - 1) {
			List<Integer> list = new ArrayList<Integer>();
			for (int e : num)
				list.add(e);
			res.add(list);
		} else {
			Set<Integer> set = new HashSet<Integer>();
			for (int i = cur; i < num.length; i++) {
				if (!set.contains(num[i])) {
					set.add(num[i]);
					swap(num, cur, i);
					permuteUnique2(res, num, cur + 1);
					swap(num, cur, i);
				}
			}
		}
	}

	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
