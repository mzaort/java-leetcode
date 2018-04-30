package solution;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		int[] val = { 1, 2, 5, 3, 4, Integer.MAX_VALUE, 6 };
		TreeNode root = TreeNode.make(val);
		new FlattenBinaryTreeToLinkedList().flatten(root);
		while (root != null) {
			System.out.println(root.val);
			root = root.right;
		}
	}

	public void flatten(TreeNode node) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (node != null) {
			flatten(node, null);
		}
	}

	private void flatten(TreeNode node, TreeNode tail) {
		if (node.left == null) {
			if (node.right == null) {
				node.right = tail;
			} else {
				flatten(node.right, tail);
			}
		} else {
			if (node.right == null) {
				flatten(node.left, tail);
				node.right = node.left;
				node.left = null;
			} else {
				flatten(node.right, tail);
				flatten(node.left, node.right);
				node.right = node.left;
				node.left = null;
			}
		}
	}
}
