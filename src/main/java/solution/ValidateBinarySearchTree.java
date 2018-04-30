package solution;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode node, int min, int max) {
		if (node == null) return true;
		return node.val > min && node.val < max && isValidBST(node.left, min, node.val)
				&& isValidBST(node.right, node.val, max);
	}
}
