package solution;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (preorder.length == 0) return null;
		if (preorder.length != inorder.length) return null;
		TreeNode res = null;
		try {
			res = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
		} catch (Exception e) {
			res = null;
		}
		return res;
	}

	private TreeNode buildTree(int[] preorder, int pfrm, int pend, int[] inorder, int ifrm, int iend) throws Exception {
		TreeNode res = null;
		if (ifrm > iend) {
			res = null;
		} else if (pfrm == pend) {
			if (preorder[pfrm] != inorder[ifrm]) {
				throw new Exception();
			} else {
				res = new TreeNode(preorder[pfrm]);
				res.left = res.right = null;
			}
		} else {
			res = new TreeNode(preorder[pfrm]);
			int split = ifrm;
			for (; split <= iend && preorder[pfrm] != inorder[split]; split++);
			if (split > iend) {
				throw new Exception();
			} else {
				int split2 = split - ifrm + pfrm;
				res.left = buildTree(preorder, pfrm + 1, split2, inorder, ifrm, split - 1);
				res.right = buildTree(preorder, split2 + 1, pend, inorder, split + 1, iend);
			}
		}
		return res;
	}
}
