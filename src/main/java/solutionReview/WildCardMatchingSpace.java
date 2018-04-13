package solutionReview;

public class WildCardMatchingSpace {
	public static void main(String[] args) {
		WildCardMatchingSpace wm = new WildCardMatchingSpace();
		System.out.println(wm.isMatch("John Smith", "J*S*"));
	}
	
	public boolean isMatch(String s, String p) {
		int slen = s.length();
		int plen = p.length();

		int i = 0, j = 0;
		int star = -1, sp = -1;

		while (i < slen) {
			while (j < plen && p.charAt(j) == '*') {
				star = j++;
				sp = i;
			}
			char sch = s.charAt(i);
			if (j == plen
					|| (Character.isLetter(p.charAt(j)) && ((Character
							.isLetter(sch) && sch != p.charAt(j)) || sch == ' '))
					|| (p.charAt(j) == '?' && s.charAt(i) == ' ')
					|| (p.charAt(j) == ' ' && Character.isLetter(s.charAt(i)))) {
				if (star == -1) {
					return false;
				} else {
					j = star + 1;
					if (sp < slen && s.charAt(sp) == ' ') {
						return false;
					}
					i = ++sp;
				}
			} else {
				i++;
				j++;
			}
		}
		return j == plen;
	}
}
