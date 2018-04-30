package googleCode;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
		if (root == null) return true;
		return root.val > minValue && root.val < maxValue && isValidBST(root.left, minValue, root.val)
				&& isValidBST(root.right, root.val, maxValue);
	}
}
