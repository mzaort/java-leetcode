package googleCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetsII {

	public static void main(String[] args) {
		System.out.println(new SubsetsII().subsetsWithDup(new int[] { 1, 2, 2 }));
	}

	public List<List<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);
		return subsetsWithDup(num, num.length);
	}

	private List<List<Integer>> subsetsWithDup(int[] num, int len) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (len == 0) {
			res.add(new ArrayList<Integer>());
		} else {
			int cur = len - 2;
			for (; cur >= 0 && num[cur] == num[len - 1]; cur--);
			int cnt = len - 1 - cur;
			List<List<Integer>> tmp = subsetsWithDup(num, cur + 1);
			for (List<Integer> e : tmp) {
				for (int i = 0; i <= cnt; i++) {
					List<Integer> list = new ArrayList<Integer>(e);
					for (int j = 0; j < i; j++)
						list.add(num[len - 1]);
					res.add(list);
				}
			}
		}
		return res;
	}

	public List<List<Integer>> subsetsWithDup2(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new ArrayList<>();
		subsetsWithDup2(res, new ArrayList<Integer>(), num, 0);
		return res;
	}

	private void subsetsWithDup2(List<List<Integer>> res, ArrayList<Integer> list, int[] num, int i) {
		if (i == num.length) res.add(new ArrayList<>(list));
		else {
			int j = i + 1;
			for (; j < num.length && num[j] == num[i]; j++);
			for (int k = 0; k <= j - i; k++) {
				list.addAll(Collections.nCopies(k, num[i]));
				subsetsWithDup2(res, list, num, j);
				list.subList(list.size() - k, list.size()).clear();
			}
		}
	}
}
