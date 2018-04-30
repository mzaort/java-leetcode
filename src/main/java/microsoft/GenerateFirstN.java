package microsoft;

public class GenerateFirstN {
	public static void main(String[] args) {
		GenerateFirstN gfn = new GenerateFirstN();
		int[] res = gfn.generate(3, 5, 9);
		for (int e : res) {
			System.out.println(e + "\t");
		}
		System.out.println();
	}

	public int[] generate(int a, int b, int N) {
		assert (a > 0 && b > 0 && N > 0);

		int[] res = new int[N];
		for (int i = a, j = b, k = 0; k < N; k++) {
			if (i < j) {
				res[k] = i;
				i += a;
			} else if (i == j) {
				res[k] = i;
				i += a;
				j += b;
			} else {
				res[k] = j;
				j += b;
			}
		}
		return res;
	}
}