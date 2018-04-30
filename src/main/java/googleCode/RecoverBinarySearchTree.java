package googleCode;

public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		TreeNode[] two = new TreeNode[2];
		inOrderTraverse(root, two, new TreeNode[1]);
		if (two[0] != null && two[1] != null) {
			int val = two[0].val;
			two[0].val = two[1].val;
			two[1].val = val;
		}
	}

	private void inOrderTraverse(TreeNode root, TreeNode[] two, TreeNode[] prev) {
		if (root != null) {
			inOrderTraverse(root.left, two, prev);
			if (prev[0] != null) {
				if (prev[0].val > root.val) {
					if (two[0] == null) {
						two[0] = prev[0];
						two[1] = root;
					} else {
						two[1] = root;
					}
				}
			}
			prev[0] = root;
			inOrderTraverse(root.right, two, prev);
		}
	}
}
