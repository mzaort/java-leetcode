package googleCode;

import java.util.*;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root != null) {
			res.add(root.val);
			res.addAll(preorderTraversal(root.left));
			res.addAll(preorderTraversal(root.right));
		}
		return res;
	}

	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root != null) {
			LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
			stack.push(root);
			TreeNode p = null;
			while ((p = stack.poll()) != null) {
				res.add(p.val);
				if (p.right != null) stack.push(p.right);
				if (p.left != null) stack.push(p.left);
			}
		}
		return res;
	}

	public List<Integer> preorderTraversal3(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		preorderTraversal2(res, root);
		return res;
	}

	private void preorderTraversal2(List<Integer> res, TreeNode root) {
		if (root != null) {
			res.add(root.val);
			preorderTraversal2(res, root.left);
			preorderTraversal2(res, root.right);
		}
	}

	// Moist
	public List<Integer> preorderTraversal4(TreeNode root) {
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
					res.add(cur.val);
					// prev = cur;
					cur = cur.left;
				} else {
					cur = cur.right;
					p.right = null;
				}
			}
		}
		return res;
	}
}
