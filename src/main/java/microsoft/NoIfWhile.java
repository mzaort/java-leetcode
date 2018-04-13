package microsoft;

public class NoIfWhile {
	public int f(int n){
		int fn_1 = 0;
		boolean f = n != 0 && (-1 == (fn_1 = f(n - 1)));
		return fn_1 + n;
	}
}
