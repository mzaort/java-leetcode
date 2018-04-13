package solution;

public class SearchForARange {

	public int[] searchRange(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0)
			return new int[] { -1, -1 };

		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (A[mid] > target) {
				right = mid - 1;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				int[] res = new int[2];
				res[0] = searchLeft(A, left, mid);
				res[1] = searchRight(A, mid, right);
				return res;
			}
		}

		return new int[] { -1, -1 };
	}

	private int searchRight(int[] a, int mid, int right) {
		int left = mid + 1;
		while (left <= right) {
			int mid2 = (left + right) >> 1;
			if (a[mid2] > a[mid]) {
				right = mid2 - 1;
			} else if (a[mid2] < a[mid]) {
				left = mid2 + 1;
			} else {
				return searchRight(a, mid2, right);
			}
		}
		return mid;
	}

	private int searchLeft(int[] a, int left, int mid) {
		int right = mid - 1;
		while (left <= right) {
			int mid2 = (left + right) >> 1;
			if (a[mid2] > a[mid]) {
				right = mid2 - 1;
			} else if (a[mid2] < a[mid]) {
				left = mid2 + 1;
			} else {
				return searchLeft(a, left, mid2);
			}
		}
		return mid;
	}
}