package googleCode;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
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
				return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
			}
		}
	}
	
	public boolean isSameTree2(TreeNode p, TreeNode q) {
		if(p != null && q != null) return p.val == q.val && isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
		return p == null && q == null;
	}
}
