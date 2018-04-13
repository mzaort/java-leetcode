package googleCode;

public class SingleNumberII {
    public int singleNumber(int[] A) {
    	int MAX = Integer.SIZE;
    	int[] cnt = new int[MAX];
    	for(int e : A){
    		for(int i = MAX - 1, val = e; i >= 0; i--, val >>>= 1) cnt[i] += val & 1;
    	}
    	int res = 0;
    	for(int e : cnt) res = (res << 1) + e % 3;
    	return res;
    }
}
