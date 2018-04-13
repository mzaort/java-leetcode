package solution;

import java.util.LinkedList;

public class JumpGame {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        if(len == 0) return false;
        else if(len == 1) return true;
        
        boolean[] flag = new boolean[len];
        for(int i = 1; i < len; i++)
        	flag[i] = false;
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(0);
        flag[0] = true;
        
        Integer top = null;
        
        while((top = list.poll()) != null){
        	int limit = A[top] + top;
        	if(limit >= len - 1)
        		return true;
        	for(int i = top + 1; i <= limit; i++){
        		if(!flag[i]){
        			list.add(i);
        			flag[i] = true;
        		}
        	}
        }
        return false;
    }
}
