package solution;

public class SearchinRotatedSortedArray {
	public static void main(String[] args) {
		int[] a = { 3, 1 };
		System.out.println(new SearchinRotatedSortedArray().search(a, 1));
	}

	public int search(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return search(A, 0, A.length - 1, target);
	}

	public int search2(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return search2(A, 0, A.length - 1, target);
	}

	private int search(int[] a, int i, int j, int target) {
		if (i > j) return -1;
		int mid = (i + j) >> 1;
		if (a[mid] == target) {
			return mid;
		} else if (a[i] <= a[mid]) {
			if (target >= a[i] && target < a[mid]) {
				return binarySearch(a, i, mid - 1, target);
			} else {
				return search(a, mid + 1, j, target);
			}
		} else {
			if (target > a[mid] && target <= a[j]) {
				return binarySearch(a, mid + 1, j, target);
			} else {
				return search(a, i, mid - 1, target);
			}
		}
	}

	private int binarySearch(int[] a, int left, int right, int target) {
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (a[mid] == target) {
				return mid;
			} else if (a[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	private int search2(int[] a, int i, int j, int target) {
		while (i <= j) {
			int mid = i + ((j - i) >> 1);
			if (a[mid] == target) {
				return mid;
			} else if (a[mid] < target) {
				if (a[i] <= a[mid] && a[mid] >= a[j]) {
					i = mid + 1;
				} else {
					if (a[j] >= target) {
						i = mid + 1;
					} else {
						j = mid - 1;
					}
				}
			} else {
				if (a[i] <= a[mid] && a[mid] >= a[j]) {
					if (a[i] <= target) {
						j = mid - 1;
					} else {
						i = mid + 1;
					}
				} else {
					i = mid + 1;
				}
			}
		}
		return -1;
	}
}
