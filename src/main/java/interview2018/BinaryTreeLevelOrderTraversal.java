package interview2018;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root != null) {
			LinkedList<TreeNode> queue = new LinkedList<>();
			List<Integer> list = null;
			queue.offerLast(root);
			TreeNode front = root, rear = root, p = null;
			while (null != (p = queue.pollFirst())) {
				if (front == p) {
					list = new ArrayList<>();
				}
				list.add(p.val);
				if (p.left != null) queue.offerLast(p.left);
				if (p.right != null) queue.offerLast(p.right);
				if (rear == p) {
					res.add(list);
					front = queue.peekFirst();
					rear = queue.peekLast();
				}
			}
		}

		return res;
	}
}
