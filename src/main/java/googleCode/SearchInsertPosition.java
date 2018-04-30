package googleCode;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
}
