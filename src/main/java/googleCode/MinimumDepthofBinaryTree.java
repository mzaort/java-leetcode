package googleCode;

public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return 1;
		int min = Integer.MAX_VALUE;
		if (root.left != null) min = Math.min(min, minDepth(root.left) + 1);
		if (root.right != null) min = Math.min(min, minDepth(root.right) + 1);
		return min;
	}
}
