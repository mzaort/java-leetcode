package solutionReview2;
public class RegularExpressionMatching{
	public boolean isMatch(String s, String p){
		return isMatch(s, 0, p, 0);
	}
	public boolean isMatch(String s, int sfrm, String p, int pfrm){
		int slen = s.length();
		int plen = p.length();
		
		if(sfrm == slen){
			for(; pfrm < plen - 1 && p.charAt(pfrm) != '*' && p.charAt(pfrm + 1) == '*'; pfrm += 2);
			return pfrm == plen;
		}
		if(pfrm == plen) return false;
		
		
		char sch = s.charAt(sfrm);
		char pch = p.charAt(pfrm);

		if(pch == '*') return false;

		if(pfrm == plen - 1){
			return sfrm == slen - 1 && (pch == '.' || pch == sch);
		}

		char pchn = p.charAt(pfrm + 1);
		if(pchn == '*'){
			int j = sfrm;
			for(; j < slen && (pch == '.' || pch == s.charAt(j)); j++);
			for(; sfrm <= j; sfrm++){
				if(isMatch(s, sfrm, p, pfrm + 2)){
					return true;
				}
			}
			return false;
		}else{
			return (pch == '.' || pch == sch) && isMatch(s, sfrm + 1, p, pfrm + 1);
		}

	}
}