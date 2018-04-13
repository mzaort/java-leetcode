package microsoft;

public class CountingZero {
	public static void main(String[] args) {
		CountingZero co = new CountingZero();
		for(int i = 1; i < 10000; i++){
			int v1 = co.count(i), v2 = co.countLog(i);
			if(v1 != v2){
				System.out.println(i + " " + v1 + " " + v2);
				break;
			}
		}
		
//		BigInteger b = new BigInteger("12", 3);
//		BigInteger c = new BigInteger("20", 3);
//		System.out.println(b.toString() + " " + c.toString() + " " + new BigInteger("1010", 3).toString());
//		BigInteger d = b.multiply(c);
//		System.out.println(d.toString(3));
	}
	
	public int count(int n){
		int ans = 0;
		for(int i = 0; i <= n; i++) ans += count0(i);
		return ans;
	}

	private int count0(int n) {
		if(n == 0) return 1;
		int ans = 0;
		for(; n != 0; n /= 10) if(n % 10 == 0) ans++;
		return ans;
	}
	
	public int countLog(int v){
		if(v < 10) return 1;
		int ans = 0;
		for(int i = 0, j = 1, n = v; n != 0; i++, n /= 10, j *= 10){
			int x = n % 10;
			if(n < 10){
				int sum = i * j / 10;
				for(int k = 1, h = 9; k < i; k++, h *= 10) sum -= (i - k) * h;
				ans += sum - (i - 1);
				ans += (x - 1) * i * j / 10;
			}else{
				if(x > 0) ans += x * i * j / 10;
				if(x > 0) ans += j;
				else if(x == 0) ans += v % j + 1;
			}
		}
		return ans;
	}
}
