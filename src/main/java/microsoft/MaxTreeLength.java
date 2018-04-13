package microsoft;
public class MaxTreeLength{
	public int maxLength(TreeNode root){
		height(root);
		return max(root);
	}
	
	public int height(TreeNode root){
		if(root == null){
			return 0;
		}else{
			int left = height(root.left);
			int right = height(root.right);
			root.val = 1 + (left > right ? left : right);
			return root.val;
		}
	}

	public int max(TreeNode root){
		if(root == null) return 0;
		int left = max(root.left);
		int right = max(root.right);
		int mid = 0;
		if(root.left != null){
			mid += root.left.val + 1;
		}
		if(root.right != null){
			mid += root.right.val + 1;
		}
		int res = left;
		if(res < right) res = right;
		if(res < mid) res = mid;
		return res;
	}
	
	public int[] maxLength2(TreeNode root){
		int[] res = {-1, -1};
		if(root != null){
			int[] left = maxLength2(root.left);
			int[] right = maxLength2(root.right);
			res[0] = Math.max(left[0], right[0]) + 1;
			res[1] = left[0] + right[0] + 2;
			res[1] = Math.max(res[1], left[1]);
			res[1] = Math.max(res[1], right[1]);
		}
		return res;
	}
}