package solution;

public class InterleavingString {
	public static void main(String[] args) {
		InterleavingString is = new InterleavingString();
		//System.out.println(is.isInterleave2("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
		System.out.println(is.isInterleave("a","","c"));
		System.out.println(is.isInterleave2("a","","c"));
		
		System.out.println(is.isInterleave("aacaac", "aacaaeaac", "aacaaeaaeaacaac"));
		System.out.println(is.isInterleave2("aacaac", "aacaaeaac", "aacaaeaaeaacaac"));
	}
	public boolean isInterleave(String s1, String s2, String s3) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		return isInterleave(s1.toCharArray(), 0, s2.toCharArray(), 0,
				s3.toCharArray(), 0);
	}

	private boolean isInterleave(char[] s1, int i, char[] s2, int j, char[] s3,
			int k) {
		if(s1.length == i){
			if(s2.length == j){
				return s3.length == k;
			}else{
				for(; j < s2.length && k < s3.length; j++, k++){
					if(s2[j] != s3[k]) return false;
				}
				return j == s2.length && k == s3.length;
			}
		}else{
			if(s2.length == j){
				for(; i < s1.length && k < s3.length; i++, k++){
					if(s1[i] != s3[k]) return false;
				}
				return i == s1.length && k == s3.length;
			}else{
				if (s1[i] == s3[k]) {
					if (s2[j] == s3[k]) {
						return isInterleave(s1, i + 1, s2, j, s3, k + 1) || isInterleave(s1, i , s2, j + 1, s3, k + 1);
					} else {
						return isInterleave(s1, i + 1, s2, j, s3, k + 1);
					}
				} else {
					if (s2[j] == s3[k]) {
						return isInterleave(s1, i, s2, j + 1, s3, k + 1);
					} else {
						return false;
					}
				}
			}
		}
	}
	
	public boolean isInterleave2(String s1, String s2, String s3) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
		if (len1 + len2 != len3) {
			return false;
		}

		boolean[][] hit = new boolean[len1 + 1][len2 + 1];
		hit[0][0] = true;
		for(int i = 1; i <= len1; i++) hit[i][0] = hit[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
		for(int j = 1; j <= len2; j++) hit[0][j] = hit[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
		
		for(int i = 1; i <= len1; i++){
			for(int j = 1; j <= len2; j++){
				hit[i][j] =  (hit[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j  - 1)) || (hit[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j  - 1));
			}
		}
		
		return hit[len1][len2];
	}
}
