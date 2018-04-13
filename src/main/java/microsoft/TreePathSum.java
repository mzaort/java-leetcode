package microsoft;

import java.util.ArrayList;

public class TreePathSum {

	public static void main(String[] args) {
		TreeNode tn1 = new TreeNode(8);
		TreeNode tn2 = new TreeNode(7);
		TreeNode tn3 = new TreeNode(9);
		TreeNode tn4 = new TreeNode(5);
		TreeNode tn5 = new TreeNode(4);
		tn1.left = tn4;
		tn1.right = tn3;
		tn4.left = tn5;
		tn4.right = tn2;
		ArrayList<ArrayList<TreeNode>> res = new TreePathSum().pathSum(tn1, 17);
		for (ArrayList<TreeNode> e : res) {
			for (TreeNode t : e) {
				System.out.print(t.val + "\t");
			}
			System.out.println();
		}
	}

	public ArrayList<ArrayList<TreeNode>> pathSum(TreeNode root, int target) {
		ArrayList<ArrayList<TreeNode>> res = new ArrayList<ArrayList<TreeNode>>();
		if (root == null)
			return res;

		if (root.left == null && root.right == null) {
			if (root.val == target) {
				ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
				tmp.add(root);
				res.add(tmp);
			}
		} else {
			ArrayList<ArrayList<TreeNode>> left = pathSum(root.left, target
					- root.val);
			for (ArrayList<TreeNode> e : left) {
				ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
				tmp.add(root);
				tmp.addAll(e);
				res.add(tmp);
			}
			ArrayList<ArrayList<TreeNode>> right = pathSum(root.right, target
					- root.val);
			for (ArrayList<TreeNode> e : right) {
				ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
				tmp.add(root);
				tmp.addAll(e);
				res.add(tmp);
			}
		}
		return res;
	}
}