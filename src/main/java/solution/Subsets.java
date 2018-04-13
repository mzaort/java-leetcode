package solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	public static void main(String[] args) {
		int[] s = {1,2,3};
		ArrayList<ArrayList<Integer>> res = new Subsets().subsets2(s);
		for(ArrayList<Integer> e:res){
			System.out.println(e);
		}
	}
	
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
        int all = 1 << S.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(all);
        
        Arrays.sort(S);
        for(int index = 0; index < all; index++){
        	ArrayList<Integer> tmp = new ArrayList<Integer>();
        	int itmp = index;
        	for(int j = 0; j < S.length && itmp != 0; j++){
        		if((itmp & 1) == 1){
        			tmp.add(S[j]);
        		}
        		itmp >>= 1;	
        	}
        	res.add(tmp);
        }
        return res;
    }
    
    public ArrayList<ArrayList<Integer>> subsets2(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(S == null) return null;
    	if(S.length == 0){
    		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    		res.add(new ArrayList<Integer>());
    		return res;
    	}
    	
    	Arrays.sort(S);
    	return subsets(S, S.length - 1);
    }

	private ArrayList<ArrayList<Integer>> subsets(int[] s, int j) {
		ArrayList<ArrayList<Integer>> res;
		if(0 == j){
			res = new ArrayList<ArrayList<Integer>>(2);
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(s[j]);
			res.add(new ArrayList<Integer>());
			res.add(tmp);
			return res;
		}
		ArrayList<ArrayList<Integer>> sub = subsets(s, j - 1);
		res = new ArrayList<ArrayList<Integer>>(1 << (j + 1));
		res.addAll(sub);
		
		for(ArrayList<Integer> e:sub){
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for(Integer t:e){
				tmp.add(t);
			}
			tmp.add(s[j]);
			res.add(tmp);
		}
		return res;
	}
}
