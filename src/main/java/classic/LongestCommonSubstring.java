package classic;

public class LongestCommonSubstring {
	
	public static void main(String[] args) {
		LongestCommonSubstring lcs = new LongestCommonSubstring();
		System.out.println(lcs.longestSubstring("abcccck", "ccck"));
		System.out.println(lcs.longestSubstring2("abcccck", "ccck"));
	}
	
	public String longestSubstring(String s, String t){
		int slen = s.length(), tlen = t.length();
		if(slen == 0 || tlen == 0) return "";
		
		int max = 0;
		String res = "";
		for(int i = 0; i < tlen - max; i++){
			String tmp = t.substring(i);
			int len = kmp(s, tmp);
			if(len > max){
				max = len;
				res = tmp.substring(0, len);
			}
		}
		return res;
	}
	
	public int kmp(String s, String t){
		int slen = s.length(), tlen = t.length();
		if(tlen == 0) return 0;

		int res = 0;
		int[] P = preProcess(t);
		
		int j = -1;
		for(int i = 0; i < slen; i++){
			while(j != -1 && t.charAt(j + 1) != s.charAt(i)) j = P[j];
			if(t.charAt(j + 1) == s.charAt(i)) j++;
			if(j + 1 > res){
				res = j + 1;
			}
		}
		return res;
	}

	private int[] preProcess(String t) {
		int len = t.length();
		int[] res = new int[len];
		
		int j = -1;
		res[0] = -1;
		for(int i = 1; i < len; i++){
			while(j != -1 && t.charAt(j + 1) != t.charAt(i)) j = res[j];
			if(t.charAt(j + 1) == t.charAt(i)) j++;
			res[i] = j;
		}
		return res;
	}
	
	public String longestSubstring2(String s, String t){
		int slen = s.length(), tlen = t.length();
		if(slen == 0 || tlen == 0) return "";
		
		int[][] mat = new int[slen][tlen];
		
		for(int i = 0; i < slen; i++){
			mat[i][0] = s.charAt(i) == t.charAt(0) ? 1:0;
		}
		
		for(int j = 0; j < tlen; j++){
			mat[0][j] = s.charAt(0) == t.charAt(j) ? 1:0;
		}
		
		for(int i = 1; i < slen; i++){
			for(int j = 1; j < tlen; j++){
				mat[i][j] = (s.charAt(i) == t.charAt(j)) ? (mat[i - 1][j - 1] + 1) : 0;
			}
		}
		
		int end = 0, max = 0;
		for(int i = 0; i < slen; i++){
			for(int j = 0; j < tlen; j++){
				if(mat[i][j] > max){
					max = mat[i][j];
					end = i;
				}
			}
		}
		
		return s.substring(end - max + 1, end + 1);
	}
}
