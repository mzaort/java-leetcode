package solution;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (p == null) {
			if (q == null) {
				return true;
			} else {
				return false;
			}
		} else {
			if (q == null) {
				return false;
			} else {
				if ((p.val == q.val) && (isSameTree(p.left, q.left)) && isSameTree(p.right, q.right)) {
					return true;
				} else {
					return false;
				}
			}
		}
	}
}
