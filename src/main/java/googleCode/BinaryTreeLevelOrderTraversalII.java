package googleCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) return res;
		List<TreeNode> list1 = new ArrayList<TreeNode>();
		List<TreeNode> list2 = new ArrayList<TreeNode>();
		list1.add(root);
		while (list1.size() != 0) {
			list2.clear();

			List<Integer> tmp = new ArrayList<Integer>();
			for (TreeNode e : list1) {
				tmp.add(e.val);
				if (e.left != null) list2.add(e.left);
				if (e.right != null) list2.add(e.right);
			}
			res.add(tmp);

			List<TreeNode> swap = list2;
			list2 = list1;
			list1 = swap;
		}
		Collections.reverse(res);
		return res;
	}
}
