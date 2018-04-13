package googleCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		if(root != null){
			res.addAll(postorderTraversal(root.left));
			res.addAll(postorderTraversal(root.right));
			res.add(root.val);
		}
		return res;
	}
	
	public List<Integer> postorderTraversal2(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		LinkedList<Boolean> flag = new LinkedList<Boolean>();
		
		TreeNode p = root;
		while(p != null){
			stack.push(p);
			flag.push(false);
			p = p.left;
		}
		
		Boolean visit = null;
		while((visit = flag.poll()) != null){
			if(visit){
				res.add(stack.poll().val);
			}else{
				flag.push(true);
				p = stack.peek();
				p = p.right;
				while(p != null){
					stack.push(p);
					flag.push(false);
					p = p.left;
				}
			}
		}
		return res;
	}
}
