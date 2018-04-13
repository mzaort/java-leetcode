package JaneStreet;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target == A[mid])
				return mid;
			else if (target < A[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left;
	}
}
