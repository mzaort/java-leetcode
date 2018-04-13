package googleCode;

public class SearchforaRange {
    public int[] searchRange(int[] A, int target) {
        int[] res = {-1, -1};        
        int left = searchLeft(A, target);
        int right = searchRight(A, target);        
        if(right - left > 1){
        	res[0] = left + 1;
        	res[1] = right - 1;
        }
        return res;
    }

	private int searchLeft(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while(left <= right){
			int mid = left + ((right - left) >> 1);
			if(A[mid] < target) left = mid + 1;
			else right = mid - 1;
		}
		return right;
	}
	
	private int searchRight(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while(left <= right){
			int mid = left + ((right - left) >> 1);
			if(A[mid] <= target) left = mid + 1;
			else right = mid - 1;
		}
		return left;
	}
}
