package googleCode;

public class FindPeakElement {
    public int findPeakElement(int[] A) {
        for(int i = 0; i < A.length; i++){
        	if((i == 0 || A[i] > A[i - 1]) && (i == A.length - 1 || A[i] > A[i + 1])) return i;
        }
        return -1;
    }
    
    public int findPeakElement2(int[] A){
    	//continuous elements are not equal.
    	int left = 0, right = A.length - 1;
    	while(left <= right){
    		int mid = left + ((right - left) >>> 1);
    		if((mid == left || A[mid - 1] < A[mid]) && ((mid == right || A[mid + 1] < A[mid]))) return mid;
    		if(mid > left && A[mid - 1] > A[mid]) right = mid - 1;
    		else left = mid + 1;
    	}
    	return -1;
    }
}
