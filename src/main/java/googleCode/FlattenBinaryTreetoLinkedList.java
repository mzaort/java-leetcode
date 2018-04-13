package googleCode;

import java.util.LinkedList;

public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if(root != null){
        	flatten(root.left);
        	flatten(root.right);
        	if(root.left != null){
        		TreeNode p = root.left;
        		while(p.right != null) p = p.right;
        		p.right = root.right;
        		root.right = root.left;
        		root.left = null;
        	}
        }
    }
    
    public void flatten3(TreeNode root){
    	flatten3(root, null);
    }
    
    
    private void flatten3(TreeNode root, TreeNode node) {
    	if(root == null) return;
    	flatten3(root.left, root.right == null ? node: root.right);
    	flatten3(root.right, node);
    	if(root.left == null){
    		if(root.right == null) root.right = node;
		} else {
			root.right = root.left;
			root.left = null;
		}
	}

	public void flatten2(TreeNode root) {
    	if(root == null) return;
    	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    	stack.push(root);
    	TreeNode top = null;
    	while((top = stack.poll()) != null){
    		if(top.right != null) stack.push(top.right);
    		if(top.left != null) stack.push(top.left);
    		top.right = stack.peek();
    		top.left = null;
    	}
    }
}
