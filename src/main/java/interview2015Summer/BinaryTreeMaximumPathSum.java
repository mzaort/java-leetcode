package interview2015Summer;

import static java.lang.Math.max;

public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		return maxPathSum2(root)[1];
	}

	private int[] maxPathSum2(TreeNode root) {
		int[] res = { 0, 0 };
		if (root != null) {
			int[] left = maxPathSum2(root.left);
			int[] right = maxPathSum2(root.right);
			res[0] = max(0, max(left[0], right[0]) + root.val);
			res[1] = max(left[0] + right[0] + root.val, max(left[1], right[1]));
		}
		return res;
	}
}
