package googleCode;

public class BinaryTreeMaximumPathSum {
	// assuming a path may contain zero node;
	public int maxPathSum(TreeNode root) {
		return maxPathAndSum(root)[0];
	}

	private int[] maxPathAndSum(TreeNode root) {
		int[] res = { 0, 0 };
		if (root != null) {
			int[] left = maxPathAndSum(root.left);
			int[] right = maxPathAndSum(root.right);
			res[0] = left[1] + left[1] + root.val;
			if (res[0] < left[0]) res[0] = left[0];
			if (res[0] < right[0]) res[0] = right[0];
			int val = root.val + (left[1] > right[1] ? left[1] : right[1]);
			if (res[1] < val) res[1] = val;
		}
		return res;
	}

	public int maxPathSum2(TreeNode root) {
		assert (root != null);
		return maxPathAndSum2(root)[0];
	}

	private int[] maxPathAndSum2(TreeNode root) {
		int[] res = new int[2];
		if (root.left == null) {
			if (root.right == null) {
				res[0] = res[1] = root.val;
			} else {
				int[] right = maxPathAndSum2(root.right);
				int val = root.val + (right[1] > 0 ? right[1] : 0);
				res[0] = val > right[0] ? val : right[0];
				res[1] = val;
			}
		} else {
			if (root.right == null) {
				int[] left = maxPathAndSum2(root.left);
				int val = root.val + (left[1] > 0 ? left[1] : 0);
				res[0] = val > left[0] ? val : left[0];
				res[1] = val;
			} else {
				int[] left = maxPathAndSum2(root.left);
				int[] right = maxPathAndSum2(root.right);
				int val = root.val + (left[1] > 0 ? left[1] : 0) + (right[1] > 0 ? right[1] : 0);
				if (val < left[0]) val = left[0];
				if (val < right[0]) val = right[0];
				res[0] = val;
				int max = left[1] > right[1] ? left[1] : right[1];
				res[1] = root.val + (max > 0 ? max : 0);
			}
		}
		return res;
	}
}
