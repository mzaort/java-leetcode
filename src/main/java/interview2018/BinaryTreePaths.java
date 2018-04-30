package interview2018;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreePaths {

	public List<String> binaryTreePaths2(TreeNode root) {
		List<String> result = new ArrayList<>();
		if (root != null) dfs(result, String.valueOf(root.val), root);
		return result;
	}

	private void dfs(List<String> result, String list, TreeNode root) {
		if (root.left == null && root.right == null) result.add(list);
		else {
			if (root.left != null) dfs(result, list + "->" + root.left.val, root.left);
			if (root.right != null) dfs(result, list + "->" + root.right.val, root.right);
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		dfs(result, new ArrayList<Integer>(), root);
		return result;
	}

	private void dfs(List<String> result, List<Integer> list, TreeNode root) {
		if (root == null) return;
		else if (root.left == null && root.right == null) {
			list.add(root.val);
			result.add(list.stream().map(String::valueOf).collect(Collectors.joining("->")));
			list.remove(list.size() - 1);
		} else {
			if (root.left != null) {
				list.add(root.val);
				dfs(result, list, root.left);
				list.remove(list.size() - 1);
			}
			if (root.right != null) {
				list.add(root.val);
				dfs(result, list, root.right);
				list.remove(list.size() - 1);
			}
		}
	}
}
