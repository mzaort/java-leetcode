package solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Sum3 {
	public static void main(String[] args) {
		Sum3 s3 = new Sum3();
		System.out.println(s3.threeSum(new int[]{-1,0,1,2,-1,-4}));
	}
	
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(num == null || num.length < 3) return res;    	
    	Arrays.sort(num);
    	
    	int len = num.length;
    	for(int a = 0; a < len - 2 && num[a] < 1;){
    		int ask = - num[a];
    		for(int b = a + 1, c = len - 1; b < c;){
    			if(num[b] + num[c] < ask){
    				b++;
    			}else if(num[b] + num[c] > ask){
    				c--;
    			}else{
    				ArrayList<Integer> tmp = new ArrayList<Integer>(3);
    				tmp.add(num[a]);
    				tmp.add(num[b]);
    				tmp.add(num[c]);
    				res.add(tmp);
    				int i;
    				for(i = b + 1; i < c && num[i] == num[b]; i++);
    				b = i;
    				for(i = c - 1; i > b && num[i] == num[c]; i--);
    				c = i;
    			}
    		}
    		int i;
			for(i = a + 1; i < len - 2 && num[i] == num[a]; i++);
			a = i;
    	}
    	return res;    	
    }
	
    public ArrayList<ArrayList<Integer>> WrongthreeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(num == null || num.length < 3) return res;
    	ArrayList<Integer> tmp = new ArrayList<Integer>();
    	tmp.add(Integer.MIN_VALUE);
    	tmp.add(Integer.MIN_VALUE);
    	tmp.add(Integer.MIN_VALUE);
    	res.add(tmp);
    	
    	
    	Arrays.sort(num);
    	int len = num.length;
    	int wanted = 0;
    	for(int i = 0; i < len - 2 && num[i] < (wanted/3 + 1); i++){
    		int wanted2 = wanted - num[i];
    		for(int j = i + 1; j < len - 1 && num[j] < (wanted2/2 + 1); j++){
    			int wanted3 = wanted2 - num[j];
    			int index = Arrays.binarySearch(num, j + 1, len, wanted3);
    			if(index > 0){
    				ArrayList<Integer> tmp2 = res.get(res.size() - 1);
    				if(!(tmp2.get(0) == num[i] && tmp2.get(1) == num[j] && tmp2.get(2) == wanted3)){
    					tmp = new ArrayList<Integer>();
    					tmp.add(num[i]);
    					tmp.add(num[j]);
    					tmp.add(wanted3);
    					res.add(tmp);
    				}
    			}
    		}
    	}
    	res.remove(0);
    	return res;
    	
    }
}
