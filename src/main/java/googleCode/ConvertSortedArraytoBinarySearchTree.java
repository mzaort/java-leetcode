package googleCode;

public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBST(num, 0, num.length - 1);
	}

	private TreeNode sortedArrayToBST(int[] num, int i, int j) {
		if (i > j) return null;
		int mid = i + ((j - i) >>> 1);
		TreeNode node = new TreeNode(num[mid]);
		node.left = sortedArrayToBST(num, i, mid - 1);
		node.right = sortedArrayToBST(num, mid + 1, j);
		return node;
	}
}
