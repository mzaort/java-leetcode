package googleCode;

public class SearchinRotatedSortedArray {
	public static void main(String[] args) {
		SearchinRotatedSortedArray srsa = new SearchinRotatedSortedArray();
		int[] A = { 2, 1 };
		System.out.println(srsa.search2(A, 1));
	}

	public int search(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >>> 1);
			if (target == A[mid]) return mid;
			// mid == left �Ǳ����
			if (mid == left || (A[mid] > A[left] && (target < A[left] || target > A[mid]))
					|| (A[mid] < A[left] && (target > A[mid] && target <= A[right])))
				left = mid + 1;
			else right = mid - 1;
		}
		return -1;
	}

	// ����left may be equal to mid, so check the right
	public int search2(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >>> 1);
			if (target == A[mid]) return mid;
			if ((A[mid] > A[right] && (target < A[left] || target > A[mid]))
					|| (A[mid] < A[right] && (target > A[mid] && target <= A[right])))
				left = mid + 1;
			else right = mid - 1;
		}
		return -1;
	}
}
