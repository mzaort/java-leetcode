package interview2015;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int res = s.length() == 0 ? 0 : 1;
		int[] f = new int[s.length()];
		for(int i = 1; i < s.length(); i++){
			int j = i - 1;
			for(; j >= f[i - 1] && s.charAt(j) != s.charAt(i); j--);
			f[i] = j + 1;
			res = Math.max(res, i - f[i] + 1);
		}
		return res;
	}
	
	public int lengthOfLongestSubstring2(String s){
		int res = 0;
		int left = -1;
		int[] map = new int[256];
		Arrays.fill(map, -1);
		for(int i = 0; i < s.length(); i++){
			char index = s.charAt(i);
			left = Math.max(left, map[index]);
			res = Math.max(res, i - left);
			map[index] = i;
		}
		return res;
	}
}
