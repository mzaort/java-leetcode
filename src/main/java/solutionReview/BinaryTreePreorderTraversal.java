package solutionReview;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreePreorderTraversal {
	public static void main(String[] args) {
		BinaryTreePreorderTraversal bt = new BinaryTreePreorderTraversal();
		TreeNode root = TreeNode.create(new int[]{1, 2, 4, '#', '#', 5, 7, '#', '#', '#', 3, '#', 6});
		System.out.println(bt.preorderTraversal2(root));
	}
	
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root != null){
			res.add(root.val);
			res.addAll(preorderTraversal(root.left));
			res.addAll(preorderTraversal(root.right));
		}
		return res;
	}
	
	public ArrayList<Integer> preorderTraversal2(TreeNode root){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		
		TreeNode top = null;
		while((top = stack.poll()) != null){
			res.add(top.val);
			if(top.right != null) stack.push(top.right);
			if(top.left != null) stack.push(top.left);
		}	
		
		return res;
	}
}
