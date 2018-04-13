package solution;

import java.util.ArrayList;

public class Combinations {
	
	public static void main(String[] args) {
		Combinations cb = new Combinations();
		cb.combine(2, 1);
	}
	
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(n <= 0 || k < 0 || k > n) return res;
    	
    	int[] num = new int[k + 1];
    	for(int i = 1; i <= k; i++){
    		num[i] = i;
    	}
    		
    	boolean flag = true;
    	while(flag){
    		ArrayList<Integer> list = new ArrayList<Integer>();
        	for(int i = 1; i <= k; i++){
        		list.add(num[i]);
        	}
        	res.add(list);
        	
        	flag = false;
        	for(int i = k; i >= 1; i--){
        		if(num[i] < n - k + i){
        			int tmp = num[i] + 1;
        			for(int j = i; j <= k; j++, tmp++){
        				num[j] = tmp;
        			}
        			flag = true;
        			break;
        		}
        	}
    	}
    	
    	return res;
    }
}
