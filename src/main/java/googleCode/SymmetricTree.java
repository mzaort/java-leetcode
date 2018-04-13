package googleCode;

import java.util.LinkedList;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
    	return root == null || isSymmetric(root.left, root.right);
    }

	private boolean isSymmetric(TreeNode t1, TreeNode t2) {
		if(t1 == null){
			if(t2 == null){
				return true;
			}else{
				return false;
			}
		}else{
			if(t2 == null){
				return false;
			}else{
				return t1.val == t2.val && isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
			}
		}
	}
	
	public boolean isSymmetric2(TreeNode root) {
    	return root == null || isSymmetric2(root.left, root.right);
    }
	
	private boolean isSymmetric2(TreeNode t1, TreeNode t2) {
		return (t1 != null && t2 != null) ? (t1.val == t2.val && isSymmetric2(t1.left, t2.right) && isSymmetric2(t1.right, t2.left)) : (t1 == null && t2 == null);
	}
	
	public boolean isSymmetric3(TreeNode root) {
		if(root == null) return true;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root.left);
		stack.push(root.right);
		while(!stack.isEmpty()){
			TreeNode t1 = stack.poll();
			TreeNode t2 = stack.poll();
			if(t1 == null && t2 == null) continue;
			if(t1 == null || t2 == null) return false;
			if(t1.val != t2.val) return false;
			stack.push(t1.left);
			stack.push(t2.right);
			stack.push(t1.right);
			stack.push(t2.left);
		}
		return true;
    }
	
}
