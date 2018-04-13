package googleCode;

public class MaximumSubarray {
	
	public static void main(String[] args) {
		int[] A = {-2, 1};
		MaximumSubarray ms = new MaximumSubarray();
		System.out.println(ms.maxSubArray3(A));
	}
	
	
    public int maxSubArray(int[] A) {
        assert(A.length > 0);
        int[] f = new int[A.length];
        
        f[0] = A[0];
        for(int i = 1; i < A.length; i++){
        	f[i] = A[i] + f[i - 1] > A[i] ? A[i] + f[i - 1] : A[i];
        }
        
        int res = f[0];
        for(int i = 0; i < A.length; i++){
        	if(res < f[i]) res = f[i];
        }
        
        return res;
    }
    
    public int maxSubArray2(int[] A) {
        assert(A.length > 0);
        
        int res = A[0];
       	int cur = A[0];
        for(int i = 1; i < A.length; i++){
        	cur = A[i] + cur > A[i] ? A[i] + cur : A[i];
        	if(res < cur) res = cur;
        }
        return res;
    }
    
    public int maxSubArray3(int[] A) {
        assert(A.length > 0);
        return maxSubArray3(A, 0, A.length - 1);
    }

	private int maxSubArray3(int[] A, int frm, int end) {
		if(frm > end) return Integer.MIN_VALUE;
		if(frm == end) return A[frm];
		int mid = frm + ((end - frm) >> 1);
		int left = maxSubArray3(A, frm, mid);
		int right = maxSubArray3(A, mid + 1, end);
		
		int lm = A[mid], suml = A[mid];
		for(int i = mid - 1; i >= frm; i--){
			suml += A[i];
			if(suml > lm) lm = suml;
		}
		
		int rm = A[mid + 1], sumr = A[mid + 1];
		for(int i = mid + 2; i <= end; i++){
			sumr += A[i];
			if(sumr > rm) rm = sumr;
		}
		
		int res = lm + rm;
		if(res < left) res = left;
		if(res < right) res = right;
		return res;
	}
    
}
