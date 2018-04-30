package microsoft;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4 };
		int[] arr2 = { 2, 2, 3, 3, 4, 4 };
		Permutation p = new Permutation();
		System.out.println(p.permutate(arr));
		System.out.println(p.permutate(new int[] {}));
		ArrayList<ArrayList<Integer>> res = p.permutateUnique(arr2);
		System.out.println(res.size());
	}

	public ArrayList<ArrayList<Integer>> permutate(int[] arr) {
		return permutate(arr, 0, arr.length - 1);
	}

	public ArrayList<ArrayList<Integer>> permutate(int[] arr, int frm, int end) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (frm > end) {
			res.add(new ArrayList<Integer>());
			return res;
		} else if (frm == end) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int e : arr) {
				list.add(e);
			}
			res.add(list);
			return res;
		} else {
			for (int i = frm; i <= end; i++) {
				swap(arr, frm, i);
				ArrayList<ArrayList<Integer>> tmp = permutate(arr, frm + 1, end);
				res.addAll(tmp);
				swap(arr, i, frm);
			}
			return res;
		}
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public ArrayList<ArrayList<Integer>> permutateUnique(int[] num) {
		Arrays.sort(num);
		return permutateUnique(num, 0, num.length - 1);
	}

	private ArrayList<ArrayList<Integer>> permutateUnique(int[] num, int frm, int end) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (frm > end) {
			return res;
		} else if (frm == end) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int e : num) {
				list.add(e);
			}
			res.add(list);
			return res;
		} else {
			res.addAll(permutateUnique(num, frm + 1, end));
			for (int i = frm + 1; i <= end; i++) {
				if (num[i] != num[i - 1]) {
					swap(num, i, frm);
					res.addAll(permutateUnique(num, frm + 1, end));
					swap(num, i, frm);
				}
			}
			return res;
		}
	}
}