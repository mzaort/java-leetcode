package microsoft;

import java.util.ArrayList;

public class BinaryTreePostOrder {

	public static void main(String[] args) {
		BinaryTreePostOrder ptpo = new BinaryTreePostOrder();
		int[] arr = { 0, 2, 1, 4, 6, 9, 1, 10, 7 };
		System.out.println(ptpo.isBinarySearchTree(arr));
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(null);
		System.out.println(list.size());
	}

	public boolean isBinarySearchTree(int[] arr) {
		return isBinarySearchTree(arr, 0, arr.length - 1);
	}

	private boolean isBinarySearchTree(int[] arr, int frm, int end) {
		if (frm >= end) {
			return true;
		} else {
			int pivot = arr[end];
			int cur = frm;
			for (; arr[cur] < pivot; cur++)
				;
			if (cur == end) {
				return isBinarySearchTree(arr, frm, end - 1);
			} else {
				for (int i = cur; i < end; i++) {
					if (arr[i] <= pivot) {
						return false;
					}
				}
				return isBinarySearchTree(arr, frm, cur - 1)
						&& isBinarySearchTree(arr, cur, end - 1);
			}
		}
	}
}