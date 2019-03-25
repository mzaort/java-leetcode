package interview2018;

public class BackspaceStringCompare {
	public boolean backspaceCompare(String S, String T) {
		int i = S.length() - 1;
		int j = T.length() - 1;
		while (i >= 0 && j >= 0) {
			i = erase(S, i);
			j = erase(T, j);
			if (i >= 0 && j >= 0) {
				if (S.charAt(i) == T.charAt(j)) {
					i--;
					j--;
				} else return false;
			}
		}
		return erase(S, i) < 0 && erase(T, j) < 0;
	}

	private int erase(String s, int i) {
		int count = 0;
		for (; i >= 0 && count >= 0; i--) {
			if (s.charAt(i) == '#') count++;
			else count--;
		}
		return count == -1 ? i + 1 : i;
	}

	public static void main(String[] args) {
		BackspaceStringCompare bss = new BackspaceStringCompare();
		bss.backspaceCompare("bbb##tt", "bbb###tt");
	}
}
