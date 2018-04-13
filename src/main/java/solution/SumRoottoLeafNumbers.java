package solution;

import java.util.LinkedList;

public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(root == null) return 0;
    	int res = 0;
    	
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);

    	TreeNode tmp;
    	while((tmp = queue.pollFirst()) != null){
    		if(tmp.left == null){
    			if(tmp.right == null){
    				res += tmp.val;
    			}else{
    				tmp.right.val += tmp.val * 10;
    				queue.add(tmp.right);
    			}
    		}else{
    			if(tmp.right == null){
    				tmp.left.val += tmp.val * 10;
    				queue.add(tmp.left);
    			}else{
    				tmp.left.val += tmp.val * 10;
    				tmp.right.val += tmp.val * 10;
    				queue.add(tmp.left);
    				queue.add(tmp.right);
    			}
    		}
    	}
        return res;
    }
}
