package solution;

public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		String[] strs = {"12", "1"};
		
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		System.out.println(lcp.longestCommonPrefix(strs));
	}
	
	public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int num = strs.length;
		if(num == 0){
			return "";
		}else if(num == 1){
			return strs[0];
		}
		
		int maxLength = Integer.MAX_VALUE;
		
		for(String s : strs){
			if(s.length() < maxLength){
				maxLength = s.length();
			}
		}
		
		for(int i = 0; i < num - 1; i++){
			maxLength = longestCommonPrefix(strs[i], strs[i+1], maxLength);
		}
		
		return strs[0].substring(0, maxLength);
    }
	
	private int longestCommonPrefix(String s1, String s2, int maxLength) {
		for(int i = 0; i < maxLength; i++){
			if(s1.charAt(i) != s2.charAt(i)){
				return i;
			}
		}
		return maxLength;
	}
}
