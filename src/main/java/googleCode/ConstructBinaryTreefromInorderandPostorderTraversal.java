package googleCode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

	private TreeNode buildTree(int[] inorder, int ifrm, int iend, int[] postorder, int pfrm, int pend) {
		if(ifrm > iend) return null;
		int cur = ifrm;
		for(; inorder[cur] != postorder[pend]; cur++);
		int split = cur - ifrm + pfrm - 1;
		TreeNode node = new TreeNode(postorder[pend]);
		node.left = buildTree(inorder, ifrm, cur - 1, postorder, pfrm, split);
		node.right = buildTree(inorder, cur + 1, iend, postorder, split + 1, pend - 1);
		return node;
	}
}
