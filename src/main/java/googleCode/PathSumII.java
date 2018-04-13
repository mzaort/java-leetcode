package googleCode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(root != null){
    		if(root.left == null){
    			if(root.right == null){
    				if(root.val == sum){
    					List<Integer> tmp = new ArrayList<Integer>();
    					tmp.add(root.val);
    					res.add(tmp);
    				}
    			}else{
    				for(List<Integer> e : pathSum(root.right, sum - root.val)){
    					List<Integer> tmp = new ArrayList<Integer>();
    					tmp.add(root.val);
    					tmp.addAll(e);
    					res.add(tmp);
    				}
    			}
    		}else{
    			if(root.right == null){
    				for(List<Integer> e : pathSum(root.left, sum - root.val)){
    					List<Integer> tmp = new ArrayList<Integer>();
    					tmp.add(root.val);
    					tmp.addAll(e);
    					res.add(tmp);
    				}
    			}else{
    				for(List<Integer> e : pathSum(root.left, sum - root.val)){
    					List<Integer> tmp = new ArrayList<Integer>();
    					tmp.add(root.val);
    					tmp.addAll(e);
    					res.add(tmp);
    				}
    				for(List<Integer> e : pathSum(root.right, sum - root.val)){
    					List<Integer> tmp = new ArrayList<Integer>();
    					tmp.add(root.val);
    					tmp.addAll(e);
    					res.add(tmp);
    				}
    			}
    		}
    	}
    	return res;
    }
    public List<List<Integer>> pathSum2(TreeNode root, int sum){
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	pathSum2(res, new ArrayList<Integer>(), root, sum);
    	return res;
    }
	private void pathSum2(List<List<Integer>> res,
			List<Integer> cur, TreeNode root, int sum) {
		if(root == null) return;
		if(root.left == null && root.right == null){
			if(sum == root.val){
				cur.add(root.val);
				res.add(cur);
			}
		}else{
			if(root.left != null){
				List<Integer> tmp = new ArrayList<Integer>(cur);
				tmp.add(root.val);
				pathSum2(res, tmp, root.left, sum - root.val);
			}
			if(root.right != null){
				List<Integer> tmp = new ArrayList<Integer>(cur);
				tmp.add(root.val);
				pathSum2(res, tmp, root.right, sum - root.val);
			}
		}
	}
}
