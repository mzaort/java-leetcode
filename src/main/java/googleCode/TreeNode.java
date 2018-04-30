package googleCode;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public static TreeNode create(int[] vals) {
		return create(vals, new int[] { 0 });
	}

	private static TreeNode create(int[] vals, int[] cur) {
		if (cur[0] >= vals.length) return null;
		if (vals[cur[0]] == '#') {
			cur[0]++;
			return null;
		} else {
			TreeNode res = new TreeNode(vals[cur[0]++]);
			res.left = create(vals, cur);
			res.right = create(vals, cur);
			return res;
		}
	}

	public static void main(String[] args) {
		TreeNode res = TreeNode.create(new int[] { 1, 2, 4, '#', '#', 5, '#', '#', 3, '#', '#' });
		System.out.println(res.val);
	}
}