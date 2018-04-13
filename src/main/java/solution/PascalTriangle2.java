package solution;

import java.util.ArrayList;

public class PascalTriangle2 {
	
	public static void main(String[] args) {
		PascalTriangle2 pt2 = new PascalTriangle2();
		System.out.println(pt2.getRow(13));
	}
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if(rowIndex < 0) return res;
    	int len = rowIndex + 1;
    	int[] factorial = new int[len];
    	factorial[0] = 1;
    	for(int i = 1; i < len; i++){
    		factorial[i] = factorial[i-1]*i;
    	}
    	
    	for(int i = 0; i <= rowIndex; i++){
    		res.add(factorial[rowIndex]/factorial[i]/factorial[rowIndex - i]);
    	}
    	return res;
    }
    
    public ArrayList<Integer> getRow2(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if(rowIndex < 0) return res;
    	int[] seq = new int[rowIndex + 1];
    	seq[0] = 1;
    	for(int i = 1; i <= rowIndex; i++){
    		int sur = seq[0];
    		for(int j = 1; j < i; j++){
    			int tmp = sur + seq[j];
    			sur = seq[j];
    			seq[j] = tmp;
    		}
    		seq[i] = 1;
    	}
    	for(int i = 0; i <= rowIndex; i++){
    		res.add(seq[i]);
    	}
    	return res;
    }
}
