package interview2018;

public class ValidateBinarySearchTree {
	static TreeNode pre = null;

	public boolean isValidBST(TreeNode root) {
		pre = null;
		return isValidBST1(root);
	}

	private boolean isValidBST1(TreeNode root) {
		if (root != null) {
			if (!isValidBST1(root.left)) return false;
			if (pre != null && pre.val >= root.val) return false;
			pre = root;
			if (!isValidBST1(root.right)) return false;
		}
		return true;
	}
}
