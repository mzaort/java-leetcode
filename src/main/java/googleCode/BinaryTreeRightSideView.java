package googleCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root != null) {
			LinkedList<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			TreeNode front = null, last = queue.peekLast();
			while (null != (front = queue.poll())) {
				if (front.left != null) queue.offer(front.left);
				if (front.right != null) queue.offer(front.right);
				if (front == last) {
					res.add(front.val);
					last = queue.peekLast();
				}
			}
		}
		return res;
	}

	public List<Integer> rightSideView2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root != null) {
			List<Integer> left = rightSideView2(root.left);
			List<Integer> right = rightSideView2(root.right);
			res.add(root.val);
			res.addAll(right);
			if (right.size() < left.size()) res.addAll(left.subList(right.size(), left.size()));
		}
		return res;
	}
}
