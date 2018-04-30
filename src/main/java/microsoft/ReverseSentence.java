package microsoft;

public class ReverseSentence {

	public static void main(String[] args) {
		ReverseSentence rs = new ReverseSentence();
		String s = "      I am a  student; ";
		String[] str = s.split(" ");
		for (int i = 0; i < str.length; i++) {
			System.out.println(
					i + "\t" + str[i] + "\t" + (str[i] == "") + "\t" + (str[i] == null) + "\t" + (str[i].equals("")));
		}
		System.out.println(rs.reverse(s));
		char[] cstr = s.toCharArray();
		rs.reverse(cstr);
		for (char c : cstr) {
			System.out.print(c);
		}
	}

	public String reverse(String str) {
		int len = str.length();
		if (len <= 1) return str;

		StringBuilder sb = new StringBuilder();
		int index, end = len;

		do {
			index = str.lastIndexOf(" ", end - 1);
			sb.append(str.substring(index + 1, end));
			if (index != -1) {
				sb.append(" ");
				end = index;
			}
		} while (index != -1);

		return new String(sb);
	}

	public void reverse(char[] cstr) {
		int len = cstr.length;
		if (len <= 1) return;

		int start = 0, end;
		for (; start < len && cstr[start] == ' '; start++);
		while (start != len) {
			for (end = start + 1; end < len && cstr[end] != ' '; end++);
			reverse(cstr, start, end - 1);
			for (start = end; start < len && cstr[start] == ' '; start++);
		}
		reverse(cstr, 0, len - 1);
	}

	public void reverse(char[] cstr, int frm, int end) {
		for (; frm < end; frm++, end--) {
			char tmp = cstr[frm];
			cstr[frm] = cstr[end];
			cstr[end] = tmp;
		}
	}

}