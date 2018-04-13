package solution;

public class LongestPalindromicSubstring {
	
	public static void main(String[] args) {
		String s = "ccc";
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome3(s));
	}
	
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        if(len <= 1) return s;
        
        boolean[][] flag = new boolean[len][len];
        for(int i = 0; i < len; i++){
        	flag[i][i] = true;
        }
        for(int i = 0; i < len - 1; i++){
        	flag[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        
        for(int gap = 2; gap < len; gap++){
        	for(int i = 0; i < len - gap; i++){
        		flag[i][i + gap] = (s.charAt(i) == s.charAt(i + gap)) && flag[i + 1][i + gap - 1];
        	}
        }
        
        for(int gap = len - 1; gap >= 0; gap--){
        	for(int i = 0; i < len - gap; i++){
        		if(flag[i][i + gap]){
        			return s.substring(i, i + gap + 1);
        		}
        	}
        }
        
        return "";
    }
    
    public String longestPalindrome2(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        if(len <= 1) return s;
        
        String res = "";
        
        for(int i = 0; i < len; i++){
        	String tmp = expandPalindrome(s, i, i);
        	if(tmp.length() > res.length()){
        		res = tmp;
        	}
        }
        
        for(int i = 0; i < len - 1; i++){
        	String tmp = expandPalindrome(s, i, i + 1);
        	if(tmp.length() > res.length()){
        		res = tmp;
        	}
        }
        
        return res;
    }

	private String expandPalindrome(String s, int frm, int end) {
		for(; frm >= 0 && end < s.length() && s.charAt(frm) == s.charAt(end); frm--, end++);
		return s.substring(frm + 1, end);
	}
	
	public String longestPalindrome3(String s){
		int slen = s.length();
		if(slen <= 1) return s;
		
		StringBuilder sb = new StringBuilder("^#");
		for(int i = 0; i < slen; i++){
			sb.append(s.charAt(i)).append("#");
		}
		sb.append("$");
		
		int sblen = sb.length();
		int[] radix = new int[sblen];
		int center = 0, right = 0;
		for(int i = 1; i < sblen - 1; i++){
			if(i > right){
				radix[i] = 0;
			}else{
				radix[i] = right - i > radix[2 * center - i]?radix[2 * center - i]:right - i;
			}
			while(sb.charAt(i + radix[i] + 1) == sb.charAt(i - radix[i] - 1)) radix[i]++;
			if(radix[i] + i > right){
				center = i;
				right = radix[i] + i;
			}
		}
		
		int max = radix[1];
		int maxI = 1;
		for(int i = 2; i < sblen - 1; i++){
			if(radix[i] > max){
				max = radix[i];
				maxI = i;
			}
		}
		
		maxI = (maxI - max - 1)/2;
		return s.substring(maxI, maxI + max);
	}
}
