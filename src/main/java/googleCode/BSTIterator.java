package googleCode;

import java.util.LinkedList;

public class BSTIterator {
	LinkedList<TreeNode> stack;
	public BSTIterator(TreeNode root) {
		stack = new LinkedList<>();
		for(TreeNode p = root; p != null; p = p.left) stack.push(p);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		assert(hasNext());
		TreeNode p = stack.poll();
		for(TreeNode q = p.right; q != null; q = q.left) stack.push(q);
		return p.val;
	}
}
