package solution;

public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        if(len <= 1) return len;
        int cnt = 1, top = 0, cur = 1;
        for(; cur < len; cur++){
        	if(A[cur] == A[top]){
        		if(cnt < 2){
        			cnt++;
        			A[++top] = A[cur];
        		}
        	}else{
        		A[++top] = A[cur];
        		cnt = 1;
        	}
        }
        return top + 1;
    }
}
