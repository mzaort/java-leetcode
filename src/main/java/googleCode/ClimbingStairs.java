package googleCode;

public class ClimbingStairs {
	
	public static void main(String[] args) {
		ClimbingStairs cs = new ClimbingStairs();
		System.out.println(cs.climbStairs2(3));
	}
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        else return climbStairs(n - 1) + climbStairs(n - 2);
    }
    
    public int climbStairs2(int n) {
        assert(n >= 0);
        int[] f = new int[n + 1];
        f[0] = f[1] = 1;
        for(int i = 2; i <= n; i++) f[i] = f[i - 1] + f[i - 2];
        return f[n];
    }
    
    public int climbStairs3(int n) {
        assert(n >= 0);
        int fn_1 = 1, fn_2 = 1, fn = 1;
        for(int i = 2; i <= n; i++) {
        	fn = fn_1 + fn_2;
        	fn_2 = fn_1;
        	fn_1 = fn;
        }
        return fn;
    }
}
