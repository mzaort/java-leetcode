package googleCode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return isBalancedAndHeight(root)[0] == 1;
    }

	private int[] isBalancedAndHeight(TreeNode root) {
		int[] res = {1, 0};
		if(root != null){
			int[] left = isBalancedAndHeight(root.left);
			int[] right = isBalancedAndHeight(root.right);
			res[0] = (left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1) ? 1 : 0;
			res[1] = Math.max(left[1], right[1]) + 1;
		}
		return res;
	}
	
	public boolean isBalanced2(TreeNode root) {
        return isBalanced2(root, new int[1]);
    }

	private boolean isBalanced2(TreeNode root, int[] height) {
		if(root == null){
			height[0] = 0;
			return true;
		}else{
			int[] left = new int[1], right = new int[1];
			if(isBalanced2(root.left, left) && isBalanced2(root.right, right) && Math.abs(left[0] - right[0]) <= 1){
				height[0] = Math.max(left[0], right[0]) + 1;
				return true;
			}
			return false;
		}
	}
}
