package solution;

import java.util.ArrayList;

public class UniqueBinarySearchTreesII2 {
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
		} else {
			for (int i = frm; i <= end; i++) {
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
			return res;
		}
	}

	public ArrayList<TreeNode> generateTrees2(int n) {
		assert (n >= 0);
		return generatedTrees2(1, n);
	}

	private ArrayList<TreeNode> generatedTrees2(int frm, int end) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if (frm > end) {
			res.add(null);
		} else {
			for (int i = frm; i <= end; i++) {
				ArrayList<TreeNode> left = generatedTrees2(frm, i - 1);
				ArrayList<TreeNode> right = generatedTrees2(i + 1, end);
				for (TreeNode el : left) {
					for (TreeNode er : right) {
						TreeNode root = new TreeNode(i);
						root.left = el;
						root.right = er;
						res.add(root);
					}
				}
			}
		}
		return res;
	}
}