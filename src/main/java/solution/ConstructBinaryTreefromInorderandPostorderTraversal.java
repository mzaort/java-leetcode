package solution;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (inorder.length == 0)
			return null;
		if (inorder.length != postorder.length)
			return null;
		TreeNode res = null;
		try {
			res = buildTree(inorder, 0, inorder.length - 1, postorder, 0,
					postorder.length - 1);
		} catch (Exception e) {
			res = null;
		}
		return res;
	}

	public TreeNode buildTree(int[] inorder, int ifrm, int iend,
			int[] postorder, int pfrm, int pend) throws Exception {
		TreeNode res = null;
		if (ifrm > iend) {
			res = null;
		} else if (ifrm == iend) {
			if (inorder[ifrm] != postorder[pfrm]) {
				throw new Exception();
			} else {
				res = new TreeNode(inorder[ifrm]);
				res.left = res.right = null;
			}
		} else {
			int split = ifrm;
			for (; split <= iend && postorder[pend] != inorder[split]; split++)
				;
			if (split > iend) {
				throw new Exception();
			} else {
				int split2 = pend - iend + split;
				res = new TreeNode(postorder[pend]);
				res.left = buildTree(inorder, ifrm, split - 1, postorder, pfrm,
						split2 - 1);
				res.right = buildTree(inorder, split + 1, iend, postorder,
						split2, pend - 1);
			}
		}
		return res;
	}
}
