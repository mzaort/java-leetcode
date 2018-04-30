package microsoft;

public class TreeMaxDistance {

	public static void main(String[] args) {
		TreeNode tn1 = new TreeNode(8);
		TreeNode tn2 = new TreeNode(7);
		TreeNode tn3 = new TreeNode(9);
		TreeNode tn4 = new TreeNode(5);
		TreeNode tn5 = new TreeNode(4);
		TreeNode tn6 = new TreeNode(4);
		TreeNode tn7 = new TreeNode(4);
		TreeNode tn8 = new TreeNode(4);
		tn1.left = tn4;
		tn1.right = tn3;
		tn4.left = tn5;
		tn4.right = tn2;
		tn2.right = tn6;
		tn6.right = tn7;
		tn7.right = tn8;

		TreeMaxDistance tmd = new TreeMaxDistance();
		System.out.println(tmd.max(tn1));
	}

	public int max(TreeNode root) {
		int[] res = maxDistance(root);
		return res[0];
	}

	public int[] maxDistance(TreeNode root) {
		int[] res = new int[] { -1, -1 };
		if (root == null) return res;

		if (root.left == null && root.right == null) {
			res[0] = res[1] = 0;
			return res;
		} else {
			int[] left = maxDistance(root.left);
			int[] right = maxDistance(root.right);
			res[1] = left[1] > right[1] ? left[1] + 1 : right[1] + 1;

			int max = left[1] + right[1] + 2;
			if (left[0] > max) max = left[0];
			if (right[0] > max) max = right[0];
			res[0] = max;
			return res;
		}
	}

}