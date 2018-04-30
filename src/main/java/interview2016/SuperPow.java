package interview2016;

public class SuperPow {
	public static final int BASE = 1337;

	public int superPow(int a, int[] b) {
		assert (a > 0);
		int result = 0;
		int[] c = new int[b.length];
		for (int i = c.length - 1, j = 0; i >= 0; i--, j++) {
			if (j == 0) {
				c[i] = a % BASE;
			} else {

			}
		}

		return result;
	}

}
