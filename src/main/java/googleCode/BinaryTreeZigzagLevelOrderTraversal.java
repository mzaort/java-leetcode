package googleCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root != null) {
			List<TreeNode> list1 = new ArrayList<TreeNode>();
			List<TreeNode> list2 = new ArrayList<TreeNode>();
			list1.add(root);
			while (list1.size() != 0) {
				list2.clear();

				List<Integer> tmp = new ArrayList<Integer>();
				for (TreeNode e : list1) {
					tmp.add(e.val);
					if (e.left != null) list2.add(e.left);
					if (e.right != null) list2.add(e.right);
				}
				res.add(tmp);

				List<TreeNode> swap = list2;
				list2 = list1;
				list1 = swap;
			}
		}
		for (int i = 1; i < res.size(); i += 2) {
			Collections.reverse(res.get(i));
		}
		return res;
	}

	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root != null) {
			LinkedList<TreeNode> deque = new LinkedList<TreeNode>();
			deque.add(root);
			boolean flag = true;
			while (deque.size() != 0) {
				if (flag) {
					List<Integer> list = new ArrayList<Integer>();
					TreeNode end = deque.peekLast(), top = null;
					while (true) {
						top = deque.pollFirst();
						list.add(top.val);
						if (top.left != null) deque.addLast(top.left);
						if (top.right != null) deque.addLast(top.right);
						if (top == end) {
							res.add(list);
							flag = !flag;
							break;
						}
					}
				} else {
					List<Integer> list = new ArrayList<Integer>();
					TreeNode end = deque.peekFirst(), top = null;
					do {
						top = deque.pollLast();
						list.add(top.val);
						if (top.right != null) deque.addFirst(top.right);
						if (top.left != null) deque.addFirst(top.left);
					} while (top != end);
					res.add(list);
					flag = !flag;
				}
			}
		}
		return res;
	}
}
