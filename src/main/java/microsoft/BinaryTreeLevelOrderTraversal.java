package microsoft;

import java.util.*;

public class BinaryTreeLevelOrderTraversal{
	public ArrayList<ArrayList<TreeNode>> levelOrder(TreeNode root){
		ArrayList<ArrayList<TreeNode>> res = new ArrayList<ArrayList<TreeNode>>();
		if(root == null) return res;

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.addLast(root);

		TreeNode tmp, first, last;
		first = last = root;

		ArrayList<TreeNode> list = null;
		while((tmp = queue.pollFirst()) != null){
			if(tmp == first){
				list = new ArrayList<TreeNode>();
			}
			list.add(tmp);

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