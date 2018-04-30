package interview2018;

import java.util.ArrayList;
import java.util.List;

public class BullsandCows {
	public String getHint(String secret, String guess) {
		if (secret.length() != guess.length()) return "";
		int length = secret.length();

		List<Character> slist = new ArrayList<>(length);
		List<Character> glist = new ArrayList<>(length);

		int bull = 0, cow = 0;
		for (int i = 0; i < length; i++) {
			char s = secret.charAt(i);
			char g = guess.charAt(i);
			if (s == g) bull++;
			else {
				slist.add(s);
				glist.add(g);
			}
		}
		slist.sort(Character::compare);
		glist.sort(Character::compare);

		int sfrm = 0, gfrm = 0;
		while (sfrm < slist.size() && gfrm < glist.size()) {
			char s = slist.get(sfrm);
			char g = glist.get(gfrm);
			if (s == g) {
				cow++;
				sfrm++;
				gfrm++;
			} else if (s < g) sfrm++;
			else gfrm++;
		}

		return String.format("%dA%dB", bull, cow);
	}
}
