package googleCode;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

	private boolean isMatch(String s, int sfrm, String p, int pfrm) {
		if(s.length() == sfrm){
			for (; pfrm < p.length() && p.charAt(pfrm) == '*'; pfrm++);
			return pfrm == p.length();
		}
		if (p.length() == pfrm)	return false;

		char pch = p.charAt(pfrm), sch = s.charAt(sfrm);
		if (pch == '*') {
			for (; pfrm < p.length() && p.charAt(pfrm) == '*'; pfrm++);
			int i = sfrm;
			for (; i <= s.length() && !isMatch(s, i, p, pfrm); i++);
			return i <= s.length();
		} else if (pch == '?') {
			return isMatch(s, sfrm + 1, p, pfrm + 1);
		} else {
			return pch == sch && isMatch(s, sfrm + 1, p, pfrm + 1);
		}
	}
	
	public boolean isMatch2(String s, String p) {
        int slen = s.length(), plen = p.length();
        boolean[][] f = new boolean[slen + 1][plen + 1];
        for(int i = 0; i < slen; i++) f[i][plen] = false;
        int k = plen - 1;
        for(; k >= 0 && p.charAt(k) == '*'; k--);
        for(int i = 0; i <= k; i++) f[slen][i] = false;
        for(int j = k + 1; j <= plen; j++) f[slen][j] = true;
        for(int i = slen - 1; i >= 0; i--){
        	for(int j = plen - 1; j >= 0; j--){
        		char sch = s.charAt(i), pch = p.charAt(j);
        		if(pch == '*'){
        			int h = j;
        			for(; h < plen && p.charAt(h) == '*'; h++);
        			int cur = i;
        			for(; cur <= slen && !f[cur][h]; cur++);
        			f[i][j] = cur <= slen;
        		}else if(pch == '?'){
        			f[i][j] = f[i + 1][j + 1];
        		}else{
        			f[i][j] = sch == pch && f[i + 1][j + 1];
        		}
        	}
        }
        return f[0][0];
    }
	
	public boolean isMatch3(String s, String p){
		int last = -1, iNext = -1;
		int i = 0, j = 0;
		while(i < s.length()){
			while(j < p.length() && p.charAt(j) == '*'){
				last = j++;
				iNext = i;
			}
			if(j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))){
				i++;
				j++;
			}else{
				if(last == -1) return false;
				j = last + 1;
				i = ++iNext;
			}
		}
		for(; j < p.length() && p.charAt(j) == '*'; j++);
		return j == p.length();
	}
}
