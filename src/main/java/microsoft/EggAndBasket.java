package microsoft;

public class EggAndBasket {
	
	public static void main(String[] args) {
		EggAndBasket eb = new EggAndBasket();
		System.out.println(eb.dispatch(9, 5));
	}
	
	public int dispatch(int n, int m){
		assert (n >= m && m > 0);
		return dispatch(n, m, n);
	}

	//assure m > 0 && max > 0
	private int dispatch(int n, int m, int max) {
		if(max == 1) return n == m? 1:0;
		if(n < m) return 0;
		if(n == m) return 1;
		if(n > (1 << m) || n > m * max) return 0;
		
		
		if(max > n - m + 1) max = n - m + 1;
		
		int res = dispatch(n, m, max - 1);
		for(int i = 1; i < m && n - i * max >= max - 1; i++){
			res += dispatch(n - i * max, m - i, max - 1);
		}
		return res;
	}
}
