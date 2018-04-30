package microsoft;

public class CardPlay {

	public static void main(String[] args) {
		CardPlay cp = new CardPlay();
		int[] arr = { 0, 1, 2, 3, 4, 9, 6, 7, 8, 5, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52,
				53 };
		System.out.println(cp.isComplete(arr));
	}

	public boolean isComplete(int[] arr) {
		int len = arr.length;
		assert (len == 54);

		for (int i = 0; i < len; i++) {
			if (arr[i] < 0 || arr[i] >= len) return false;
			if (arr[i] != i) {
				int j = arr[i];
				if (arr[j] == j) return false;
				swap(arr, i, j);
				i--;
			}
		}
		return true;
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
