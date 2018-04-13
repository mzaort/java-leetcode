package interview2015Summer;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p){
		return f(new Boolean[s.length() + 1][p.length() + 1], s.length(), p.length(), s, p);
	}

	private boolean f(Boolean[][] v, int i, int j, String s,
			String p) {
		if(v[i][j] == null){
			if(j == 0){
				v[i][j] = i == 0;
			}else if(i == 0){
				v[i][j] = j % 2 == 0 && p.charAt(j - 1) == '*' && f(v, i, j - 2, s, p);
			}else{
				char sch = s.charAt(i - 1), pch = p.charAt(j - 1);
				if(pch == '*'){
					assert(j >= 2);
					char pchf = p.charAt(j - 2);
					int cur = i - 1;
					for(; cur >= 0 && (pchf == '.' || pchf == s.charAt(cur)); cur--);
					for(cur++; cur <= i && !f(v, cur, j - 2, s, p); cur++);
					v[i][j] = cur <= i;
				}else{
					v[i][j] = (pch == '.' || pch == sch) && f(v, i - 1, j - 1, s, p);
				}
			}
		}
		return v[i][j];
	}
}
