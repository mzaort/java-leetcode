package solution;

import java.util.ArrayList;

public class UniqueBinarySearchTreesII {
	public ArrayList<TreeNode> generateTrees(int n) {
		if (n < 0) return null;

		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = i + 1;
		}

		return generateTrees(num, 0, n - 1);
	}

	public ArrayList<TreeNode> generateTrees(int[] num, int frm, int end) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if (frm > end) {
			res.add(null);
			return res;
		} else if (frm == end) {
			TreeNode tmp = new TreeNode(num[frm]);
			tmp.left = null;
			tmp.right = null;
			res.add(tmp);
			return res;
		} else {
			ArrayList<TreeNode> list = generateTrees(num, frm + 1, end);
			for (TreeNode e : list) {
				TreeNode tmp = new TreeNode(num[frm]);
				tmp.left = null;
				tmp.right = e;
				res.add(tmp);
			}

			for (int i = frm + 1; i < end; i++) {
				ArrayList<TreeNode> left = generateTrees(num, frm, i - 1);
				ArrayList<TreeNode> right = generateTrees(num, i + 1, end);
				for (TreeNode e : left) {
					for (TreeNode t : right) {
						TreeNode tmp = new TreeNode(num[i]);
						tmp.left = e;
						tmp.right = t;
						res.add(tmp);
					}
				}
			}

			list = generateTrees(num, frm, end - 1);
			for (TreeNode e : list) {
				TreeNode tmp = new TreeNode(num[end]);
				tmp.left = e;
				tmp.right = null;
				res.add(tmp);
			}

			return res;
		}
	}
}