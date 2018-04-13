package solution;

public class BinaryTreeMaximumPathSum {
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node2.left = node3;
		node3.left = node4;
		node4.left = node5;
		new BinaryTreeMaximumPathSum().maxPathSum2(node1);
	}
	
	public int maxPathSum(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return 0;
		int res = maxPathRoot(root.left) + maxPathRoot(root.right) + root.val;
		if (root.left != null) {
			int left = maxPathSum(root.left);
			if (res < left)
				res = left;
		}
		if (root.right != null) {
			int right = maxPathSum(root.right);
			if (res < right)
				res = right;
		}
		return res;
	}

	private int maxPathRoot(TreeNode root) {
		if (root == null)
			return 0;
		int left = maxPathRoot(root.left);
		int right = maxPathRoot(root.right);
		int res = left;
		if (right > res)
			res = right;
		res = res <= 0 ? root.val : res + root.val;
		res = res > 0 ? res : 0;
		return res;
	}

	public int maxPathSum2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		maxSinglePath(root);
		return maxPathSum3(root);
	}

	private int maxPathSum3(TreeNode root) {
		if (root == null)
			return 0;
		int res = root.val;
		if (root.left != null && root.right != null) {
			if(root.left.val > 0 && root.right.val > 0){
				if(root.left.val > root.right.val){
					res += root.right.val;
				}else{
					res += root.left.val;
				}
			}
		}

		if (root.left != null) {
			int left = maxPathSum3(root.left);
			if (res < left)
				res = left;
		}
		if (root.right != null) {
			int right = maxPathSum3(root.right);
			if (res < right)
				res = right;
		}

		return res;
	}

	private void maxSinglePath(TreeNode root) {
		if (root != null) {
			maxSinglePath(root.left);
			maxSinglePath(root.right);
			int res = 0;
			if (root.left != null) {
				if (root.left.val > res)
					res = root.left.val;
			}
			if (root.right != null) {
				if (root.right.val > res)
					res = root.right.val;
			}
			if (res > 0) {
				root.val += res;
			}
		}
	}
}
