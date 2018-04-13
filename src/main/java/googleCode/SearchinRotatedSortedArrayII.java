package googleCode;

public class SearchinRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
    	int left = 0, right = A.length - 1;
    	while(left <= right){
    		int mid = left + ((right - left) >>> 1);
    		if(A[mid] == target) return true;
    		if(A[mid] > A[left] || A[mid] > A[right]){
    			if(target >= A[left] && target < A[mid]){
    				right = mid - 1;
    			}else{
    				left = mid + 1;
    			}
    		}else if(A[mid] < A[left] || A[mid] < A[right]){
    			if(target > A[mid] && target <= A[right]){
    				left = mid + 1;
    			}else{
    				right = mid - 1;
    			}
    		}else{
    			left++;
    			right--;
    		}
    	}
    	return false;
    }
}
