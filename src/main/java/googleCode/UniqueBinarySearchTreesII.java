package googleCode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		assert (n >= 0);
		return generateTrees(1, n);
	}

	private List<TreeNode> generateTrees(int i, int j) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (i > j) {
			res.add(null);
		} else {
			for (int head = i; head <= j; head++) {
				List<TreeNode> left = generateTrees(i, head - 1);
				List<TreeNode> right = generateTrees(head + 1, j);
				for (TreeNode e1 : left) {
					for (TreeNode e2 : right) {
						TreeNode root = new TreeNode(head);
						root.left = clone(e1);
						root.right = clone(e2);
						res.add(root);
					}
				}
			}
		}
		return res;
	}

	private TreeNode clone(TreeNode node) {
		if (node == null) return node;
		TreeNode res = new TreeNode(node.val);
		res.left = clone(node.left);
		res.right = clone(node.right);
		return res;
	}
}
