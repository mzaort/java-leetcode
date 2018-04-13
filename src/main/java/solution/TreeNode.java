package solution;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
	
	static TreeNode make(int[] value){
		if(value == null || value.length == 0) return null;
		TreeNode[] res = new TreeNode[value.length];
		res[0] = new TreeNode(value[0]);
		for(int i = 1; i < value.length; i++){
			if(value[i] != Integer.MAX_VALUE){
				res[i] = new TreeNode(value[i]);
				if(i % 2 == 0){
					res[(i+1)/2-1].right = res[i];
				}else{
					res[(i+1)/2-1].left = res[i];
				}
			}
		}		
		return res[0];
	}
}