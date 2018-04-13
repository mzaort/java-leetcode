package googleCode;

public class HouseRobber {
    public int rob(int[] num) {
        int L = num.length;
        if(L == 0) return 0;
        int[] f = new int[L];
        int[] g = new int[L];
        for(int i = 0; i < L; i++){
        	g[i] = num[i] + (i - 2 >= 0 ? f[i - 2] : 0);
        	f[i] = Math.max(g[i], i - 1 >= 0 ? f[i - 1] : 0);
        }
        return f[L - 1];
    }
}
