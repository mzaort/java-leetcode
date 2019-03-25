package interview2018;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode p = root;
		while (p != null) {
			stack.push(p);
			p = p.left;
		}
		while (null != (p = stack.poll())) {
			res.add(p.val);
			p = p.right;
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
		}
		return res;
	}

	public List<Integer> inorderTraversal2(TreeNode root) {
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
					p = p.left;
				} else if (q.right == p) {
					q.right = null;
					res.add(p.val);
					p = p.right;
				}
			}
		}

		return res;
	}

	public List<Integer> inorderTraversal3(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				p = stack.poll();
				res.add(p.val);
				p = p.right;
			}
		}
		return res;
	}

}
