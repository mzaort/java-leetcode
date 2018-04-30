package solution;

public class ValidPalindrome {
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome(
				".;7QeZh Gs:1\"?OU!rx'vm5xX17t8`'KuP:eqBw,: dt7 8d1'E'RrZ D`?2,50a28Fym`iu9v9y`d5:ZN1WQ\"5e:'Q1,a1rE':75;u0L;X.lP444R!g'BoW0x;`ID0,Ry3U2Lfz;0!U.;k: R:\"p!udZ'c,BNXi WY\"kkE`L `WNW` L`Ekk\"YW iXNB,c'Zdu!p\":R :k;.U!0;zfL2U3yR,0DI`;x0WoB'g!R444Pl.X;L0u;57:'Er1a,1Q':e5\"QW1NZ:5d`y9v9ui`myF82a05,2?`D ZrR'E'1d8 7td;:,wBqe:PuK'`8t71Xx5mv'xr!UO?\"1:sG hZeQ7 ."));
	}

	public boolean isPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = s.length();
		if (len <= 1) return true;

		int frm = 0, end = len - 1;
		do {
			char cfrm = 0, cend = 0;
			while (frm <= end) {
				cfrm = s.charAt(frm);
				if ((cfrm >= '0' && cfrm <= '9') || (cfrm >= 'a' && cfrm <= 'z') || (cfrm >= 'A' && cfrm <= 'Z')) {
					break;
				}
				frm++;
			}
			while (frm <= end) {
				cend = s.charAt(end);
				if ((cend >= '0' && cend <= '9') || (cend >= 'a' && cend <= 'z') || (cend >= 'A' && cend <= 'Z')) {
					break;
				}
				end--;
			}
			if (frm <= end) {
				if (cend >= 'a' && cend <= 'z') cend += 'A' - 'a';
				if (cfrm >= 'a' && cfrm <= 'z') cfrm += 'A' - 'a';
				if (cfrm != cend) { return false; }
			}
			frm++;
			end--;
		} while (frm <= end);
		return true;
	}
}
