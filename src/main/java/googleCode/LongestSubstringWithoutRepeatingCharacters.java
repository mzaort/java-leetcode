package googleCode;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if(s.length() < 2) return s.length();
		
		int[] f = new int[s.length()];
		f[0] = 0;
		for(int i = 1; i < s.length(); i++){
			int cur = i - 1;
			for(; cur >= f[i - 1] && s.charAt(i) != s.charAt(cur); cur--);
			f[i] = cur + 1;
		}
		
		int res = 0;		
		for(int i = s.length() - 1; i >= 0; i--){
			if(res < i - f[i] + 1) res = i - f[i] + 1;
		}
		return res;
	}
	
	public int lengthOfLongestSubstring2(String s) {
		int res = 0;		
		int left = 0;
		for(int i = 0; i < s.length(); i++){
			int cur = i - 1;
			for(; cur >= left && s.charAt(i) != s.charAt(cur); cur--);
			if(i - cur > res) res = i - cur;
			left = cur + 1;
		}
		return res;
	}
	
	public int lengthOfLongestSubstring3(String s) {
		int[] map = new int[256];
		Arrays.fill(map, -1);
		
		int res = 0;		
		int left = 0;
		for(int i = 0; i < s.length(); i++){
			if(map[s.charAt(i)] >= left) left = map[s.charAt(i)] + 1;
			if(res < i - left + 1) res = i - left + 1;
			map[s.charAt(i)] = i;
		}
		return res;
	}
}
