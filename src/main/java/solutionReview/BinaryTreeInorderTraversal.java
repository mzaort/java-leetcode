package solutionReview;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		BinaryTreeInorderTraversal bt = new BinaryTreeInorderTraversal();
		TreeNode root = TreeNode.create(new int[] { 1, 2 });
		System.out.println(bt.inorderTraversal2(root));
	}

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root != null) {
			res.addAll(inorderTraversal(root.left));
			res.add(root.val);
			res.addAll(inorderTraversal(root.right));
		}
		return res;
	}

	public ArrayList<Integer> inorderTraversal2(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

		TreeNode tmp = null, p = root;
		while (p != null) {
			stack.push(p);
			p = p.left;
		}

		while ((tmp = stack.poll()) != null) {
			res.add(tmp.val);
			p = tmp.right;
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
		}

		return res;
	}
}
