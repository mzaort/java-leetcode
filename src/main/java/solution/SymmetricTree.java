package solution;

import java.util.LinkedList;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(root == null) return true;
    	return isSymmetric(root.left, root.right);
    }

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left == null){
			if(right == null){
				return true;
			}else{
				return false;
			}
		}else{
			if(right == null){
				return false;
			}else{
				return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
			}
		}
	}
	
	public boolean isSymmetric2(TreeNode root) {
    	if(root == null) return true;
    	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    	stack.push(root.left);
    	stack.push(root.right);
    	while(stack.size() > 0){
    		TreeNode t1 = stack.poll();
    		TreeNode t2 = stack.poll();    		
    		if(t1 == null){
    			if(t2 != null){
    				return false;
    			}
    		}else{
    			if(t2 == null){
    				return false;
    			}else{
    				if(t1.val == t2.val){
    					stack.push(t1.left);
    					stack.push(t2.right);
    					stack.push(t1.right);
    					stack.push(t2.left);
    				}else{
    					return false;
    				}
    			}
    		}
    	}
    	return true;
    }
}
