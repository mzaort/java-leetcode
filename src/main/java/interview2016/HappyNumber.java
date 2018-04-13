package interview2016;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		while(n != 1 && !set.contains(n)){
			set.add(n);
			n = next(String.valueOf(n));
		}
		return n == 1;
	}

	private int next(String s) {
		int res = 0;
		for(int i = 0; i < s.length(); i++){
			int v = s.charAt(i) - '0';
			res += v * v;
		}
		return res;
	}
}
