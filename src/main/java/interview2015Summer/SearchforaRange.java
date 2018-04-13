package interview2015Summer;

public class SearchforaRange {
	public int[] searchRange(int[] A, int target){
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
		int i = 0, j = A.length - 1;
		while(i <= j){
			int mid = i + ((j - i) >>> 1);
			if(target <= A[mid]) j = mid - 1;
			else i = mid + 1;
		}
		return j;
	}

	private int searchRight(int[] A, int target) {
		int i = 0, j = A.length - 1;
		while(i <= j){
			int mid = i + ((j - i) >>> 1);
			if(target < A[mid]) j = mid - 1;
			else i = mid + 1;
		}
		return i;
	}
}
