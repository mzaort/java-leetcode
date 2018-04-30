package JaneStreet;

public class SearchforaRange {
	public int[] searchRange(int[] A, int target) {
		int[] res = { -1, -1 };
		int frm = searchLeft(A, target);
		int end = searchRight(A, target);
		if (end - frm > 1) {
			res[0] = frm + 1;
			res[1] = end - 1;
		}
		return res;
	}

	// return the location of the first larger element
	// or the 'length'
	private int searchRight(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target < A[mid]) right = mid - 1;
			else left = mid + 1;
		}
		return left;
	}

	// return the location of the last smaller element
	// or -1
	private int searchLeft(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target <= A[mid]) right = mid - 1;
			else left = mid + 1;
		}
		return right;
	}
}
