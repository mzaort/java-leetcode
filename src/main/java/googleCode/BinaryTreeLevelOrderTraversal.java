package googleCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(root != null){
    		List<TreeNode> list1 = new ArrayList<TreeNode>(); 
    		List<TreeNode> list2 = new ArrayList<TreeNode>();
    		list1.add(root);
    		while(list1.size() != 0){
    			list2.clear();
    			
    			List<Integer> tmp = new ArrayList<Integer>();
    			for(TreeNode e : list1){
    				tmp.add(e.val);
    				if(e.left != null) list2.add(e.left);
    				if(e.right != null) list2.add(e.right);
    			}
    			res.add(tmp);
    			
    			List<TreeNode> swap = list2;
    			list2 = list1;
    			list1 = swap;
    		}
    	}
    	return res;
    }
    
    public List<List<Integer>> levelOrder2(TreeNode root){
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(root != null){
    		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    		queue.add(root);
    		TreeNode start = queue.peekFirst(), end = queue.peekLast(), top = null;
    		List<Integer> list = null;
    		while((top = queue.poll()) != null){
    			if(top == start){
    				list = new ArrayList<Integer>();
    			}
    			list.add(top.val);
    			if(top.left != null) queue.add(top.left);
    			if(top.right != null) queue.add(top.right);
    			if(top == end){
    				res.add(list);
    				start = queue.peekFirst();
    				end = queue.peekLast();
    			}
    		}
    	}
    	return res;
    }
}
