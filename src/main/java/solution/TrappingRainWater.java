package solution;

public class TrappingRainWater {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length <= 1) return 0;
        int len = A.length;
        
        int res = 0;
        int max = A[0], left = 0, right;
        
        for(int i = 1; i < len; i++){
        	if(max < A[i]){
        		max = A[i];
        		left = i;
        	}
        }
        
        for(right = len - 1; right >= left && A[right] < max; right--);
        
        int low = A[0];
        for(int i = 1; i < left; i++){
        	if(A[i] < low){
        		res += low - A[i];
        	}else if(A[i] > low){
        		low = A[i];
        	}
        }
        low = A[len - 1];
        for(int i = len - 2; i > right; i--){
        	if(A[i] < low){
        		res += low - A[i];
        	}else if(A[i] > low){
        		low = A[i];
        	}
        }
        if(left != right){
        	for(int i = left + 1; i < right; i++){
        		res += max - A[i];
        	}
        }
        
        return res;
    }
}
