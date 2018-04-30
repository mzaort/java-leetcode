package microsoft;

public class MaxSubArray {

	public static void main(String[] args) {
		MaxSubArray msa = new MaxSubArray();
		int[] arr = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(msa.maxSubArray(arr));
	}

	public int maxSubArray(int[] arr) {
		int len = arr.length;
		if (len == 0) return 0;

		int res = arr[0];
		int fmax = arr[0];
		for (int i = 1; i < len; i++) {
			if (fmax > 0) {
				fmax += arr[i];
			} else {
				fmax = arr[i];
			}
			if (fmax > res) {
				res = fmax;
			}
		}
		return res;
	}
}