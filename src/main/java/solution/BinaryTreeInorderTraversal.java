package solution;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root != null){
        	res.addAll(inorderTraversal(root.left));
        	res.add(root.val);
        	res.addAll(inorderTraversal(root.right));
        }
        return res;
    }
    
    public ArrayList<Integer> inorderTraversal2(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode p = root, top = null;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while(p != null){
        	stack.push(p);
        	p = p.left;
        }
        
        while((top = stack.poll()) != null){
        	res.add(top.val);
        	p = top.right;
        	while(p != null){
        		stack.push(p);
        		p = p.left;
        	}
        }
        
        return res;
    }
    
}
