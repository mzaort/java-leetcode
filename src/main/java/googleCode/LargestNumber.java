package googleCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LargestNumber {
	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
		int[] num = { 3, 30, 34, 5, 9 };
		List<Integer> list = Arrays.asList(1, 2, 3);
		System.out.println(Arrays.toString(num));
		System.out.println(Arrays.toString(list.toArray(new Integer[0])));
		System.out.println(ln.largestNumber(num));
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(2, 432);
		map.put(342, 32);
		System.out.println(map);
		map.values().clear();
		System.out.println(map);
		map.keySet().clear();
		System.out.println(map);
		System.out.println("a  b".split("\\s+").length);

	}

	public String largestNumber(int[] num) {
		assert (num.length > 0);
		String[] s = new String[num.length];
		for (int i = 0; i < num.length; i++)
			s[i] = String.valueOf(num[i]);
		Arrays.sort(s, (s1, s2) -> {
			String s12 = s1 + s2;
			String s21 = s2 + s1;
			int val = s12.compareTo(s21);
			return val == 0 ? -s1.length() + s2.length() : val;
		});
		StringBuilder sb = new StringBuilder();
		for (int i = s.length - 1; i >= 0; i--)
			sb.append(s[i]);
		int cur = 0;
		for (; cur < sb.length() && sb.charAt(cur) == '0'; cur++);
		return cur == sb.length() ? "0" : new String(sb.substring(cur));
	}

	public String largestNumber2(int[] num) {
		assert (num.length > 0);
		String[] s = new String[num.length];
		for (int i = 0; i < num.length; i++)
			s[i] = String.valueOf(num[i]);
		Arrays.sort(s, (s1, s2) -> -(s1 + s2).compareTo(s2 + s1));
		String sb = String.join("", s);
		int cur = 0;
		for (; cur < sb.length() && sb.charAt(cur) == '0'; cur++);
		return cur == sb.length() ? "0" : new String(sb.substring(cur));
	}
}
