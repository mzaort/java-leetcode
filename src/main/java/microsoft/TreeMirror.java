package microsoft;

import java.util.LinkedList;

public class TreeMirror {
	public TreeNode mirror(TreeNode root) {
		if (root == null) return null;
		TreeNode res = new TreeNode(root.val);
		res.left = mirror(root.right);
		res.right = mirror(root.left);
		return res;
	}

	public TreeNode mirror2(TreeNode root) {
		if (root == null) return null;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.addLast(root);

		TreeNode top = null;
		while ((top = queue.poll()) != null) {
			if (top.left != null) queue.addLast(top.left);
			if (top.right != null) queue.addLast(top.right);
			TreeNode tmp = top.left;
			top.left = top.right;
			top.right = tmp;
		}
		return root;
	}
}