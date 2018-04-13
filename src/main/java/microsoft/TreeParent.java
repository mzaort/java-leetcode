package microsoft;
public class TreeParent{
	
	public static void main(String[] args) {
		TreeNode tn1 = new TreeNode(8);
		TreeNode tn2 = new TreeNode(7);
		TreeNode tn3 = new TreeNode(9);
		TreeNode tn4 = new TreeNode(5);
		TreeNode tn5 = new TreeNode(4);
		TreeNode tn6 = new TreeNode(1);
		TreeNode tn7 = new TreeNode(2);
		TreeNode tn8 = new TreeNode(3);
		tn1.left = tn4;
		tn1.right = tn3;
		tn4.left = tn5;
		tn4.right = tn2;
		tn2.right = tn6;
		tn6.right = tn7;
		tn7.right = tn8;
		TreeNode tn9 = new TreeNode(3);
		TreeNode tn0 = new TreeNode(3);
		TreeParent tp = new TreeParent();
		System.out.println(tp.commonParent(tn1, tn0, tn1).val);
	}
	
	/**
	 * 当root树包含s和t时，返回的是它们最近公共父节点。
	 * 当只包含一个结点时，返回的是这个结点。
	 * 当都不包含时，返回null。
	 */
	public TreeNode commonParent(TreeNode root, TreeNode s, TreeNode t){
		if(root == null) return null;
		if(root == s || root == t) return root;
		TreeNode left = commonParent(root.left, s, t);
		TreeNode right = commonParent(root.right, s, t);
		if(left == null){
			return right;
		}else if(right == null){
			return left;
		}else{
			return root;
		}
	}
	
}