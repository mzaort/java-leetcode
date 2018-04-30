package microsoft;

public class Random {
	public int seed() {
		double p = 0.3;
		if (Math.random() < p) {
			return 0;
		} else {
			return 1;
		}
	}

	public int seed01() {
		int sd1 = seed();
		int sd2 = seed();
		if (sd1 == 0) {
			if (sd2 == 0) {
				return seed01();
			} else {
				return 0;
			}
		} else {
			if (sd2 == 0) {
				return 1;
			} else {
				return seed01();
			}
		}
	}

	public int seedn(int n) {
		assert (n > 0);

		int k = 0;
		int a = n;
		while (a != 0) {
			a >>>= 1;
			k++;
		}
		int res = 0;
		for (int i = 0; i < k; i++) {
			res <<= 1;
			res += seed01();
		}

		if (res < n) {
			return res;
		} else {
			return seedn(n);
		}
	}
}