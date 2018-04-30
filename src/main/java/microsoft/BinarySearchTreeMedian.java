package microsoft;

public class BinarySearchTreeMedian {

	public static void main(String[] args) {
		// 8, 6, 5, '#', '#', 7, '#', '#', 10, 9, '#', '#', 110
		TreeNode root = TreeNode.create(new int[] { 8 });
		BinarySearchTreeMedian bst = new BinarySearchTreeMedian();
		TreeNode res = bst.median(root);
		if (res != null) System.out.println(res.val);
	}

	public TreeNode median(TreeNode root) {
		if (root == null) return null;

		TreeNode p = root, parent = null, q;
		while (p.left != null)
			p = p.left;
		int min = p.val;

		p = root;
		while (p.right != null)
			p = p.right;
		int max = p.val;

		int median = (min + max) / 2;

		p = root;
		while (p != null) {
			if (p.val == median) {
				if (p.right == null) {
					break;
				} else {
					q = p.right;
					while (q.left != null)
						q = q.left;
					return q;
				}
			} else if (p.val < median) {
				p = p.right;
			} else {
				parent = p;
				p = p.left;
			}
		}
		return parent;
	}
}