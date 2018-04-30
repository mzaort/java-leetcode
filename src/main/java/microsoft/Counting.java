package microsoft;

public class Counting {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 2, 3, 4 };
		Counting ct = new Counting();
		System.out.println(ct.numberOfElement(arr, 0));
	}

	public int numberOfElement(int[] arr, int target) {
		int end = searchInsertionIndex(arr, 0, arr.length - 1, target);
		int frm = searchInsertionIndex2(arr, 0, arr.length - 1, target);
		return end - frm - 1;
	}

	public int searchInsertionIndex(int[] arr, int i, int j, int target) {
		while (i <= j) {
			int mid = i + ((j - i) >> 1);
			if (arr[mid] <= target) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		return i;
	}

	public int searchInsertionIndex2(int[] arr, int i, int j, int target) {
		while (i <= j) {
			int mid = i + ((j - i) >> 1);
			if (arr[mid] < target) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		return j;
	}
}