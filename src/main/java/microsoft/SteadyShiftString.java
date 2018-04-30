package microsoft;

public class SteadyShiftString {

	public static void main(String[] args) {
		SteadyShiftString sss = new SteadyShiftString();
		char[] c = "abcdef".toCharArray();
		sss.shift2(c, 2);
		System.out.println(new String(c));
	}

	public void shift(char[] arr, int n) {
		assert (n >= 0);

		int len = arr.length;
		if (len <= 1 || n == 0) return;

		n %= len;

		int i = 0;
		char value = arr[0];
		for (int swap = 0; swap < len; swap++) {
			int j = i < n ? len - n + i : i - n;
			char tmp = arr[j];
			arr[j] = value;
			value = tmp;
			i = j;
		}
	}

	public void shift2(char[] arr, int n) {
		int L = arr.length;
		if (L == 0 || L == 1) return;
		int shift = n % L;
		if (shift < 0) shift += L;
		if (shift == 0) return;
		int limit = 1;
		if (L % shift == 0) limit = shift;
		if (L % (L - shift) == 0) limit = L - shift;
		for (int i = 0; i < limit; i++) {
			int j = i;
			char val = arr[i];
			do {
				int k = (j + shift) % L;
				char tmp = arr[k];
				arr[k] = val;
				j = k;
				val = tmp;
			} while (j != i);
		}
	}
}