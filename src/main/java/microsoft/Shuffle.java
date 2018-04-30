package microsoft;

public class Shuffle {
	public void shuffle(int[] arr) {
		int len = arr.length;
		if (len <= 1) return;

		for (int i = 1; i < len; i++) {
			int j = (int) (Math.random() * (i + 1));
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}
}