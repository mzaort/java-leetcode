package solutionReview;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		if (len <= 1)
			return len;

		int[] f = new int[len];
		f[0] = 1;

		for (int i = 1; i < len; i++) {
			int j = i - 1;
			for (; j >= i - f[i - 1] && s.charAt(i) != s.charAt(j); j--)
				;
			f[i] = i - j;
		}

		int res = f[0];
		for (int i = 1; i < len; i++) {
			if (f[i] > res) {
				res = f[i];
			}
		}

		return res;
	}
	
	public int lengthOfLongestSubstring2(String s) {
		int len = s.length();
		if(len <= 1) return len;
		
		int[] previous = new int[256];
		for(int i = 0; i < 256; i++) previous[i] = -1;
		
		previous[s.charAt(0)] = 0;
		int head = 0;
		int res = 1;
		
		for(int i = 1; i < len; i++){
			int index = previous[s.charAt(i)];
			previous[s.charAt(i)] = i;
			if(index >= head){
				if(i - head > res) res = i - head;
				head = index + 1;
			}
		}
		if(len - head > res) res = len - head;
		return res;
	}
}