package interview2015Summer;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s){
		String res = "";
		for(int i = 0; i < s.length(); i++){
			String str = expand(s, i, i);
			if(str.length() > res.length()) res = str;
		}
		for(int i = 0, j = i + 1; j < s.length(); i++, j++){
			String str = expand(s, i, j);
			if(str.length() > res.length()) res = str;
		}
		return res;
	}

	private String expand(String s, int i, int j) {
		for(; i >= 0 && j < s.length() && s.charAt(j) == s.charAt(i); i--, j++);
		return s.substring(i + 1, j);
	}
}
