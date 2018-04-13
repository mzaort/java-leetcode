package solution;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		new BinaryTreeLevelOrderTraversal().levelOrder(root);
	}
	
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(root == null) return res;
    	
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	
    	TreeNode first = root, tmp, last = root;
    	ArrayList<Integer> list = null;
    	while((tmp = queue.pollFirst()) != null){
    		 if(tmp == first){
    			 list = new ArrayList<Integer>();
    		 }
    		 list.add(tmp.val);
    		 if(tmp.left != null){
    			 queue.addLast(tmp.left);
    		 }
    		 if(tmp.right != null){
    			 queue.addLast(tmp.right);
    		 }
    		 if(tmp == last){
    			 res.add(list);
    			 first = queue.peekFirst();
    			 last = queue.peekLast();
    		 }
    	}
    	return res;
    }
}
