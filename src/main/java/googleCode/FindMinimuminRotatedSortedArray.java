package googleCode;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] A) {
    	int i = 0, j = A.length - 1;
    	while(i <= j){
    		if(i == j) return A[i];
    		if(i + 1 == j) return Math.min(A[i], A[j]);
    		int m = i + ((j - i) >>> 1);
    		if(A[m] > A[i] && A[m] > A[j]) i = m;
    		else if(A[m] < A[i] && A[m] < A[j]) j = m;
    		else return A[i];
    	}
    	return Integer.MAX_VALUE;
    }
    
    public int findMin2(int[] A) {
    	int i = 0, j = A.length - 1;
    	while(i <= j){
    		if(i == j) return A[i];
    		if(i + 1 == j) return Math.min(A[i], A[j]);
    		int m = i + ((j - i) >>> 1);
    		if(A[m] > A[j]) i = m;
    		else j = m;
    	}
    	return Integer.MAX_VALUE;
    }
}
