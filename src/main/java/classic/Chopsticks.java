package classic;
import java.util.Arrays;

public class Chopsticks {
	public int cut(int[] A){
		assert(A.length > 0);
		
		int sum = 0;
		for(int e : A) sum += e;
		
		Arrays.sort(A);
		int ans = sum / A[A.length - 1];
		boolean[] flag = new boolean[A.length];
		for(; ans > 1; ans--){
			if(sum % ans == 0){
				Arrays.fill(flag, true);
				if(isCuttable(ans, sum / ans, 0, A, A.length - 1, flag)) return ans;
			}
		}
		return ans;
	}

	private boolean isCuttable(int ans, int len, int s, int[] A, int cur, boolean[] flag) {
		if(s == 0) return (ans == 0) || isCuttable(ans - 1, len, len, A, A.length - 1, flag);
		for(; cur >= 0 && !(flag[cur] && A[cur] <= s); cur--);
		if(cur < 0) return false;
		flag[cur] = false;
		return isCuttable(ans, len, s - A[cur], A, cur - 1, flag);
	}
}
