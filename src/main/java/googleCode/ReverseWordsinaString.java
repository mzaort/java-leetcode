package googleCode;

public class ReverseWordsinaString {
	public static void main(String[] args) {
		ReverseWordsinaString rws = new ReverseWordsinaString();
		System.out.println(rws.reverseWords2("   a   b  c d   e  "));
	}

	public String reverseWords(String s) {
		char[] ch = new char[s.length() + 1];

		int i = s.length() - 1, j = 0;

		while (i >= 0) {
			while (i >= 0 && s.charAt(i) == ' ')
				i--;
			while (i >= 0 && s.charAt(i) != ' ')
				ch[j++] = s.charAt(i--);
			ch[j++] = ' ';
		}
		j--;
		while (j >= 0 && ch[j] == ' ')
			j--;

		i = 0;
		while (i <= j) {
			int frm = i;
			while (i <= j && ch[i] != ' ')
				i++;
			swap(ch, frm, i - 1);
			i++;
		}

		return new String(ch, 0, j + 1);
	}

	public String reverseWords2(String s) {
		char[] ch = new char[s.length()];
		int j = 0;
		for (int i = s.length() - 1; i >= 0;) {
			for (; i >= 0 && s.charAt(i) == ' '; i--);
			for (; i >= 0 && (ch[j++] = s.charAt(i--)) != ' ';);
		}
		for (j--; j >= 0 && ch[j] == ' '; j--);
		for (int i = 0; i <= j; i++) {
			int frm = i;
			for (; i <= j && ch[i] != ' '; i++);
			swap(ch, frm, i - 1);
		}
		return new String(ch, 0, j + 1);
	}

	private void swap(char[] ch, int frm, int end) {
		for (; frm < end; frm++, end--) {
			char tmp = ch[frm];
			ch[frm] = ch[end];
			ch[end] = tmp;
		}
	}
}
