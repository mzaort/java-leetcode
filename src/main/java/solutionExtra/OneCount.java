package solutionExtra;

public class OneCount {

	public static void main(String[] args) {
		OneCount oc = new OneCount();
		System.out.println(oc.countOnes(0));
		System.out.println(oc.countOnes2(100000));
		// boolean flag = true;
		// for(int i = 1890; i < 2000; i++){
		// flag &= (oc.countOnes(i) == oc.countOnes2(i));
		// }
		// System.out.println(flag);
		System.out.println(oc.countOnes2(299) - oc.countOnes2(199));
	}

	public int countOnes(int end) {
		int res = 0;
		if (end < 0) end = -end;
		for (int i = 0; i <= end; i++) {
			res += count(i);
		}
		return res;
	}

	private int count(int i) {
		int res = 0;
		while (i != 0) {
			if (i % 10 == 1) {
				res++;
			}
			i /= 10;
		}
		return res;
	}

	public int countOnes2(int end) {
		if (end < 0) end = -end;

		int[] num = new int[32];
		int len = 0;
		int tmp = end;
		for (; len < 32 && tmp != 0; len++) {
			num[len] = tmp % 10;
			tmp /= 10;
		}

		if (len <= 1) {
			return len;
		} else {
			int res = 0;
			int[] cnt = new int[len - 1];
			cnt[0] = 1;
			for (int i = 1; i < len - 1; i++) {
				cnt[i] = (int) (10 * cnt[i - 1] + Math.pow(10, i));
			}

			for (int i = len - 1; i > 0; i--) {
				res += num[i] * cnt[i - 1];
				if (num[i] > 1) {
					res += Math.pow(10, i);
				} else if (num[i] == 1) {
					res += end % (Math.pow(10, i)) + 1;
				}
			}

			if (num[0] >= 1) {
				res++;
			}
			return res;
		}
	}

}
