package googleCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root != null) {
			res.addAll(inorderTraversal(root.left));
			res.add(root.val);
			res.addAll(inorderTraversal(root.right));
		}
		return res;
	}

	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}

		TreeNode p = null;
		while ((p = stack.poll()) != null) {
			res.add(p.val);
			p = p.right;
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
		}
		return res;
	}

	public List<Integer> inorderTraversal3(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		TreeNode cur = root;// , prev;
		while (cur != null) {
			if (cur.left == null) {
				res.add(cur.val);
				// prev = cur;
				cur = cur.right;
			} else {
				TreeNode p = cur.left;
				while (p.right != null && p.right != cur)
					p = p.right;
				if (p.right == null) {
					p.right = cur;
					cur = cur.left;
				} else {
					res.add(cur.val);
					p.right = null;
					// prev = cur;
					cur = cur.right;
				}
			}
		}
		return res;
	}
}
