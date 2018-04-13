package interview;

public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
		int[] res = new int[] { -1, -1 };
		int left = searchLeft(A, target);
		int right = searchRight(A, target);
		if (right - left - 1 > 0) {
			res[0] = left + 1;
			res[1] = right - 1;
		}
		return res;
	}

	public int searchLeft(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (A[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

	public int searchRight(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (A[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
}