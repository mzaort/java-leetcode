package solutionReview;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		RegularExpressionMatching rem = new RegularExpressionMatching();
		System.out.println(rem.isMatch4("bbcaacbccbbbbbabb", "b*b*a*aba*c"));
	}

	public boolean isMatch(String s, String p) {
		return isMatch(s, 0, s.length(), p, 0, p.length());
	}

	private boolean isMatch(String s, int i, int slen, String p, int j, int plen) {
		if (i == slen) {
			if (j == plen) {
				return true;
			} else {
				for (; j < plen - 1 && p.charAt(j) != '*'
						&& p.charAt(j + 1) == '*'; j += 2)
					;
				return j == plen;
			}
		} else {
			if (j == plen) {
				return false;
			} else {
				char sch = s.charAt(i);
				char pch = p.charAt(j);
				if (j + 1 == plen) {
					return (i + 1 == slen) && (pch == '.' || pch == sch);
				} else {
					char pchn = p.charAt(j + 1);
					if (pchn == '*') {
						if (pch == '.' || pch == sch) {
							return isMatch(s, i, slen, p, j + 2, plen)
									|| isMatch(s, i + 1, slen, p, j, plen);
						} else {
							return isMatch(s, i, slen, p, j + 2, plen);
						}
					} else {
						if (pch == '.' || pch == sch) {
							return isMatch(s, i + 1, slen, p, j + 1, plen);
						} else {
							return false;
						}
					}
				}
			}
		}
	}

	public boolean isMatch2(String s, String p) {
		return isMatch2(s, 0, p, 0);
	}

	private boolean isMatch2(String s, int i, String p, int j) {
		if (j == p.length()) {
			return i == s.length();
		}

		if (i == s.length()) {
			for (; j < p.length() - 1 && p.charAt(j) != '*'
					&& p.charAt(j + 1) == '*'; j += 2)
				;
			return j == p.length();
		}

		char sch = s.charAt(i);
		char pch = p.charAt(j);

		if (j == p.length() - 1) {
			return (i == s.length() - 1) && (pch == '.' || pch == sch);
		}

		char pchn = p.charAt(j + 1);
		if (pchn == '*') {
			if (pch == '.' || pch == sch) {
				return isMatch2(s, i, p, j + 2) || isMatch2(s, i + 1, p, j);
			} else {
				return isMatch2(s, i, p, j + 2);
			}
		} else {
			if (pch == '.' || pch == sch) {
				return isMatch2(s, i + 1, p, j + 1);
			} else {
				return false;
			}
		}
	}
	
	public boolean isMatch3(String s, String p){
		return isMatch3(s, 0, p, 0);
	}
	
	private boolean isMatch3(String s, int i, String p, int j) {
		if (j == p.length()) {
			return i == s.length();
		}

		if (i == s.length()) {
			for (; j < p.length() - 1 && p.charAt(j) != '*'
					&& p.charAt(j + 1) == '*'; j += 2)
				;
			return j == p.length();
		}

		char sch = s.charAt(i);
		char pch = p.charAt(j);

		if (j == p.length() - 1) {
			return (i == s.length() - 1) && (pch == '.' || pch == sch);
		}

		char pchn = p.charAt(j + 1);
		if (pchn == '*') {
			int cnt = 0;
			if(pch == '.'){
				cnt = s.length() - i;
			}else{
				for(int k = i; k < s.length() && s.charAt(k) == pch; k++, cnt++);
			}
			for(int k = cnt; k >= 0; k--){
				if(isMatch3(s, i + k, p, j + 2)){
					return true;
				}
			}
			return false;
		} else {
			if (pch == '.' || pch == sch) {
				return isMatch3(s, i + 1, p, j + 1);
			} else {
				return false;
			}
		}
	}
	
	public boolean isMatch4(String s, String p){
		int slen = s.length();
		int plen = p.length();

		boolean[][] mat = new boolean[slen + 1][plen + 1];
		mat[0][0] = true;
		for(int i = 1; i <= slen; i++){
			mat[i][0] = false;
		}

		int cur = 0;
		for(; cur < plen - 1 && p.charAt(cur) != '*' && p.charAt(cur + 1) == '*'; cur += 2);
		for(int j = 1; j < cur + 1; j += 2){
			mat[0][j] = false;
		}
		for(int j = 2; j < cur + 1; j += 2){
			mat[0][j] = true;
		}
		for(int j = cur + 1; j <= plen; j++){
			mat[0][j] = false;
		}

		for(int i = 1; i <= slen; i++){
			for(int j = 1; j <= plen; j++){
				char pch = p.charAt(j - 1);
				if(pch == '*'){
					char pchf = p.charAt(j - 2);
					mat[i][j] = mat[i][j - 2];
					if(pchf == '.'){
						for(int k = i - 1; !mat[i][j] && k >= 0; k--){
							mat[i][j] = mat[i][j] || mat[k][j - 2];
						}
					}else{
						for(int k = i - 1; !mat[i][j] && k >= 0 && s.charAt(k) == pchf; k--){
							mat[i][j] = mat[i][j] || mat[k][j - 2];
						}
					}					
				}else if(pch == '.'){
					mat[i][j] = mat[i - 1][j - 1];
				}else{
					mat[i][j] = mat[i - 1][j - 1] && (s.charAt(i - 1) == pch);
				}
			}
		}
		return mat[slen][plen];
	}
}