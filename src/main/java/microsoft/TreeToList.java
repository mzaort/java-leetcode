package microsoft;
public class TreeToList{
	
	public static void main(String[] args) {
		TreeNode tn1 = new TreeNode(8);
		TreeNode tn2 = new TreeNode(7);
		TreeNode tn3 = new TreeNode(9);
		TreeNode tn4 = new TreeNode(5);
		TreeNode tn5 = new TreeNode(4);
		tn1.left = tn4;
		tn1.right = tn3;
		tn4.left = tn5;
		tn4.right = tn2;
		TreeNode[] res = new TreeToList().tree2list(tn1);
		if(res != null){
			TreeNode p = res[0];
			while(p != null){
				System.out.println(p.val);
				p = p.left;
			}
		}
	}

	public TreeNode[] tree2list(TreeNode root){
		if(root == null) return null;
		TreeNode[] res = new TreeNode[2];
		TreeNode[] leftList = tree2list(root.left);
		TreeNode[] rightList = tree2list(root.right);
		if(leftList == null){
			res[0] = root;
			res[0].right = null;
		}else{
			res[0] = leftList[0];
			leftList[1].left = root;
			root.right = leftList[1];
		}
		if(rightList == null){
			res[1] = root;
			res[1].left = null;
		}else{
			root.left = rightList[0];
			rightList[0].right = root;
			res[1] = rightList[1];
		}
		return res;
	}

}