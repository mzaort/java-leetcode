package googleCode;

public class ReverseBits {
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 0; i < Integer.SIZE; i++, n >>>= 1) ans = (ans << 1) + (n & 1);
        return ans;
    }
    
    public int reverseBits2(int n) {
        int ans = 0;
        for(int i = 0, j = Integer.SIZE - 1; i < j; i++, j--){
        	int iv = (n >> i) & 1;
        	int jv = (n >> j) & 1;
        	if(iv != jv){
        		n ^= (1 << i) | (1 << j);
        	}
        }
        return ans;
    }
}
