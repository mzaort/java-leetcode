package microsoft;

public class CountingOne {
	public static void main(String[] args) {
		CountingOne co = new CountingOne();
		for(int i = 100000; i < 100001; i++){
			int v1 = co.count(i), v2 = co.countLog(i);
			if(v1 != v2){
				System.out.println(i + " " + v1 + " " + v2);
				break;
			}
		}
	}
	
	public int count(int n){
		int ans = 0;
		for(int i = 0; i <= n; i++) ans += count1(i);
		return ans;
	}

	private int count1(int n) {
		int ans = 0;
		for(; n != 0; n /= 10) if(n % 10 == 1) ans++;
		return ans;
	}
	
	public int countLog(int v){
		int ans = 0;
		for(int i = 0, j = 1, n = v; n != 0; i++, n /= 10, j *= 10){
			int x = n % 10;
			if(x > 0) ans += x * i * j / 10;
			if(x > 1) ans += j;
			else if(x == 1) ans += v % j + 1;
		}
		return ans;
	}
}
