package interview2018;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root != null) {
			LinkedList<TreeNode> stack = new LinkedList<>();
			stack.push(root);

			TreeNode top = null;
			while (null != (top = stack.poll())) {
				res.add(top.val);
				if (top.right != null) stack.push(top.right);
				if (top.left != null) stack.push(top.left);
			}
		}
		return res;
	}

	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		TreeNode p = root, q = null;
		while (p != null) {
			if (p.left == null) {
				res.add(p.val);
				p = p.right;
			} else {
				for (q = p.left; q.right != null && q.right != p; q = q.right);
				if (q.right == null) {
					q.right = p;
					res.add(p.val);
					p = p.left;
				} else if (q.right == p) {
					q.right = null;
					p = p.right;
				}
			}
		}
		return res;
	}

	public List<Integer> preorderTraversal3(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				res.add(p.val);
				if (p.right != null) stack.push(p.right);
				p = p.left;
			} else {
				p = stack.poll();
			}
		}
		return res;
	}
}
