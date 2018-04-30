package googleCode;

public class JumpGameII {

	public static void main(String[] args) {
		JumpGameII jg = new JumpGameII();
		System.out.println(jg.jump2(new int[] { 1, 0, 1, 1, 4 }));
	}

	public int jump(int[] A) {
		if (A.length < 2) return 0;
		int[] f = new int[A.length];
		for (int i = A.length - 2; i >= 0; i--) {
			if (i + A[i] >= A.length - 1) {
				f[i] = 1;
				continue;
			}
			int min = -1;
			for (int j = i + 1; j <= i + A[i]; j++) {
				if (f[j] != -1 && (min == -1 || min > f[j])) {
					min = f[j];
				}
			}
			f[i] = min == -1 ? -1 : min + 1;
		}
		return f[0];
	}

	public int jump2(int[] A) {
		int step = 0;
		int left = 0, right = 0, attach = -1;
		while (right < A.length - 1) {
			attach = right;
			for (int i = left; i <= right; i++) {
				if (attach < A[i] + i) attach = A[i] + i;
			}
			if (right == attach) return -1;
			step++;
			left = right + 1;
			right = attach;
		}
		return step;
	}
}
