package googleCode;

public class PermutationSequence {
	public static void main(String[] args) {
		PermutationSequence ps = new PermutationSequence();
		System.out.println(ps.getPermutation(3, 3));
	}
	
    public String getPermutation(int n, int k) {
    	assert(n >= 1 && n <= 9 && k > 0);
    	int[] num = new int[n + 1];
    	num[0] = 1;
    	for(int i = 1; i <= n; i++) num[i] = i * num[i - 1];
    	assert(k <= num[n]);
    	k--;
    	
    	int[] m = new int[n];
    	for(int i = 0, j = n - 1; i < m.length; i++, j--){
    		m[i] = k / num[j];
    		k = k % num[j];
    	}
    	
    	int[] cnt = new int[n + 1];
    	for(int i = 0; i < cnt.length; i++) cnt[i] = i - 1;
    	int[] res = new int[n];
    	for(int i = 0; i < res.length; i++){
    		int j = m[i] + 1;
    		for(; cnt[j] != m[i]; j++);
    		res[i] = j;
    		cnt[j] = -1;
    		for(j++; j < cnt.length; j++) cnt[j]--;
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int e : res) sb.append(e);
    	return new String(sb);    	
    }
}
