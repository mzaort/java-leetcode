package interview2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode p = root;
		while (null != p || !stack.isEmpty()) {
			if (null != p) {
				res.add(p.val);
				if (null != p.left) stack.push(p.left);
				p = p.right;
			} else {
				p = stack.poll();
			}
		}
		Collections.reverse(res);
		return res;
	}
}
