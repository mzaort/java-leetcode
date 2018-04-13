package solution;

import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        List<Integer> list = new ArrayList<Integer>(128);
        
        int abs = x > 0 ? x:-x;
        while(abs != 0){
        	int current = abs % 10;
        	list.add(current);
        	abs = abs / 10;
        }
    	
        int res = 0;
        for(Integer i : list){
        	res = (res * 10) + i;
        }
        
        res = x > 0 ? res : -res;
        return res;
    }
    
    public int reverse2(int x){
    	int abs = x > 0 ? x:-x;
    	int res = 0;
    	
    	while(abs != 0){
    		res = res * 10 + abs % 10;
    		abs = abs / 10;
    	}
    	res = x > 0 ? res : -res;
    	
    	return res;
    }
    
    public static int reverseBits(int y) {  
        // INT_SIZE=32 in general  
        int INT_SIZE = Integer.SIZE;  
        // Two-head pointer
        for (int i = 0, j = INT_SIZE - 1; i < INT_SIZE / 2; i++, j--) {  
            int low = (y >> i) & 1;  
            int high = (y >> j) & 1;  
  
            if ((high ^ low) == 1) {
                y = y ^ ((1 << i) | (1 << j));
            }  
        }  
        return y;  
    }  
    
    public static int reverseBits2(int y) {
        // INT_SIZE=32 in general  
        int INT_SIZE = Integer.SIZE;
        
        int res = 0;
        for(int i = 0; i < INT_SIZE; i++){
        	res = (res << 1) + (y & 1);
        	y >>= 1;
        }
        
        return res;  
    }  
}
