package googleCode;

public class Candy {

	public static void main(String[] args) {
		Candy c = new Candy();
		System.out.println(c.candy3(new int[]{1, 2, 3}));
	}

	// wrong1
	public int candy(int[] ratings) {
		if (ratings.length < 2)
			return ratings.length;
		int[] candy = new int[ratings.length];
		candy[0] = 1;
		int max = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i - 1] < ratings[i]) {
				candy[i] = candy[i - 1] + 1;
				max += candy[i];
			} else if (ratings[i - 1] == ratings[i]) {
				candy[i] = candy[i - 1];
				max += candy[i];
			} else {
				if (candy[i - 1] > 1) {
					candy[i] = 1;
					max += candy[i];
				} else {
					candy[i] = 1;
					max++;
					for (int j = i - 1; j >= 0; j--) {
						if (ratings[j] == ratings[j + 1]) {
							if (candy[j] < candy[j + 1]) {
								candy[j]++;
								max++;
							} else {
								break;
							}
						} else if (ratings[j] > ratings[j + 1]) {
							if (candy[j] == candy[j + 1]) {
								candy[j]++;
								max++;
							} else {
								break;
							}
						} else {
							break;
						}
					}
				}
			}
		}
		return max;
	}

	public int candy2(int[] ratings) {
		if (ratings.length < 2)
			return ratings.length;
		int[] candy = new int[ratings.length];
		candy[0] = 1;
		int max = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i - 1] < ratings[i]) {
				candy[i] = candy[i - 1] + 1;
				max += candy[i];
			} else if (ratings[i - 1] == ratings[i]) {
				candy[i] = 1;
				max += candy[i];
			} else {
				if (candy[i - 1] > 1) {
					candy[i] = 1;
					max += candy[i];
				} else {
					candy[i] = 1;
					max++;
					for (int j = i - 1; j >= 0 && ratings[j] > ratings[j + 1]
							&& candy[j] == candy[j + 1]; j--) {
						candy[j]++;
						max++;
					}
				}
			}
		}
		return max;
	}
	
	public int candy3(int[] A){
		assert(A.length > 0);
		int[] f = new int[A.length];
		f[0] = 1;
		for(int i = 1, j = 0; i < A.length; i++, j++){
			if(A[j] > A[i]){
				f[i] = 1;
				for(int k = j; k >= 0 && A[k] > A[k + 1] && f[k] == f[k + 1]; k--) f[k] = f[k + 1] + 1;
			}else if(A[i] == A[j]){
				f[i] = 1;
			}else{
				f[i] = f[j] + 1;
			}
		}
		int ans = 0;
		for(int e : f) ans += e;
		return ans;
	}
	
	public int candy4(int[] A){
		assert(A.length > 0);
		int[] f = new int[A.length];
		int ans = 0;
		for(int i = 0; i < A.length; i++) ans += solve(f, i, A);
		return ans;
	}

	private int solve(int[] f, int i, int[] A) {
		if(f[i] == 0){
			f[i] = 1;
			if(i > 0 && A[i] > A[i - 1]) f[i] = Math.max(f[i], solve(f, i - 1, A) + 1);
			if(i < A.length - 1 && A[i] > A[i + 1]) f[i] = Math.max(f[i], solve(f, i + 1, A) + 1);
		}
		return f[i];
	}
	
	
}
