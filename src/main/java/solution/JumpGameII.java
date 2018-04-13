package solution;

public class JumpGameII {
	public int jump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length <= 1) return 0;
		int len = A.length;

		int[] step = new int[len];
		step[len - 1] = 0;

		for (int i = len - 2; i >= 0; i--) {
			if (i + A[i] >= len - 1) {
				step[i] = 1;
			} else {
				if (A[i] == 0) {
					step[i] = Integer.MAX_VALUE;
				}else{
					int min = step[i + 1];
					for (int j = i + 2; j <= i + A[i]; j++) {
						if (min > step[j]) {
							min = step[j];
						}
					}
					if(min == Integer.MAX_VALUE){
						step[i] = Integer.MAX_VALUE;
					}else{
						step[i] = min + 1;
					}
				}
			}
		}
		return step[0];
	}
}
