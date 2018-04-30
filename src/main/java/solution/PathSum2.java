package solution;

import java.util.ArrayList;

public class PathSum2 {

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		pathSum(root, sum, list, res);
		return res;
	}

	private void pathSum(TreeNode root, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
		if (root != null) {
			list.add(root.val);
			if (root.left == null) {
				if (root.right == null) {
					if (sum == root.val) {
						res.add(list);
					}
				} else {
					pathSum(root.right, sum - root.val, list, res);
				}
			} else {
				if (root.right == null) {
					pathSum(root.left, sum - root.val, list, res);
				} else {
					ArrayList<Integer> list1 = new ArrayList<Integer>();
					ArrayList<Integer> list2 = new ArrayList<Integer>();
					for (Integer e : list) {
						list1.add(e);
						list2.add(e);
					}
					pathSum(root.left, sum - root.val, list1, res);
					pathSum(root.right, sum - root.val, list2, res);
				}
			}
		}
	}
}
