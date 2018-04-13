package googleCode;

public class MaximumProductSubarray {
	
	public static void main(String[] args) {
		int[] A = {-3, -4};
		MaximumProductSubarray mps = new MaximumProductSubarray();
		System.out.println(mps.maxProduct2(A));
	}
    public int maxProduct(int[] A) {
    	int res = Integer.MIN_VALUE;
    	for(int i = 0; i < A.length; i++){
    		int v = 1;
    		for(int j = i; j < A.length; j++){
    			v *= A[j];
    			res = Math.max(v, res);
    		}
    	}
    	return res;
    }
    
    public int maxProduct2(int[] A){
    	return maxProductDCC(A, 0, A.length - 1);
    }

	private int maxProductDCC(int[] A, int i, int j) {
		if(i > j) return Integer.MIN_VALUE;
		else if(i == j) return A[i];
		else{
			int maxPL, maxPR, minNL, minNR;
			maxPL = maxPR = Integer.MIN_VALUE;
			minNL = minNR = Integer.MAX_VALUE;
			
			int mid = i + ((j - i) >>> 1);
			for(int k = mid, mul = 1; k >= i; k--){
				mul *= A[k];
				if(mul < 0) minNL = Math.min(minNL, mul);
				else maxPL = Math.max(maxPL, mul);
			}
			for(int k = mid + 1, mul = 1; k <= j; k++){
				mul *= A[k];
				if(mul < 0) minNR = Math.min(minNR, mul);
				else maxPR = Math.max(maxPR, mul);
			}
			
			int res = Integer.MIN_VALUE;
			if(maxPL >= 0 && maxPR >= 0) res = Math.max(res, maxPL * maxPR);
			if(minNL < 0 && minNR < 0) res = Math.max(res, minNL * minNR);
			
			res = Math.max(res, maxProductDCC(A, i, mid));
			res = Math.max(res, maxProductDCC(A, mid + 1, j));
			return res;
		}
	}
	
	public int maxProduct3(int[] A){
		int res = A.length == 0 ? Integer.MIN_VALUE : A[0];
		int f = Integer.MIN_VALUE, g = Integer.MAX_VALUE;
		
		for(int e : A){
			if(e == 0){
				f = Integer.MIN_VALUE;
				g = Integer.MAX_VALUE;
				res = Math.max(res, 0);
			}else if(e > 0){
				f = f == Integer.MIN_VALUE ? e : Math.max(f * e, e);
				g = g == Integer.MAX_VALUE ? g : g * e;
			}else{
				int f1 = g == Integer.MAX_VALUE ? Integer.MIN_VALUE : g * e;
				g = f == Integer.MIN_VALUE ? e : Math.min(e, e * f);
				f = f1;
			}
			res = Math.max(res, f);
		}
		return res;
	}
}

