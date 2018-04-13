package solutionReview;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreePostorderTraversal {
	
	public static void main(String[] args) {
		BinaryTreePostorderTraversal bt = new BinaryTreePostorderTraversal();
		TreeNode root = TreeNode.create(new int[]{1, 2, 4, '#', '#', 5, 7, '#', '#', '#', 3, '#', 6});
		System.out.println(bt.postorderTraversal2(root));
	}
	
	public ArrayList<Integer> postorderTraversal(TreeNode root){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root != null){
			res.addAll(postorderTraversal(root.left));
			res.addAll(postorderTraversal(root.right));
			res.add(root.val);
		}
		return res;
	}
	
	public ArrayList<Integer> postorderTraversal2(TreeNode root){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		LinkedList<Boolean> tag = new LinkedList<Boolean>();
		
		TreeNode top = null, p = root;
		while(p != null){
			stack.push(p);
			tag.push(false);
			p = p.left;
		}
		
		while((top = stack.peek()) != null){
			if(tag.peek()){
				res.add(top.val);
				stack.pop();
				tag.pop();
			}else{
				tag.pop();
				tag.push(true);
				
				p = top.right;
				while(p != null){
					stack.push(p);
					tag.push(false);
					p = p.left;
				}			
			}
		}
		
		return res;
	}
}
