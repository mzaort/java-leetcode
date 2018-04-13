package solutionReview;


public class WildcardMatching {
	
	public static void main(String[] args) {
		WildcardMatching wm = new WildcardMatching();
		System.out.println(wm.isMatch("a", "*?*"));
		System.out.println(wm.isMatch2("a", "*?*"));
		System.out.println(wm.isMatch4("aaabbaabbaab", "*aabbaa*a*"));
		System.out.println(wm.isMatch4("ab", ".*"));
	}
	
	public boolean isMatch(String s, String p) {
		return isMatch(s, 0, p, 0);
	}

	public boolean isMatch(String s, int sfrm, String p, int pfrm) {
		if (sfrm == s.length()) {
			for (; pfrm < p.length() && p.charAt(pfrm) == '*'; pfrm++)
				;
			return pfrm == p.length();
		} else if (pfrm == p.length()) {
			return false;
		} else {
			char sch = s.charAt(sfrm);
			char pch = p.charAt(pfrm);
			if (pch == '*') {
				for (; pfrm < p.length() && p.charAt(pfrm) == '*'; pfrm++)
					;
				if (pfrm == p.length()) {
					return true;
				} else {
					return isMatch(s, sfrm, p, pfrm)
							|| isMatch(s, sfrm + 1, p, pfrm - 1);
				}
			} else if (pch == '?') {
				return isMatch(s, sfrm + 1, p, pfrm + 1);
			} else {
				if (pch == sch) {
					return isMatch(s, sfrm + 1, p, pfrm + 1);
				} else {
					return false;
				}
			}
		}
	}

	public boolean isMatch2(String s, String p) {
		int slen = s.length();
		int plen = p.length();

		boolean[][] mat = new boolean[slen + 1][plen + 1];

		//
		for (int i = 1; i <= slen; i++) {
			mat[i][0] = false;
		}
		mat[0][0] = true;
		for (int j = 1; j <= plen; j++) {
			mat[0][j] = mat[0][j - 1] && (p.charAt(j - 1) == '*');
		}

		for (int i = 1; i <= slen; i++) {
			for (int j = 1; j <= plen; j++) {
				char pch = p.charAt(j - 1);
				if (pch == '*') {
					int k = i;
					for (; k >= 0 && mat[k][j - 1] == false; k--)
						;
					mat[i][j] = (k >= 0);
				} else if (pch == '?') {
					mat[i][j] = mat[i - 1][j - 1];
				} else {
					mat[i][j] = mat[i - 1][j - 1] && (pch == s.charAt(i - 1));
				}
			}
		}
		return mat[slen][plen];
	}

	public boolean isMatch3(String s, String p) {
		int slen = s.length();
		int plen = p.length();

		int star = -1;
		int back = -1;

		int scur = 0, pcur = 0;

		while (scur < slen) {
			if (pcur == plen) {
				if (star == -1) {
					return false;
				} else {
					scur = back;
					back++;
					pcur = star;
				}
			}
			char sch = s.charAt(scur);
			char pch = p.charAt(pcur);
			if (pch == '*') {
				for (; pcur < plen && p.charAt(pcur) == '*'; pcur++)
					;
				if (pcur == plen) {
					return true;
				} else {
					star = pcur;
					back = scur;
				}
			} else if (pch == '?') {
				scur++;
				pcur++;
			} else {
				if (sch == pch) {
					scur++;
					pcur++;
				} else {
					if (star == -1) {
						return false;
					} else {
						scur = back;
						back++;
						pcur = star;
					}
				}
			}
		}

		for (; pcur < plen && p.charAt(pcur) == '*'; pcur++)
			;
		return pcur == plen;

	}
	
	public boolean isMatch4(String s, String p){
		int slen = s.length();
		int plen = p.length();
		
		int i = 0, j = 0;
		int star = -1, sn = 0;
		
		while(i < slen){
			while(j < plen && p.charAt(j) == '*'){
				star = j++;
				sn = i;
			}
			
			if(j == plen || (p.charAt(j) != '?' && (p.charAt(j) != s.charAt(i)))){
				if(star == -1){
					return false;
				}else{
					i = ++sn;
					j = star + 1;
				}
			}else{
				i++;
				j++;
			}
		}
		
		for(; j < plen && p.charAt(j) == '*'; j++);
		return j == plen;
	}
}