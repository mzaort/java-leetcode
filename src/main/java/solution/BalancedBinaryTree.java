package solution;

public class BalancedBinaryTree {
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(2);
		TreeNode node7 = new TreeNode(3);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node4.left = node6;
		node4.right = node7;
		System.out.println(new BalancedBinaryTree().isBalanced2(node1));
	}
	
	public boolean isBalanced(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] depth = new int[2];
		return isBalanced(root, depth);
	}

	private boolean isBalanced(TreeNode node, int[] depth) {
		if (node == null) {
			depth[0] = depth[1] = 0;
			return true;
		}

		int[] leftDepth = new int[2];
		if (!isBalanced(node.left, leftDepth))
			return false;

		int[] rightDepth = new int[2];
		if (!isBalanced(node.right, rightDepth))
			return false;

		depth[0] = leftDepth[0] > leftDepth[1] ? leftDepth[0] + 1
				: leftDepth[1] + 1;
		depth[1] = rightDepth[0] > rightDepth[1] ? rightDepth[0] + 1
				: rightDepth[1] + 1;

		int judge = depth[0] - depth[1];
		return judge >= -1 && judge <= 1;
	}

	public boolean isBalanced2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		depthNode(root);
		return isBalanced3(root);
	}

	private void depthNode(TreeNode node) {
		if (node != null) {
			depthNode(node.left);
			depthNode(node.right);
			int max = 0;
			if (node.left != null) {
				if(max < node.left.val)
					max = node.left.val;
			}
			if (node.right != null) {
				if (max < node.right.val)
					max = node.right.val;
			}
			node.val = max + 1;
		}
	}

	private boolean isBalanced3(TreeNode node) {
		if (node == null)
			return true;
		if (node.left == null) {
			if (node.right == null) {
				return true;
			} else {
				return node.right.val == 1;
			}
		} else {
			if (node.right == null) {
				return node.left.val == 1;
			} else {
				int diff = node.left.val - node.right.val;
				return (diff >= -1 && diff <= 1) && isBalanced3(node.left) && isBalanced3(node.right);
			}
		}
	}
	
}
