package microsoft;

public class CycleMN {

	public static void main(String[] args) {
		CycleMN cmn = new CycleMN();
		System.out.println(cmn.cycle(3, 4));
		for (int i = 0; i < 10; i++) {
			int n = (int) (Math.random() * 100);
			if (n == 0) n = 1;
			int m = (int) (Math.random() * 100);
			if (m == 0) m = 1;
			System.out.println(cmn.cycle(n, m) == cmn.josephIterative(n, m));
		}
	}

	public int cycle(int n, int m) {
		assert (n > 0 && m > 0);

		int[] mask = new int[n];
		for (int i = 0; i < n; i++) {
			mask[i] = 1;
		}

		int first = 0;
		for (int i = 0; i < n - 1; i++) {
			int j = first;
			int cnt = 0;
			while (cnt < m) {
				cnt += mask[j];
				j = (j + 1) % n;
			}
			first = j;
			mask[(j + n - 1) % n] = 0;
		}

		for (int i = 0; i < n; i++) {
			if (mask[i] == 1) { return i; }
		}

		return 0;
	}

	public int joseph(int n, int m) {
		assert (n > 0 && m > 0);
		return josephRecursive(n, m);
	}

	public int josephRecursive(int n, int m) {
		if (n == 1) {
			return 0;
		} else {
			return (josephRecursive(n - 1, m) + m) % n;
		}
	}

	public int josephIterative(int n, int m) {
		assert (n > 0 && m > 0);
		int res = 0;
		for (int i = 2; i <= n; i++) {
			res = (res + m) % i;
		}
		return res;
	}
}