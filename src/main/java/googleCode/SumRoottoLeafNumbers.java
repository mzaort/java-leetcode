package googleCode;

public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

	private int sumNumbers(TreeNode node, int val) {
		if(node == null) return 0;
		val = val * 10 + node.val;
		return (node.left == null && node.right == null) ? val : sumNumbers(node.left, val) + sumNumbers(node.right, val);
	}
}
