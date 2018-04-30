package microsoft;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public int val;

	public TreeNode(int value) {
		this.val = value;
	}

	public TreeNode(int value, TreeNode left, TreeNode right) {
		this.val = value;
		this.left = left;
		this.right = right;
	}

	private static int cur = 0;

	public static TreeNode create(int[] arr) {
		cur = 0;
		return create1(arr);
	}

	private static TreeNode create1(int[] arr) {
		if (arr.length == cur) return null;
		if (arr[cur] == '#') {
			cur++;
			return null;
		} else {
			TreeNode res = new TreeNode(arr[cur++]);
			res.left = create1(arr);
			res.right = create1(arr);
			return res;
		}
	}
}