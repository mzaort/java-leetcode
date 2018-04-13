package interview2016;

public class BitwiseANDofNumbersRange {
	
	public static void main(String[] args) {
		BitwiseANDofNumbersRange banr = new BitwiseANDofNumbersRange();
		int i = banr.rangeBitwiseAnd(1, 3);
		System.out.println(i);
	}
	
    public int rangeBitwiseAnd(int m, int n) {
    	assert(0 <= m && m <= n && n <= Integer.MAX_VALUE);
        int res = 0;
        for(int i = Integer.SIZE - 2, j = (1 << i); i >= 0; i--, j >>>= 1){
        	if((m & j) == 0){
        		if((n & j) == 0){
        			continue;
        		}else{
        			break;
        		}
        	}else{
        		if((n & j) == 0){
        			break;
        		}else{
        			res += j;
        		}
        	}
        }
        return res;
    }
}
