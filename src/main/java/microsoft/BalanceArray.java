package microsoft;

public class BalanceArray {

	public static void main(String[] args) {
		int[] A = { 100, 99, 98, 1, 2, 3 };
		int[] B = { 1, 2, 3, 4, 5, 40 };
		BalanceArray ba = new BalanceArray();
		ba.balance(A, B);

		for (int e : A) {
			System.out.print(e + "\t");
		}
		System.out.println();
		for (int e : B) {
			System.out.print(e + "\t");
		}
		System.out.println();
	}

	public void balance(int[] A, int[] B) {
		int len = A.length;
		assert (len == B.length);
		if (len == 1) return;

		int sumA = sum(A);
		int sumB = sum(B);

		double differ = sumA - sumB;

		while (differ != 0) {
			double min = Double.MAX_VALUE;
			int aloc = -1, bloc = -1;
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					double tmp = Math.abs(A[i] - B[j] - differ / 2.0);
					if (tmp < min) {
						min = tmp;
						aloc = i;
						bloc = j;
					}
				}
			}
			// int tmp = A[aloc] - B[bloc];
			// if(differ > 0){
			// if(tmp > 0 && tmp < differ){
			// int ctmp = A[aloc];
			// A[aloc] = B[bloc];
			// B[bloc] = ctmp;
			// differ -= 2 * tmp;
			// }else{
			// break;
			// }
			// }else{
			// if(tmp < 0 && tmp > differ){
			// int ctmp = A[aloc];
			// A[aloc] = B[bloc];
			// B[bloc] = ctmp;
			// differ -= 2 * tmp;
			// }else{
			// break;
			// }
			// }
			double differ2 = differ - ((A[aloc] - B[bloc]) << 1);
			if (Math.abs(differ2) < Math.abs(differ)) {
				int ctmp = A[aloc];
				A[aloc] = B[bloc];
				B[bloc] = ctmp;
				differ = differ2;
			} else {
				break;
			}
		}
	}

	public void balance2(int[] A, int[] B) {
		int delta = sum(A) - sum(B);
		while (true) {
			double left = (delta - Math.abs(delta)) / 2.0;
			double right = (delta + Math.abs(delta)) / 2.0;
			boolean find = false;
			for (int i = 0; i < A.length && !find; i++) {
				for (int j = 0; j < B.length && !find; j++) {
					int diff = A[i] - B[j];
					if (diff < right && diff > left) {
						find = true;
						int tmp = A[i];
						A[i] = A[j];
						A[j] = tmp;
					}
				}
			}
			if (!find) break;
		}
	}

	public int sum(int[] a) {
		int res = 0;
		for (int e : a) {
			res += e;
		}
		return res;
	}
}