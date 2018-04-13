package googleCode;

public class RegularExpressionMatching {
	public static void main(String[] args) {
		RegularExpressionMatching rem = new RegularExpressionMatching();
		System.out.println(rem.isMatch2("aab", "b.*"));
	}
	
    public boolean isMatch(String s, String p) {
    	return isMatch(s, 0, p, 0);
    }

	private boolean isMatch(String s, int sfrm, String p, int pfrm) {
		if(sfrm == s.length()){
			for(; pfrm + 1 < p.length() && p.charAt(pfrm) != '*' && p.charAt(pfrm + 1) == '*'; pfrm += 2);
			return pfrm == p.length();
		}
		if(pfrm == p.length()) return false;
		
		char sch = s.charAt(sfrm), pch = p.charAt(pfrm);
		if(pfrm + 1 == p.length()) return sfrm + 1 == s.length() && (pch == '.' || pch == sch);
		char pchn = p.charAt(pfrm + 1);
		
		if(pchn == '*'){
			int cnt = 0;
			for(int i = sfrm; i < s.length() && s.charAt(i) == pch; i++, cnt++);
			if(pch == '.') cnt = s.length() - sfrm;
			for(int i = 0; i <= cnt; i++){
				if(isMatch(s, sfrm + i, p, pfrm + 2)) return true;
			}
			return false;
		}else{
			return (pch == '.' || pch == sch) && isMatch(s, sfrm + 1, p, pfrm + 1);
		}
	}
	
	public boolean isMatch2(String s, String p) {
    	Boolean[][] f = new Boolean[s.length() + 1][p.length() + 1];
    	return isMatch2(f, s, s.length(), p, p.length());
    }

	private boolean isMatch2(Boolean[][] f, String s, int slen, String p,
			int plen) {
		if(f[slen][plen] == null){
			if(slen == 0){
				for(; plen - 2 >= 0 && p.charAt(plen - 1) == '*' && p.charAt(plen - 2) != '*'; plen -=2);
				f[slen][plen] = plen == 0;
			}else if(plen == 0){
				f[slen][plen] = false;
			}else{
				char sch = s.charAt(slen - 1), pch = p.charAt(plen - 1);
				if(pch == '*'){
					//all p is legal;
					char pchf = p.charAt(plen - 2);
					int cnt = 0;
					for(int i = slen - 1; i >= 0 && s.charAt(i) == pchf; i--, cnt++);
					if(pchf == '.') cnt = slen;
					for(; cnt >= 0 && !isMatch2(f, s, slen - cnt, p, plen - 2); cnt--);
					f[slen][plen] = cnt >= 0;
				}else{
					f[slen][plen] = (pch == '.' || pch == sch) && isMatch2(f, s, slen - 1, p, plen - 1);
				}
			}
		}
		return f[slen][plen];
	}
	
	public boolean isMatch3(String s, String p){
		return f(new Boolean[s.length() + 1][p.length() + 1], s.length(), p.length(), s, p);
	}

	private boolean f(Boolean[][] v, int i, int j, String s,
			String p) {
		if(v[i][j] == null){
			if(j == 0){
				v[i][j] = i == 0;
			}else if(i == 0){
				for(; j >= 2 && p.charAt(j - 1) == '*' && p.charAt(j - 2) != '*'; j -= 2);
				return v[i][j] = j == 0;
			}else{
				char sch = s.charAt(i - 1), pch = p.charAt(j - 1);
				if(pch == '*'){
					assert(j >= 2);
					char pchp = p.charAt(j - 2);
					int k = pchp == '.' ? -1 : i - 1;
					for(; k >= 0 && s.charAt(k) == pchp; k--);
					for(k++; k <= i && !f(v, k, j - 2, s, p); k++);
					v[i][j] = k <= i;
				}else if(pch == '.'){
					v[i][j] = f(v, i - 1, j - 1, s, p);
				}else{
					v[i][j] = sch == pch && f(v, i - 1, j - 1, s, p);
				}
			}
		}
		return v[i][j];
	}
	
}
