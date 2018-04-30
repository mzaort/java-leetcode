package solutionExtra;

public class SpecialNumber {
	public static void main(String[] args) {
		// SpecialNumber sn = new SpecialNumber();
		// int[] a = { 1, 2, 4, 5, 6, 4, 2, 6, 1, 5, 7, 8, 8, 7, 9};
		// int n = sn.appearOnce(a);
		// System.out.println(n);

		SpecialNumber sn = new SpecialNumber();
		int[] a = { 1, 2, 4, 5, 6, 4, 8, 6, 1, 5, 7, 10, 8, 9, 9, 10 };
		int[] n = sn.appearOnceWithTwo(a);
		System.out.println(n[0]);
		System.out.println(n[1]);
	}

	/**
	 * һ���������������1������ֻ����һ��֮�⣬
	 * ���������ֶ�������ż���Ρ���д�������ҳ����ֻ����1�ε����֡�Ҫ��ʱ�临�Ӷ���O(n)���ռ临�Ӷ���O(1)��
	 */
	public int appearOnce(int[] data) {
		int res = 0;
		for (int e : data) {
			res ^= e;
		}
		return res;
	}

	/**
	 * һ���������������2������ֻ����һ��֮�⣬
	 * ���������ֶ�������ż���Ρ���д�������ҳ����ֻ����1�ε����֡�Ҫ��ʱ�临�Ӷ���O(n)���ռ临�Ӷ���O(1)��
	 */
	public int[] appearOnceWithTwo(int[] data) {
		int[] res = new int[2];

		int xor = 0;
		for (int e : data) {
			xor ^= e;
		}

		int k = 0;
		while (xor > 0) {
			xor <<= 1;
			k++;
		}

		res[0] = res[1] = 0;

		for (int e : data) {
			if ((e << k) < 0) {
				res[1] ^= e;
			} else {
				res[0] ^= e;
			}
		}

		return res;
	}

	public int[] appearOnceWithTwo2(int[] data) {
		int[] res = new int[2];

		int xor = 0;
		for (int e : data) {
			xor ^= e;
		}

		int diff = xor & ~(xor - 1);

		res[0] = res[1] = 0;

		for (int e : data) {
			if ((e & diff) != 0) {
				res[1] ^= e;
			} else {
				res[0] ^= e;
			}
		}

		return res;
	}
}
