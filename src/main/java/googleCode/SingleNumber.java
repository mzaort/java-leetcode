package googleCode;

public class SingleNumber {
    public int singleNumber(int[] A) {
        int res = 0;
        for(int e : A) res ^= e;
        return res;
    }
}
