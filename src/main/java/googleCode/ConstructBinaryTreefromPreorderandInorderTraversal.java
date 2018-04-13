package googleCode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

	private TreeNode buildTree(int[] preorder, int pi, int pj, int[] inorder,
			int ii, int ij) {
		if(pi > pj) return null;
		int cur = ii;
		for(; inorder[cur] != preorder[pi]; cur++);
		int split = cur - ii + pi;
		TreeNode node = new TreeNode(preorder[pi]);
		node.left = buildTree(preorder, pi + 1, split, inorder, ii, cur - 1);
		node.right = buildTree(preorder, split + 1, pj, inorder, cur + 1, ij);		
		return node;
	}
}
